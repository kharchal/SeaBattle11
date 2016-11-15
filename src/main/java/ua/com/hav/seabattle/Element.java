package ua.com.hav.seabattle;

public abstract class Element {
    int x;
    int y;
    protected int n;
    protected boolean isVertical;

    public Element(){}


    public Element(int n) {
        this.n = n;
    }



    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public abstract String toString(boolean b);


    public abstract boolean shut();

    public abstract boolean isDead();
}
