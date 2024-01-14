package animals.humans;

import animals.Animal;
import animals.humans.states.State;
import animals.types.Type;
import interfaces.CoordinatesManager;

import java.util.Objects;

public abstract class Human extends Animal implements CoordinatesManager {
    protected int x;
    protected int y;
    protected int health;

    protected Human(String name, int health, int X_0, int Y_0) {
        super(name, Type.HUMAN, true);
        this.health = health;
        this.x = X_0;
        this.y = Y_0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    protected String description = "";
    protected State state = State.NOTHING;

    public abstract void lookAt(Object obj);

    public State getState() {
        return state;
    }

    protected void setState(State state) {
        this.state = state;
    }

    @Override
    public String getDescription() {
        return description;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%s %s", description, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(description, human.description)
                && Objects.equals(name, human.name)
                && Objects.equals(health, human.health);
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, name, health);
    }

    // Новые методы в суперклассе Human
    public void moveTo(int newX, int newY) {
        while (x != newX || y != newY) {
            if (x !=newX) {
                x += (newX > x) ? 1 : -1;
            }

            printCoordinates();

            if (y != newY) {
                y += (newY > y) ? 1 : -1;
            }
        }
    }

    protected String getLocationName(int x, int y) {
        if (x == 100 && y == 125) {
            return String.format("Под луной - (%d, %d)", x, y);
        } else if (x == 20 && y == 165) {
            return String.format("Лес - (%d, %d)", x, y);
        } else if (x == 60 && y == 75) {
            return String.format("Возле двери - (%d, %d)", x, y);
        } else if (x == 65 && y == 65) {
            return String.format("Шевелящиеся кости - (%d, %d)", x, y);
        } else {
            return "";
        }
    }

    // Реализация интерфейса CoordinatesManager
    @Override
    public void printCoordinates() {
        String location = getLocationName(x, y);
        System.out.printf("%s's coordinates: (%d, %d)  %s%n", name, x, y, location);
    }
    public double calculateDistance(Human otherHuman) {
        int xDistance = Math.abs(this.x - otherHuman.x);
        int yDistance = Math.abs(this.y - otherHuman.y);

        double distance = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));

        if (distance <= 5.0) {
            System.out.printf("Distance between %s and %s: %.2f - близко%n", this.getName(), otherHuman.getName(), distance);
        } else if (distance > 5.0 && distance <= 15.0) {
            System.out.printf("Distance between %s and %s: %.2f - довольно-таки недалеко%n", this.getName(), otherHuman.getName(), distance);
        } else {
            System.out.printf("Distance between %s and %s: %.2f - далековато%n", this.getName(), otherHuman.getName(), distance);
        }
        return distance;
    }


}