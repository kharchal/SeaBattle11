package ua.com.hav.battleship;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Field {
    private final int SIZE;
    private Cell[][] cells;
    private Fleet fleet;
    private AI goodShut;
    private boolean isHuman;

    public Field() {
//        System.out.println("new Field");
        SIZE = GameConfig.getFieldSize();
        fleet = new Fleet();
//        System.out.println("fleet size= " + fleet.getFleetSize());;
        cells = new Cell[SIZE][];
        for (int i = 0; i < SIZE; i++) {
            cells[i] = new Cell[SIZE];
            for (int j = 0; j < SIZE; j++) {
                cells[i][j] = new Cell();
            }
        }
//        System.out.println("new Field created");
    }

    public void setHuman() {
        isHuman = true;
//        System.out.println(isHuman);
    }

    public void randomFleet() {
//        System.out.println("random fleet");
//        System.out.println(this);
        Random r = new Random();
        for (int i = 0; i < fleet.getFleetSize(); i++) {
            AbstractShip place = new Ship(0);
            AbstractShip ship = fleet.getShip(i);
//            System.out.println("finding place for: " + ship);
            do {
                place.setX(r.nextInt(GameConfig.getFieldSize()));
                place.setY(r.nextInt(GameConfig.getFieldSize()));
                place.setV(r.nextBoolean());
//                System.out.println("place: " + place);
            } while (!tryToPlant(ship, place));
            plant(ship, place);
//            System.out.println(this);
        }
        unmarkAll();
    }

    private void unmarkAll() {
        for (int i = 0; i < GameConfig.getFieldSize(); i++) {
            for (int j = 0; j < GameConfig.getFieldSize(); j++) {
                cells[i][j].setShut(false);
            }

        }
    }


    private void plant(AbstractShip ship, AbstractShip place) {
        int startX = place.getX();
        int startY = place.getY();
        boolean v = place.isV();
        int n = ship.getSize();

        int endX = (v) ? startX : startX + n - 1;
        int endY = (v) ? startY + n - 1 : startY;
//        System.out.println("P: " + startX + " " + endX + ": " + startY + " " + endY + ": " + v + " " + n);
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                cells[j][i].setShip(ship);

            }
        }
        ship.setV(v);
        ship.setX(startX);
        ship.setY(startY);
        markAround(ship);
    }



    private boolean tryToPlant(AbstractShip ship, AbstractShip place) {
        int startX = place.getX();
        int startY = place.getY();
        boolean v = place.isV();
        int n = ship.getSize();
        if ((startX + n) >= GameConfig.getFieldSize() ||
                (startY + n) >= GameConfig.getFieldSize()) {
            return false;
        }
        int endX = (v) ? startX : startX + n - 1;
        int endY = (v) ? startY + n - 1 : startY;
//        System.out.println("TP: " + startX + " " + endX + ": " + startY + " " + endY + ": " + v + " " + n);
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (cells[j][i].isShut()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void manualFleet() {

    }

    public boolean check(int y, int x) {
        if (y < 0 || y >= GameConfig.getFieldSize() ||
                x < 0 || x >= GameConfig.getFieldSize()) {
            return true;
        }
        return cells[y][x].isShut();
    }

    private class AI {
        List<Position> goodShots;
        List<Position> futureShots;
        boolean direction;

        AI() {
            goodShots = new ArrayList<>();
//            System.out.println("new AI()");

        }

        private void aroundFutureShots() {
            final int x = goodShots.get(0).getX();
            final int y = goodShots.get(0).getY();
            futureShots = Stream.of(
                    new Position(y + 1, x),
                    new Position(y - 1, x),
                    new Position(y, x - 1),
                    new Position(y, x + 1))
                    .filter(p -> exist(p.getY(), p.getX()))
                    .collect(Collectors.toList());
//            futureShots.stream().forEach(System.out::println);

        }

        public Position nextMove() {
            Random r = new Random();
            int direction = r.nextInt(futureShots.size());
//            futureShots.stream().forEach(System.out::println);
//            System.out.println(direction);
            Position p = futureShots.remove(direction);
//            futureShots.stream().forEach(System.out::println);
            System.out.println("AI recomends to shoot at " + p);
            return p;
        }

        public void addGoodShut(int y, int x) {
            goodShots.add(new Position(y, x));
//            System.out.println("add good shot: y=" + y + ", x=" + x);
            if (goodShots.size() == 1) {
                aroundFutureShots();
            } else {
                findDirectionForFutureShots();
            }
        }

        private void findDirectionForFutureShots() {
            if (goodShots.size() == 2) {
                if (goodShots.get(0).getX() == goodShots.get(1).getX()) {
                    direction = true;
                }
            }
            if (direction) {
                xFutureShots();
            } else {
                yFutureShots();
            }

        }

        private void yFutureShots() {
            int min = goodShots.stream().map(p -> p.getX()).min(Integer::compareTo).get();
            int max = goodShots.stream().map(p -> p.getX()).max(Integer::compareTo).get();
            int y = goodShots.get(0).getY();
            futureShots = Stream.of(
                    new Position(y, min - 1),
                    new Position(y, max + 1))
                    .filter(p -> exist(p.getY(), p.getX()))
                    .collect(Collectors.toList());
//            futureShots.stream().forEach(System.out::println);
        }

        private void xFutureShots() {
            int min = goodShots.stream().map(p -> p.getY()).min(Integer::compareTo).get();
            int max = goodShots.stream().map(p -> p.getY()).max(Integer::compareTo).get();
            int x = goodShots.get(0).getX();
            futureShots = Stream.of(
                    new Position(min - 1, x),
                    new Position(max + 1, x))
                    .filter(p -> exist(p.getY(), p.getX()))
                    .collect(Collectors.toList());
//            futureShots.stream().forEach(System.out::println);
        }
    }

    public boolean shut(int y, int x) {
        if (goodShut != null) {
            Position p = goodShut.nextMove();
            x = p.getX();
            y = p.getY();
            System.out.println("AI rules");
        }
        Cell cell = cells[y][x];
        if (!cell.isShut()) {
            cell.setShut(true);
            AbstractShip ship = cell.getShip();
            if (ship == null) {
//                if (goodShut != null) {
//                    goodShut.changeDirection();
//                    System.out.println("change dir?");
//                }
                return false;
            }
            if (goodShut == null) {
                System.out.println("AI == null " + isHuman);
                if (isHuman) {
                    goodShut = new AI();

                }
                System.out.println("AI=" + goodShut);
            }
            if (ship.shut()) {
                markAround(ship);
                goodShut = null;
//                System.out.println("AI = null");
            }
            if (goodShut != null) {
                goodShut.addGoodShut(y, x);
            }
            return true;
        }
        return false;
    }

    private void markAround(AbstractShip ship) {
        int startX = ship.getX() - 1;
        int startY = ship.getY() - 1;
        int n = ship.getSize();
        boolean v = ship.isV();
        int endX = (v) ? ship.getX() + 1 : ship.getX() + n;
        int endY = (v) ? ship.getY() + n : ship.getY() + 1;
//        System.out.println("MA: " + startX + " " + endX + ": " + startY + " " + endY + ": " + v + " " + n);

        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                markShut(j, i);
            }
        }
    }

    private boolean exist(int y, int x) {
        return (x >= 0 && x < GameConfig.getFieldSize() && y >= 0 && y < GameConfig.getFieldSize());
    }


    private void markShut(int y, int x) {
        if (exist(y, x)) {
            cells[y][x].setShut(true);
        }
    }

    public int getAliveDecks() {
        return fleet.getAliveDecks();
    }

    @Override
    public String toString() {
        StringBuilder header = new StringBuilder("  ");
        for (int i = 0; i < GameConfig.getFieldSize(); i++) {
            header.append(i).append(" ");
        }
        StringBuilder sb = new StringBuilder("\r\n");
//        String header = "  0 1 2 3 4 5 6 7 8 9";
        sb.append(header);
        sb.append(isHuman);
        sb.append("\r\n");
        for (int i = 0; i < GameConfig.getFieldSize(); i++) {
            sb.append(i).append(" ");
            for (int j = 0; j < GameConfig.getFieldSize(); j++) {
                sb.append(cells[i][j]).append(" ");
            }
            sb.append(i + "\r\n");
        }
        sb.append(header).append("\r\n");
        sb.append("\r\n");
        return sb.toString();
    }
}
