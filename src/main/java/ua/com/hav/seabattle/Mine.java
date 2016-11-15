package ua.com.hav.seabattle;

public class Mine extends Element {

    public Mine(){}



    public String toString(boolean isShut) {
        return (isShut) ? "*" : "#";
    }

    public boolean shut() {
        return true;
    }

    public boolean isDead() {
        return false;
    }
}
