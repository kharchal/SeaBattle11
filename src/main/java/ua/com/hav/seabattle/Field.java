package ua.com.hav.seabattle;

import java.util.Random;

public class Field {
    private Cell[][] cells;
    Fleet fleet;

    public Field() {

    }

    public void init() {
        cells = new Cell[10][10];
        for (int i = 0; i < cells.length; i++) {
            cells[i] = new Cell[10];
            for (int j = 0; j < cells[i].length; j++) {
                Cell cell = new Cell(new Nope(), this);
                cell.x = i;
                cell.y = j;
                cells[i][j] = cell;


//                cells[i][j] = ElementFactory.getRandomElement(i, j);
            }
        }
    }

    public void plantFleet(Fleet fleet) {
        this.fleet = fleet;
        Random r = new Random();
        Ship[] ships = fleet.getShips();
        for (int i = 0; i < ships.length; i++) {
            int x;
            int y;
            boolean b;
            boolean v;
            int cnt = 0;
            do {
                if (cnt++ > 200) {
                    throw new RuntimeException("Pardon! " + cnt);
                }
                x = r.nextInt(10);
                y = r.nextInt(10);
                v = r.nextBoolean();
                b = tryToPlant(ships[i], x, y, v);
//                System.out.println(x + ", " + y + ": " + b);
            }
            while (!b);
            plantShip(ships[i], x, y, v);

            System.out.println(this);
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                mark(i, j, false);
            }
        }
    }

    private void plantShip(Ship ship, int x, int y, boolean isVertical) {
        int n = ship.getN();
        if (isVertical) {
            for (int i = 0; i < n; i++) {
                cells[x + i][y].element = ship;
            }

        } else {
            for (int i = 0; i < n; i++) {
                cells[x][y + i].element = ship;
            }

        }
        ship.isVertical = isVertical;
        ship.x = x;
        ship.y = y;
        markAround(cells[x][y]);
    }

    public void markAround(Cell cell) {
        System.out.println("mark around:");
        int x = cell.element.x;
        int y = cell.element.y;
        boolean v = !cell.element.isVertical;
        int n = cell.element.getN();
        System.out.println(x + " " + y + " " + v + " " + n);
        int startX = x - 1;
        int startY = y - 1;
        int endX = (v) ? x + 1 : x + n;
        int endY = (v) ? y + n : y + 1;
        System.out.println("X: " + startX + " - " + endX);
        System.out.println("Y: " + startY + " - " + endY);

        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                mark(i, j, true);
            }
        }


    }

    private void mark(int i, int j, boolean b) {
        if (i >= 0 && i < 10 && j >= 0 && j < 10) {
            cells[i][j].isShut = b;
        }
    }

    private boolean tryToPlant(Ship ship, int x, int y, boolean isVertical) {
        int n = ship.getN();
        if (isVertical) {
            if ((x + n) > 10) {
                return false;
            }
            for (int i = 0; i < n; i++) {
                if (cells[x + i][y].isShut) {
                    return false;
                }
            }
        } else {
            if ((y + n) > 10) {
                return false;
            }
            for (int i = 0; i < n; i++) {
                if (cells[x][y + i].isShut) {
                    return false;
                }
            }
        }
        return true;
    }

    public Cell[][] getCells() {
//        System.out.println("return cells");
//        System.out.println(this);
        return cells;
    }

    @Override
    public String toString() {
        String str = "\r\n";
        String numb = "    0 1 2 3 4 5 6 7 8 9\r\n";
        String dashes = "    - - - - - - - - - -\r\n";
        str += numb + dashes;
        for (int i = 0; i < cells.length; i++) {
            str += i + " | ";
            for (int j = 0; j < cells[i].length; j++) {
                Cell cell = cells[i][j];
                str += cell.toString() + " ";
            }
            str += "| " + i + "\r\n";
        }
        str += dashes + numb;
        return str + "\r\n alive decks: " + fleet.aliveDecks();
    }
}
