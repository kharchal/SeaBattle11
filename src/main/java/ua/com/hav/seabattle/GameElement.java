package ua.com.hav.seabattle;

public class GameElement {
    private Element[] elements;
    private int elementsCount;
    private boolean isReady;

    public GameElement(int n) {
        elements = new Element[n];
    }

    public boolean addElement(Element element) {
        if (isReady) {
            return false;
        }
        elements[elementsCount++] = element;
        isReady();
        return true;
    }

    private void isReady() {
        if (elementsCount == elements.length) {
            isReady = true;
        }
    }
}
