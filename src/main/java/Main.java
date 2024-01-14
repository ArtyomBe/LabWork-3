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
    public static void main(String[] args) throws WakeUpException {
        Cat smack = new Smack(false);
        Grave smacksGrave = new Grave(smack);

        Pascoe pascoe = new Pascoe(true, 80, 60, 75);
        pascoe.printCoordinates();
        Luis luis = new Luis(true, 68, 54, 32);
        luis.printCoordinates();
        luis.moveTo(20, 165);
        luis.printCoordinates();
        double distance = pascoe.calculateDistance(luis);

        List<String> phrasesPascoe = Arrays.asList(
                "Нельзя открывать дверь",
                "Не ходи туда, как бы тебе этого ни хотелось.",
                "Нельзя разрушать этой границы.",
                "Помни: там больше силы, чем ты думаешь.",
                "Это древняя сила, и она не знает покоя.",
                "Помни об этом."
        );

        List<String> phrasesLuis = Arrays.asList(
                "Вечернее небо расцвело разноцветными отблесками, словно художник пытался передать на холсте магию заката.",
                "Старый маяк, словно страж снов, молча освещал темные воды океана, зовя моряков к безопасному пристанищу.",
                "Аромат свежесваренного кофе наполнил комнату, будто маленький кусочек уюта всплыл в серой повседневности.",
                "Листья на деревьях шептались в весеннем ветерке, словно тайные послания, которые только природа понимает.",
                "Дети на пляже с удовольствием строили песчаные замки, будто маленькие архитекторы среди берегового песка.",
                "Вечером город просыпался к огням, словно тысячи звезд спускались с небес, чтобы озарить городскую суету."
        );

        Dream dream = new Dream(new Animal[]{pascoe, luis}, new Object[]{smacksGrave});

        pascoe.stayAround(smacksGrave);
        pascoe.lookAt(luis);

        luis.terrible();
        pascoe.grin();

        Upperable hand = pascoe.hand();
        hand.up();
        Object something = new Object() {
            @Override
            public String toString() {
                return "something";
            }
        };
        pascoe.pointTo(something);

        luis.lookAt(something);
        luis.scream();
        luis.cry();

        Bones bones = dream.bonesTurning(new Brushwood());
        bones.move();
        bones.snap();

        pascoe.moveTo(luis);
        luis.think("You have to scream to wake up; no matter what you say to Rachel, Ellie, Gage, the neighbors, you have to scream to wake up. Scream to ask to scream to..");
        luis.croak();
        luis.fallOnKnees();

        pascoe.sayTo(luis, "You're not supposed to open the door.");
        pascoe.lookAt(luis);
        pascoe.sayTo(luis, "Don't go there, no matter how much you want to. This boundary must not be destroyed. Remember: There's more power there than you think. It is an ancient force, and it knows no rest. Remember that.");

        System.out.println("Здоровье Luis до установки: " + luis.getHealth());
        luis.setHealth(75); // Пример установки здоровья для Luis
        System.out.println("Здоровье Luis после установки: " + luis.getHealth());
        pascoe.setHealth(34);
        System.out.println(pascoe.getHealth());

        CommunicationMethod.communicate(pascoe, luis, phrasesPascoe, phrasesLuis);
        dream.wakeUp();
    }
}