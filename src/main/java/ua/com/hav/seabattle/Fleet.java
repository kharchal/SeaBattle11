package ua.com.hav.seabattle;

public class Fleet {
    private Ship[] ships;
    private Mine[] mines;

    public Fleet() {
        ships = new Ship[10];
        int index = 0;
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                ships[index++] = new Ship(5 - i);
            }
        }
        mines = new Mine[10];
        for (int i = 0; i < 10; i++) {
            mines[i] = new Mine();
        }

    }

    public Ship[] getShips() {
        return ships;
    }

    public void setShips(Ship[] ships) {
        this.ships = ships;
    }

    public Mine[] getMines() {
        return mines;
    }

    public void setMines(Mine[] mines) {
        this.mines = mines;
    }

    public int aliveDecks() {
        int aliveDecks = 0;
        for (int i = 0; i < ships.length; i++) {
            aliveDecks += ships[i].getAliveDecks();
        }
        return aliveDecks;
    }
}
