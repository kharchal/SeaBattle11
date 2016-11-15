package ua.com.hav.seabattle;

public class Ship extends Element{
    public int getAliveDecks() {
        return aliveDecks;
    }

    private int aliveDecks;



    public Ship(int n) {
        super(n);
        aliveDecks = n;
    }

    public boolean isDead() {
        return (aliveDecks <= 0) ? true : false;
    }
    public String toString(boolean isShut) {
        return (isShut) ? "X" : "O";
    }

    public boolean shut() {

        --aliveDecks;
        System.out.println("alive decks=" + aliveDecks);
        return true;
    }
}
