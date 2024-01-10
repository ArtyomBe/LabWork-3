package animals.humans;

import animals.humans.Human;
import animals.humans.states.State;
import interfaces.*;

public class Pascoe extends Human implements Stayable, Grinning, Movable, Sayable, Interaction {

    String[] pascoePhrases = {"Hi there!", "What's up?", "Nice weather, isn't it?"};
    private int currentPhraseIndex;

    public Pascoe(boolean isAlive, String[] pascoePhrases) {
        super("Pascoe", isAlive);
        setDescription("dead");
        this.pascoePhrases = pascoePhrases;
        this.currentPhraseIndex = 0;
    }

    @Override
    public void lookAt(Object obj) {
        if (obj instanceof Interaction other) {
            String phrase = getNextPhrase();
            System.out.printf("%s turned around to %s and said: '%s'%n", name, name, phrase);
        } else {
            System.out.println("Invalid interaction!");
        }
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

    public Upperable hand() {
        Upperable hand = () -> {
            System.out.printf("%s raised his hand %n", name);
        };
        return hand;
    }

    public void pointTo(Object something) {
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

    private String getNextPhrase() {
        String phrase = pascoePhrases[currentPhraseIndex];
        currentPhraseIndex = (currentPhraseIndex + 1) % pascoePhrases.length;
        return phrase;
    }

    @Override
    public void interact(Interaction partner) {
        lookAt(partner);
    }
}
