package animals.humans;

import animals.humans.states.State;
import interfaces.*;

import java.util.Objects;

public class Pascoe extends Human implements Stayable, Grinning, Sayable {

    public Pascoe(boolean isAlive, int health, int fear) {
        super("Pascoe", health, fear);
        setDescription("alive");
    }

    //@Override
    public void lookAt(Object obj) {
        System.out.printf("%s повернулся к %s%n", name, obj);
    }

    @Override
    public void stayAround(Object obj) {
        System.out.printf("%s stay around %s%n", name, obj);
    }

    @Override
    public void grin() {
        System.out.printf("%s was grinning%n", name);
        setState(State.SNEER);
        System.out.println("The bloody lips parted, exposing teeth; the disfigured face shone ghastly white under the moon.%n");
    }

    public Upperable hand() {
        Upperable hand = () -> {
            System.out.printf("%s поднял его руку%n", name);
        };
        return hand;
    }

    public void pointTo(Object something) {
        System.out.printf("%s указал на %s%n", name, something);
    }

    @Override
    public void sayTo(Human person, String speech) {
        setState(State.SPEAK);
        System.out.printf("%s say to %s that %s%n", name, person.getName(), speech);
    }
    @Override
    public void decreaseFear(int amount) {
        super.decreaseFear(amount);

        // Дополнительные действия для Pascoe при уменьшении страха, если нужно
    }
    @Override
    public int hashCode() {
        return Objects.hash(isAlive, health, fear);
    }
}
