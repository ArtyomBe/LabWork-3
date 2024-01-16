package animals.humans;

import animals.Animal;
import animals.humans.states.State;
import animals.types.Type;
import exceptions.InvalidHumanCreationException;

import java.util.Objects;

public abstract class Human extends Animal {

    protected int health;
    protected int fear;
    protected String description = "";
    protected State state = State.NOTHING;

    protected Human(String name, int health, int fear) {
        super(name, Type.HUMAN, true);
        this.health = health;
        this.fear = fear;
        setDescription("alive");
        if (health == 0 && isAlive) {
            throw new InvalidHumanCreationException(this);
        }
    }

    public void setHealth(int health) {
        this.health = health;
        if (health <= 0) {
            setDescription("dead");
            isAlive= false;
        }
    }

    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }


    public void setFear(int fear) {
        this.fear = fear;
    }

    public void increaseFear(int amount) {
        System.out.printf("Уровнь стараха %s изменился с %d на %d: ", name, fear, fear + amount);
        System.out.println();
    }

    public void decreaseFear(int amount) {
        fear -= amount;
        if (fear < 0) {
            fear = 0;
        }
    }

    protected void setState(State state) {
        this.state = state;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%s %s", description, name);
    }

    public void printState() {
        System.out.printf("-----------------states-----------------%n");
        System.out.printf("Человек: %s%n", name);
        System.out.printf("Живой: %s%n", isAlive);
        System.out.printf("Здоровье: %d%n", health);
        System.out.printf("Уровень страха: %d%n", fear);
        System.out.printf("----------------------------------------%n");
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, health, fear, isAlive);
    }
}
