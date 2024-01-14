import animals.*;
import animals.humans.CommunicationMethod;
import exceptions.WakeUpException;
import items.*;
import interfaces.Upperable;
import animals.humans.Pascoe;
import animals.humans.Luis;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws WakeUpException, InterruptedException {
        Pascoe pascoe = new Pascoe(true, 100, 0, 0, 0);
        Luis luis = new Luis(true, 20, 35, 15, 0);
        Cat smack = new Smack(false);
        Grave smacksGrave = new Grave(smack);
        Dream dream = new Dream(new Animal[]{pascoe, luis});

        try {
            pascoe.moveTo(30, 13);
            pascoe.calculateDistance(luis);
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

            Bones bones = dream.bonesTurning(new Brushwood());
            bones.move();
            bones.snap();
            int luisX = luis.getX();
            int luisY = luis.getY();
            pascoe.moveTo(luisX, luisY);

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
            luis.increaseFear(5);
            CommunicationMethod.communicate(pascoe, luis, phrasesPascoe, phrasesLuis);
            luis.increaseFear(5);
            luis.increaseFear(5);
            pascoe.calculateDistance(luis);
            Thread.sleep(150);
            luis.printState();
            Thread.sleep(150);
            pascoe.printState();
            Thread.sleep(150);
            CommunicationMethod.communicate(pascoe, luis, phrasesPascoe, phrasesLuis);
            CommunicationMethod.communicate(pascoe, luis, phrasesPascoe, phrasesLuis);
            luis.increaseFear(2);
            dream.wakeUp();
        } catch (WakeUpException e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        }
        Thread.sleep(1000);
        System.out.printf("Сознание %s окутал туман....%n", pascoe.getName());
        Thread.sleep(200);
        System.out.printf("Таинственный мрак омрачил разум %s....%n", pascoe.getName());
        Thread.sleep(200);
        System.out.printf("Вихри загадочности затуманили поток мыслей %s....%n", pascoe.getName());
        Thread.sleep(200);
        pascoe.moveTo(-100, -100);
        System.out.printf("----------------------------------------%n");
        Thread.sleep(250);
        System.out.printf("%s подумал\u001B[3m «чёрррт, что здесь происходит, о нет, я в %s...».\u001B[0m%n", pascoe.getName(), pascoe.getLocationName(pascoe.getX(), pascoe.getY()));
        Thread.sleep(150);
        luis.decreaseFear(100);
        Thread.sleep(150);
        pascoe.decreaseFear(100);
        Thread.sleep(250);
        pascoe.printState();
        Thread.sleep(250);
        luis.printState();
        Thread.sleep(250);
        System.out.printf("Эххххххх, я опять уснул в коворкинге в %s.", pascoe.getLocationName(pascoe.getX(), pascoe.getY()));
    }
}