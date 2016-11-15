package ua.com.hav.seabattle;

public class Human extends Player {

    public Human(String name) {
        super(name, false);
    }

    public void setUpFleet() {

    }

    public boolean move() {
        return false;
    }

    public boolean move(int x, int y) {
        return false;
    }

    public boolean isWinner() {
        return false;
    }
}
