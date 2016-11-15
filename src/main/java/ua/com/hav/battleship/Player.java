package ua.com.hav.battleship;

import java.util.Random;
import java.util.Scanner;

public class Player {
    private String name;
    private Field field;
    private boolean isHuman;

    public Player() {
//        System.out.println("new Player");
        field = new Field();
        field.randomFleet();
//        System.out.println(field);
    }

    public void setHuman() {
        isHuman = true;
        field.setHuman();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAliveDecks() {
        return field.getAliveDecks();
    }

    public boolean shut(Player opponent) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        int x;
        int y;

        do {
            System.out.println("player " + name + " enters coordinates:");
            if (isHuman) {
                System.out.println("Y:?");
                y = s.nextInt();
                System.out.println("X:?");
                x = s.nextInt();
            } else {
                x = r.nextInt(GameConfig.getFieldSize());
                y = r.nextInt(GameConfig.getFieldSize());
            }
        } while (opponent.field.check(y, x));

        s.nextLine();
        System.out.println("accepted: " + y + ", " + x);

        boolean result = opponent.field.shut(y, x);
//        System.out.println(this);
//        System.out.println(opponent);
        System.out.println("player " + name + " shuts at: " + y + ", " + x);
        System.out.println(result ? "shoot again ": "you missed");
        return result;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                " alive decks=" + field.getAliveDecks() +
                " isHuman=" + isHuman +
                field;
    }
}
