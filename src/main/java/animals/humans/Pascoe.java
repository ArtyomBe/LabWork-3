package animals.humans;

import animals.humans.states.State;
import interfaces.*;

public class Pascoe extends Human implements Stayable, Grinning, Movable, Sayable, Interaction {

    String[] pascoePhrases = {"Hi there!", "What's up?", "Nice weather, isn't it?"};
    private int currentPhraseIndex;

    public Pascoe(boolean isAlive) {
        super("Pascoe", isAlive);
        setDescription("dead");
        this.currentPhraseIndex = 0;
    }

    public Pascoe(boolean isAlive, String[] pascoePhrases) {
        this(isAlive);
        this.pascoePhrases = pascoePhrases;
    }

    public void addPhrase(String newPhrase) {
        // Add the new phrase to Pascoe's phrases array
        String[] newPhrases = new String[pascoePhrases.length + 1];
        System.arraycopy(pascoePhrases, 0, newPhrases, 0, pascoePhrases.length);
        newPhrases[pascoePhrases.length] = newPhrase;
        pascoePhrases = newPhrases;
    }

    @Override
    public void speakToSomeone(Object obj) {
        if (obj instanceof Interaction) {
            Interaction other = (Interaction) obj;
            String phrase = getNextPhrase();

            if (other instanceof Pascoe) {
                Pascoe otherPascoe = (Pascoe) other;
                otherPascoe.addPhrase(phrase);
            }

            System.out.printf("%s turned around to %s and said: '%s'%n", name, name, phrase);

            // Добавим условия для вывода различных предложений в зависимости от выбранной фразы
            switch (phrase) {
                case "Hi there!":
                    System.out.println("Pascoe greeted with a friendly smile.");
                    break;
                case "What's up?":
                    System.out.println("Pascoe asked, curious about the latest news.");
                    break;
                case "Nice weather, isn't it?":
                    System.out.println("Pascoe commented on the pleasant weather.");
                    break;
                // Добавьте другие предложения по мере необходимости
                default:
                    System.out.println("Pascoe said something interesting.");
                    break;
            }
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
        return () -> System.out.printf("%s raised his hand %n", name);
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

    @Override
    public void interact(Interaction partner) {
        speakToSomeone(partner);
    }

    private String getNextPhrase() {
        String phrase = pascoePhrases[currentPhraseIndex];
        currentPhraseIndex = (currentPhraseIndex + 1) % pascoePhrases.length;
        return phrase;
    }
}