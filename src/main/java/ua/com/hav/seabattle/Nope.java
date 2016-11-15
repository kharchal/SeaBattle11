package ua.com.hav.seabattle;

public class Nope extends Element {


    public String toString(boolean isShut) {
        return (isShut) ? "*" : "~";
    }

    public boolean shut() {
        return false;
    }

    public boolean isDead() {
        return false;
    }


}
