package ua.com.hav.seabattle;

public abstract class Player {
    protected String name;
    protected boolean isComputer;

    public Field getField() {
        return field;
    }

    protected Field field;
    protected Fleet fleet;
    protected Player opponent;
    protected int moveCount;

    public Player() {
        field = new Field();
        field.init();
        fleet = new Fleet();
        field.plantFleet(fleet);
//        System.out.println("field = " + field);
    }

    public Player(String name, boolean isComputer) {
        this();
        this.name = name;
        this.isComputer = isComputer;
    }

    public abstract void setUpFleet();
    public abstract boolean move();
    public abstract boolean move(int x, int y);

    public abstract boolean isWinner();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    public Player getOpponent() {
        return opponent;
    }

    public int getMoveCount() {
        return moveCount;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", moveCount=" + moveCount +
                ", field=\r\n" + field +
                "\r\n}";
    }

//    public Object[][] getField() {
//        return field.getCells();
//    }
}
