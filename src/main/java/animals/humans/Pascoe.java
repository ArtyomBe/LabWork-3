package animals.humans;

import animals.humans.states.State;
import interfaces.*;

public class Pascoe extends Human implements Stayable, Grinning, Movable, Sayable, CoordinatesManager {
    public Pascoe(boolean isAlive, int health, int initialX, int initialY) {
        super("Pascoe", health, initialX, initialY);
        setDescription("dead");
    }

    @Override
    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void printCoordinates() {
        System.out.printf("%s's coordinates: (%d, %d)%n", name, x, y);
    }

    @Override
    public void moveTo(int destinationX, int destinationY, int speed) {
        int deltaX = destinationX - x;
        int deltaY = destinationY - y;

        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        double timeToReach = distance / speed;

        while (timeToReach > 0) {
            double step = Math.min(10, timeToReach); // Шаг не более 10 единиц
            x += (int) (deltaX / distance * step);
            y += (int) (deltaY / distance * step);

            // Вывод координат
            System.out.printf("%s is now at coordinates (%d, %d)%n", name, x, y);

            timeToReach -= step;
        }
    }

    @Override
    public void lookAt(Object obj) {
        System.out.printf("%s turned around to %s %n", name, obj);
    }

    @Override
    public void stayAround(Object obj) {
        System.out.printf("%s stay around %s %n", name, obj);
    }

    @Override
    public void grin() {
        System.out.printf("%s was grinning %n", name);
        setState(State.SNEER);
        System.out.println("The bloody lips parted, exposing teeth; the disfigured face shone ghastly white under the moon. %n");
    }

    public Upperable hand(){
        Upperable hand = () -> {
            System.out.printf("%s raised his hand %n", name);
        };
        return hand;
    }

    public void pointTo(Object something){
        System.out.printf("%s point out to %s %n", name, something);
    }

    @Override
    public void sayTo(Human person, String speech) {
        setState(State.SPEAK);
        System.out.printf("%s say to %s that %s %n", name, person.getName(), speech);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void moveTo(Object destination) {

    }
}
