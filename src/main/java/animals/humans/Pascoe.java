package animals.humans;

import animals.humans.Human;
import animals.humans.states.State;
import interfaces.*;

public class Pascoe extends Human implements Stayable, Grinning, Movable, Sayable {
    public Pascoe(boolean isAlive) {
        super("Pascoe", isAlive);
        setDescription("dead");
    }

    @Override
    public void lookAt(Object obj) {
        System.out.printf("%s turned around to %s %n", name, obj);
    }

    @Override
    public void stayAround(Object obj) {
        System.out.printf("%s stay around %s %n", name, obj);
    }

    @Override
    public void grin() {
        System.out.printf("%s was grinning %n", name);
        setState(State.SNEER);
        System.out.println("The bloody lips parted, exposing teeth; the disfigured face shone ghastly white under the moon. %n");
    }

    public Upperable hand(){
        Upperable hand = () -> {
            System.out.printf("%s raised his hand %n", name);
        };
        return hand;
    }

    public void pointTo(Object something){
        System.out.printf("%s point out to %s %n", name, something);
    }

    @Override
    public void moveTo(Object destination) {
        setState(State.MOVE);
        System.out.printf("%s is moving to %s %n", name, destination);
    }

    @Override
    public void sayTo(Human person, String speech) {
        setState(State.SPEAK);
        System.out.printf("%s say to %s that %s %n", name, person.name, speech);
    }
}

