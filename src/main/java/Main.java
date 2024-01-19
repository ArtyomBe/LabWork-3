import animals.*;
import exceptions.WakeUpException;
import items.*;
import interfaces.Upperable;
import animals.humans.*;

import coordinates.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Pascoe pascoe = new Pascoe(100, 0);
        Luis luis = new Luis(20, 35);
        Cat smack = new Smack(false);
        Grave smacksGrave = new Grave(smack);
        CoordinatesMap<Animal> coordinatesMap = new CoordinatesMap<>();
        coordinatesMap.addObject(pascoe, new Point(10, 10));
        coordinatesMap.addObject(luis, new Point(35, 15));
        coordinatesMap.addObject(smack, new Point(30, 13));

        Dream dream = new Dream(new Animal[]{pascoe, luis});
        try {
            Location deadSmakyLocation = new Location("кот Смэки, он был послушным.", new Point(30, 14));
            coordinatesMap.addLocation(deadSmakyLocation);
            String deadSmakyLocationName = coordinatesMap.getLocationName(deadSmakyLocation.coordinates());
            System.out.printf("%s переместился к %s%n", pascoe.getName(), deadSmakyLocationName);
            coordinatesMap.moveTo(luis, new Point(34,21));
            pascoe.increaseFear(15);
            pascoe.lookAt(smacksGrave);
            pascoe.lookAt(luis);
            Upperable hand = pascoe.hand();
            hand.up();
            pascoe.pointTo("что-то");
            luis.lookAt("туда");
            luis.scream();
            luis.increaseFear(13);
            luis.cry();
            Bones bones = dream.bonesTurning();
            bones.move();
            bones.snap();
            int luisX = coordinatesMap.getX(luis);
            int luisY = coordinatesMap.getY(luis);
            coordinatesMap.moveTo(pascoe, new Point(luisX, luisY));

            luis.think("Ты должен закричать, чтобы проснуться; неважно, что ты скажешь Рэчел, Элли, Гэджу, соседям, ты должен закричать, чтобы проснуться. Закричатьчтобыпроснутьсязакричатьчтобы..");
            luis.croak();
            luis.fallOnKnees();

            List<String> phrasesPascoe = Arrays.asList(
                    "Нельзя открывать дверь",
                    "Не ходи туда, как бы тебе этого ни хотелось.",
                    "Нельзя разрушать этой границы.",
                    "Помни: там больше силы, чем ты думаешь.",
                    "Это древняя сила, и она не знает покоя.",
                    "Помни об этом."
            );

            List<String> phrasesLuis = Arrays.asList(
                    "Почему? Что произойдет, если я открою дверь? Расскажи мне, что за границей.",
                    "Ты говоришь о древней силе, но что конкретно происходит? Почему мне нельзя туда пойти? Что за граница?",
                    "Что за границей? Почему даже мысль о разрушении границы наполняет тебя ужасом и предчувствием неизбежной тьмы?",
                    "Какие загадочные силы скрываются за таинственными вратами? Почему предостережение о присутствии гораздо более могущественных сил наполняет ужасом и странным чувствами?",
                    "Почему эта древняя сила не знает покоя? Какие тайны она хранит и как она взаимодействует с нашим миром?",
                    "Паскоу странный... Он мне так-то знаком. Но почему его слова вызывают во мне чувство неопределенности и неуверенности? Может быть, у него свои тайные мотивы?"
            );

            CommunicationMethod.communicate(pascoe, luis, phrasesPascoe, phrasesLuis);
            pascoe.lookAt(luis);
            CommunicationMethod.communicate(pascoe, luis, phrasesPascoe, phrasesLuis);
            pascoe.pointTo(bones);
            luis.setFear(20);
            CommunicationMethod.communicate(pascoe, luis, phrasesPascoe, phrasesLuis);
            CommunicationMethod.communicate(pascoe, luis, phrasesPascoe, phrasesLuis);
            luis.increaseFear(5);
            luis.increaseFear(5);
            luis.printState();
            pascoe.printState();
            CommunicationMethod.communicate(pascoe, luis, phrasesPascoe, phrasesLuis);
            CommunicationMethod.communicate(pascoe, luis, phrasesPascoe, phrasesLuis);
            luis.increaseFear(2);
            dream.wakeUp();
        } catch (WakeUpException e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Произошла ошибка при ожидании: " + e.getMessage());
        }

        pascoe.sayTo(luis, "Oh no wtf is going one?");
        System.out.printf("Сознание %s окутал туман....%n", pascoe.getName());
        System.out.printf("Таинственный мрак омрачил разум %s....%n", pascoe.getName());
        System.out.printf("Вихри загадочности затуманили поток мыслей %s....%n", pascoe.getName());
        coordinatesMap.moveTo(pascoe, new Point(-100,-100));
        System.out.printf("----------------------------------------%n");
        pascoe.setHealth(0);
        luis.setHealth(0);
        Thread.sleep(100);
        System.err.printf("%n%s и %s %s%n", pascoe.getName(), luis.getName(), pascoe.getDescription());
        Location itmoLocation = new Location("ИТМО", new Point(-100, -100));
        coordinatesMap.addLocation(itmoLocation);
        String itmoLocationName = coordinatesMap.getLocationName(itmoLocation.coordinates());
        System.out.printf("%s подумал\u001B[3m «чёрррт, что здесь происходит???, о нет, я в %s...».\u001B[0m%n", pascoe.getName(), itmoLocationName);
        luis.decreaseFear(100);
        pascoe.decreaseFear(100);
        pascoe.printState();
        luis.printState();
        System.out.printf("%s: Эххххххх, я опять уснул в коворкинге в %s!%n", pascoe.getName(), itmoLocationName);
        ICanDoAnonymClass anonymClass = () -> System.out.println("something");
        anonymClass.something();
    }
}
interface ICanDoAnonymClass{
    void something();
}