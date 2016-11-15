package ua.com.hav.seabattle;

public class Cell {
    protected int x;
    protected int y;
    protected boolean isShut;
    Element element;
    Field field;


    Cell (Element element, Field field) {
        this.element = element;
        this.field = field;
    }

    public boolean isShut() {
        return isShut;
    }

    public String toString(){
        if (element == null) {
            return ":";
        } else {
            return element.toString(isShut);
        }
    }

    public boolean shut() {
        if (!isShut) {
            isShut = true;
            boolean goodShut = false;
            if (element != null) {
                goodShut = element.shut();
            }
            System.out.println("good shut = " + goodShut);
            System.out.println("is dead = " + element.isDead());
            if (element.isDead()) {
                field.markAround(this);
            }
            return goodShut;
        }
        System.out.println("You've shut there!");
        return false;
    }


}
