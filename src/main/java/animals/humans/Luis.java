package animals.humans;

import animals.humans.states.State;
import interfaces.*;

public class Luis extends Human implements Terrible, Screamable, Cryable, Thinkable, Fallable {
    private int fear;

    public Luis(boolean isAlive, int health, int X_0, int Y_0, int fear) {
        super("Luis", health, X_0, Y_0, fear);
        setDescription("dead");
    }

    @Override
    public void lookAt(Object obj) {
        System.out.printf("%s поглядел %s%n", name, obj);
    }

    @Override
    public void terrible() {
        System.out.printf("%s's horror grew%n", name);
        setState(State.FEAR);
        System.out.println("The gentle but relentless pressure on the brain increased%n");
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

    public int getFear() {
        return fear;
    }

    public void setFear(int fear) {
        this.fear = fear;
    }

    @Override
    public void increaseFear(int amount) {
        super.increaseFear(amount);
    }

    @Override
    public void decreaseFear(int amount) {
        super.decreaseFear(amount);
    }
}