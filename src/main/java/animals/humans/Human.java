package animals.humans;

import animals.Animal;
import animals.humans.states.State;
import animals.types.Type;

import java.util.Objects;

public abstract class Human extends Animal {
    protected Human(String name, boolean isAlive) {
        super(name, Type.HUMAN, isAlive);
    }

    protected String description = "";
    protected State state = State.NOTHING;
    protected int x; // координата x
    protected int y; // координата y

    public abstract void speakToSomeone(Object obj);

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

    // Добавим методы для работы с координатами
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

    @Override
    public String toString() {
        return String.format("%s %s at coordinates (%d, %d)", description, name, x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(description, human.description)
                && Objects.equals(name, human.name)
                && Objects.equals(isAlive, human.isAlive())
                && x == human.x
                && y == human.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, name, isAlive, x, y);
    }
}
