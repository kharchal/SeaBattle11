package ua.com.hav.battleship;

public abstract class AbstractShip {
    private int size;
    private int x;
    private int y;
    private boolean v;//true - vertical, false - horizontal

    public AbstractShip(int n) {
        this.size = n;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isV() {
        return v;
    }

    public void setV(boolean v) {
        this.v = v;
    }

    public abstract boolean shut();
    public abstract String toString(boolean isShut);
    public abstract int getAliveDecks();
}
