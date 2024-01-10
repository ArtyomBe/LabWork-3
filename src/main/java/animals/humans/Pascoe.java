package animals.humans;

import animals.humans.states.State;
import interfaces.*;

import java.util.ArrayList;
import java.util.List;

// Класс для хранения фраз Паскоу
class PascoePhraseContainer {
    private List<String> pascoePhrases;
    private int currentPhraseIndex;

    public PascoePhraseContainer(String[] phrases) {
        this.pascoePhrases = new ArrayList<>(List.of(phrases));
        this.currentPhraseIndex = 0;
    }

    public String getNextPhrase() {
        String phrase = pascoePhrases.get(currentPhraseIndex);
        currentPhraseIndex = (currentPhraseIndex + 1) % pascoePhrases.size();
        return phrase;
    }

    public void addPhrase(String newPhrase) {
        pascoePhrases.add(newPhrase);
    }
}

public class Pascoe extends Human implements Stayable, Grinning, Movable, Sayable, Interaction {

    private PascoePhraseContainer phraseContainer;

    public Pascoe(boolean isAlive) {
        super("Pascoe", isAlive);
        setDescription("dead");
        this.phraseContainer = new PascoePhraseContainer(new String[]{"Hi there!", "What's up?", "Nice weather, isn't it?"});
    }

    public Pascoe(boolean isAlive, String[] pascoePhrases) {
        this(isAlive);
        this.phraseContainer = new PascoePhraseContainer(pascoePhrases);
    }

    public void addPhrase(String newPhrase) {
        phraseContainer.addPhrase(newPhrase);
    }

    @Override
    public void speakToSomeone(Object obj) {
        if (obj instanceof Interaction) {
            Interaction other = (Interaction) obj;

            // Добавьте проверку, является ли объект типа Human, чтобы получить доступ к полю name
            if (other instanceof Human) {
                Human otherHuman = (Human) other;
                String phrase = phraseContainer.getNextPhrase();

                if (other instanceof Pascoe) {
                    Pascoe otherPascoe = (Pascoe) other;
                    otherPascoe.addPhrase(phrase);
                }

                System.out.printf("%s turned around to %s and said: '%s'%n", name, otherHuman.name, phrase);

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
                System.out.println("Invalid interaction! The object is not an instance of Human.");
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