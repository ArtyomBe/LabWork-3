package animals.humans;

import animals.humans.states.State;
import interfaces.CoordinatesManager;
import interfaces.Grinning;
import interfaces.Movable;
import interfaces.Sayable;
import interfaces.Stayable;
import interfaces.Upperable;

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

    private String getLocationName(int x, int y) {
        if (x == 100 && y == 125) {
            return String.format("Под луной - (%d, %d)", x, y);
        } else if (x == 20 && y == 165) {
            return String.format("Лес - (%d, %d)", x, y);
        } else if (x == 60 && y == 75) {
            return String.format("Возле двери - (%d, %d)", x, y);
        } else if (x == 65 && y == 65) {
            return String.format("Шевелящиеся кости - (%d, %d)", x, y);
        } else {
            return String.format("Неизвестное местоположение - (%d, %d)", x, y);
        }
    }

    @Override
    public void printCoordinates() {
        String location = getLocationName(x, y);
        System.out.printf("%s's coordinates: (%d, %d) - %s%n", name, x, y, location);
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
            String location = getLocationName(x, y);
            System.out.printf("%s is now at coordinates (%d, %d) - %s%n", name, x, y, location);

            timeToReach -= step;
        }

        // Проверка местоположения после перемещения
        System.out.println("Checking location after moving:");
        printCoordinates();
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

    public Upperable hand() {
        Upperable hand = () -> {
            System.out.printf("%s raised his hand %n", name);
        };
        return hand;
    }

    public void pointTo(Object something) {
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
        System.out.printf("%s is moving towards %s %n", name, destination);
    }
}
