package animals.humans;

import animals.Animal;
import animals.humans.states.State;
import animals.types.Type;
import interfaces.CoordinatesManager;

import java.util.Objects;

public abstract class Human extends Animal implements CoordinatesManager {
    // Поля класса
    protected int x;
    protected int y;
    protected int health;
    protected int fear;
    protected String description = "";
    protected State state = State.NOTHING;

    protected Human(String name, int health, int X_0, int Y_0, int fear) {
        super(name, Type.HUMAN, true);
        this.health = health;
        this.x = X_0;
        this.y = Y_0;
        this.fear = fear;
    }

    // Методы для работы с координатами
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

    public String getLocationName(int x, int y) {
        if (x == 100 && y == 125) {
            return ("- под луной");
        } else if (x == 20 && y == 165) {
            return ("- лес");
        } else if (x == 60 && y == 75) {
            return ("- возле двери");
        } else if (x == 65 && y == 65) {
            return ("- шевелящиеся кости");
        } else if (x == 35 && y == 15) {
            return ("- Смэки и Луис");
        } else if (x == -100 && y == -100) {
            return ("- ИТМО ");
        } else {
            return "";
        }
    }

    public void printCoordinates() {
        String location = getLocationName(x, y);
        System.out.printf("координаты %s: (%d, %d) %s->%n", name, x, y, location);
    }

    public double calculateDistance(Human otherHuman) {
        int xDistance = Math.abs(this.x - otherHuman.x);
        int yDistance = Math.abs(this.y - otherHuman.y);

        return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
    }

    // Методы для работы со здоровьем и страхом
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getFear() {
        return fear;
    }

    public void setFear(int fear) {
        this.fear = fear;
    }

    public void printFearLevel() {
        System.out.printf("Fear level of %s: %d%n", name, fear);
    }

    public void increaseFear(int amount) {
        System.out.printf("Cтрах %s поменялся с %d на %d: ", name, fear, fear + amount);
        for (int i = 0; i < Math.abs(amount); i++) {
            fear++;
            System.out.printf("%d -> ", fear);
        }
        System.out.println();
        setFear(fear);
    }

    public void decreaseFear(int amount) {
        fear -= amount;
        if (fear < 0) {
            fear = 0;
        }
        setFear(fear);
    }

    // Методы для работы с состоянием
    public State getState() {
        return state;
    }

    protected void setState(State state) {
        this.state = state;
    }

    // Методы для работы с описанием
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

    // Методы для работы с взаимодействием
    public abstract void lookAt(Object obj);

    // Методы для общих операций
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(description, human.description)
                && Objects.equals(name, human.name)
                && health == human.health
                && fear == human.fear;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, name, health, fear);
    }

    @Override
    public void moveTo(int newX, int newY) throws InterruptedException {
        int prevX = x;
        int prevY = y;

        while (x != newX || y != newY) {
            if (x != newX) {
                int stepX = (newX > x) ? 1 : -1;
                x += stepX;

                if (Math.abs(x - prevX) >= 5) {
                    Thread.sleep(100);
                    printCoordinates();
                    prevX = x;
                }
            }

            if (y != newY) {
                int stepY = (newY > y) ? 1 : -1;
                y += stepY;

                if (Math.abs(y - prevY) >= 5) {
                    Thread.sleep(150);
                    printCoordinates();
                    prevY = y;
                }
            }
        }
        String location = getLocationName(x, y);
        System.out.printf("%s пришел в точку: (%d, %d) %s->%n", name, x, y, location);
    }

    public void printState() {
        System.out.printf("-----------------states-----------------%n");
        System.out.printf("Человек: %s%n", name);
        System.out.printf("Тут или нет: %s%n", isAlive);
        System.out.printf("Здоровье: %d%n", health);
        System.out.printf("Уровень страха: %d%n", fear);
        System.out.printf("Координаты: (%d, %d)%n", x, y);
        System.out.printf("----------------------------------------%n");
    }
}
