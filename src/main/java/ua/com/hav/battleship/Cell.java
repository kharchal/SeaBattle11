package ua.com.hav.battleship;

public class Cell {
    private AbstractShip ship;
    private boolean isShut;

    public AbstractShip getShip() {
        return ship;
    }

    public void setShip(AbstractShip ship) {
        this.ship = ship;
    }

    public boolean isShut() {
        return isShut;
    }

    public void setShut(boolean shut) {
        isShut = shut;
    }

    @Override
    public String toString() {
        if (ship == null) {
            return (isShut) ? "*" : "~";
        } else {
            return ship.toString(isShut);
        }
    }
}
