package animals.humans;

import animals.humans.states.State;
import interfaces.*;

import java.util.Objects;

public class Pascoe extends Human {

    public Pascoe(int health, int fear) {
        super("Pascoe", health, fear);
        setDescription("alive");
    }

    //@Override
    public void lookAt(Object obj) {
        System.out.printf("%s повернулся к %s%n", name, obj);
    }

    public Upperable hand() {
        return () -> System.out.printf("%s поднял его руку%n", name);
    }

    public void pointTo(Object something) {
        System.out.printf("%s указал на %s%n", name, something);
    }


    public void sayTo(Human person, String speech) {
        setState(State.SPEAK);
        System.out.printf("%s say to %s that %s%n", name, person.getName(), speech);
    }
    @Override
    public void decreaseFear(int amount) {
        super.decreaseFear(amount);
    }
    @Override
    public int hashCode() {
        return Objects.hash(isAlive, health, fear);
    }
}
