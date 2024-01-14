package interfaces;

public interface CoordinatesManager {
    void setCoordinates(int x, int y);

    int getX();

    int getY();

    void printCoordinates();

    void moveTo(int newX, int newY) throws InterruptedException;
}
