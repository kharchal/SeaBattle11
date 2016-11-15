package ua.com.hav.battleship;

public class Ship extends AbstractShip {
    public int getAliveDecks() {
        return aliveDecks;
    }

    public Ship(int n) {
        super(n);
        aliveDecks = n;
    }

    public void setAliveDecks(int aliveDecks) {
        this.aliveDecks = aliveDecks;
    }

    private int aliveDecks;


    public boolean shut() {
        return (--aliveDecks == 0) ? true : false;
    }

    public String toString(boolean isShut) {
        return (isShut) ? "X" : "O";
    }

    @Override
    public String toString() {
        return "Ship{" +
                "aliveDecks=" + aliveDecks +
                ", x=" + super.getX() + ", y=" + super.getY() +
                "v=" +super.isV() + '}';
    }
}
