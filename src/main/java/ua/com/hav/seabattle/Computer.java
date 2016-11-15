package ua.com.hav.seabattle;

public class Computer extends Player{

    private boolean isWinner;

    public Computer(String name) {
        super(name, true);
    }

    public void setUpFleet() {

    }

    // TODO: 29.10.16
    public boolean move() {
        moveCount++;
        System.out.println(super.toString());
        boolean goodShot = (Math.random() < 0.1) ? true : false;
        if (goodShot) {
            isWinner = (Math.random() < 0.1) ? true : false;
        }
        return goodShot;

    }

    public Field getField() {
        return field;
    }

    public boolean move(int x, int y) {
        return field.getCells()[x][y].shut();
    }

    // TODO: 29.10.16
    public boolean isWinner() {
        return isWinner;
    }
}
