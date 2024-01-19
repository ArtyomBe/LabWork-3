package animals.humans;

import animals.humans.states.State;
import interfaces.*;

import java.util.Objects;

public class Luis extends Human implements Screamable, Cryable, Thinkable, Fallable {

    //private int fear;

    public Luis(int health, int fear) {
        super("Luis", health, fear);
        setDescription("alive");
    }

    public void lookAt(Object obj) {
        System.out.printf("%s поглядел %s%n", name, obj);
    }

    @Override
    public void scream() {
        System.out.printf("%s застонал%n", name);
        setState(State.SCREAM);
        System.out.printf("Глаза его расширились, и он поднес кулаки ко рту.%n");
    }

    @Override
    public void cry() {
        System.out.printf("Щеки %s были мокрыми, и он осознал, что плачет от предельного ужаса%n", name);
        setState(State.CRY);
    }

    @Override
    public void croak() {
        System.out.printf("Но %s смог только слабо прохрипеть.%n", name);
        setState(State.CROAK);
    }

    @Override
    public void think(String minds) {
        System.out.printf("%s\u001B[3m подумал %s\u001B[0m%n", name, minds);
        setState(State.THINK);
    }

    @Override
    public void fallOnKnees() {
        System.out.printf("%s упал на колени%n", name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isAlive, health, fear);
    }
}
