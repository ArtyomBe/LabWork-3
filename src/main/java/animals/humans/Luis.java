package animals.humans;

import animals.humans.states.State;
import interfaces.*;

public class Luis extends Human implements Terrible, Screamable, Cryable, Thinkable, Fallable {
    public Luis(boolean isAlive, int health) {
        super("Luis", health);
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
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}