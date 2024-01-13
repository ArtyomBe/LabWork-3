package animals.humans;

import animals.humans.states.State;
import interfaces.CoordinatesManager;
import interfaces.*;

public class Luis extends Human implements Terrible, Screamable, Cryable, Thinkable, Fallable, CoordinatesManager {
    public Luis(boolean isAlive, int health, int initialX, int initialY) {
        super("Luis", health, initialX, initialY);
        setDescription("alive");
    }

    @Override
    public void lookAt(Object obj) {
        System.out.printf("%s looked at %s %n", name, obj);
    }

    @Override
    public void terrible() {
        System.out.printf("%s's horror grew %n", name);
        setState(State.FEAR);
        System.out.println("The gentle but relentless pressure on the brain increased %n");
    }

    @Override
    public void scream() {
        System.out.printf("%s groaned %n", name);
        setState(State.SCREAM);
        System.out.println("His eyes widened and he raised his fists to his mouth. His cheeks were wet, and he realized that he was crying from extreme terror. %n");
    }

    @Override
    public void cry() {
        System.out.printf("%s's cheeks were wet, and he realized that he was crying from extreme terror. %n", name);
        setState(State.CRY);
    }

    @Override
    public void croak() {
        System.out.printf("But %s could only croak weakly %n", name);
        setState(State.CROAK);
    }

    @Override
    public void think(String minds) {
        System.out.printf("%s is thinking that %s %n", name, minds);
        setState(State.THINK);
    }

    @Override
    public void fallOnKnees() {
        System.out.printf("%s fell to his knees %n", name);
    }

    // Реализация интерфейса CoordinatesManager
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
