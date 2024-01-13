package animals.humans;

import animals.Animal;
import animals.humans.states.State;
import animals.types.Type;

import java.util.Objects;

public abstract class Human extends Animal {
    protected int x;
    protected int y;
    protected int health;

    protected Human(String name, int health, int initialX, int initialY) {
        super(name, Type.HUMAN, true); // Возвращаем isAlive в аргументы конструктора суперкласса
        this.health = health;
        this.x = initialX;
        this.y = initialY;
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
}
