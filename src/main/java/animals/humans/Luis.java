package animals.humans;

import animals.humans.states.State;
import interfaces.*;

import java.util.ArrayList;
import java.util.List;

// Класс для хранения фраз Луиса
class LuisPhraseContainer {
    private List<String> luisPhrases;
    private int currentPhraseIndex;

    public LuisPhraseContainer(String[] phrases) {
        this.luisPhrases = new ArrayList<>(List.of(phrases));
        this.currentPhraseIndex = 0;
    }

    public String getNextPhrase() {
        String phrase = luisPhrases.get(currentPhraseIndex);
        currentPhraseIndex = (currentPhraseIndex + 1) % luisPhrases.size();
        return phrase;
    }

    public void addPhrase(String newPhrase) {
        luisPhrases.add(newPhrase);
    }
}

public class Luis extends Human implements Terrible, Screamable, Cryable, Thinkable, Fallable, Interaction {

    private LuisPhraseContainer phraseContainer;

    public Luis(boolean isAlive) {
        super("Luis", isAlive);
        this.phraseContainer = new LuisPhraseContainer(new String[]{"Oh no!", "What's happening?", "I can't believe it!"});
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

                if (other instanceof Luis) {
                    Luis otherLuis = (Luis) other;
                    otherLuis.addPhrase(phrase);
                }

                System.out.printf("%s spoke to %s: '%s'%n", name, otherHuman.name, phrase);
            } else {
                System.out.println("Invalid interaction! The object is not an instance of Human.");
            }
        } else {
            System.out.println("Invalid interaction!");
        }
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
}
