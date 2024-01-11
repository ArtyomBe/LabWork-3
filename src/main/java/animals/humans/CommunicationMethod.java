package animals.humans;

import java.util.Arrays;
import java.util.List;

public class CommunicationMethod {

    private static int exchangeCounter = 0;

    public static void main(String[] args) {
        Human Pascoe = new Human("Паскоу") {
            @Override
            public void lookAt(Object obj) {

            }
        };
        Human Luis = new Human("Луис") {
            @Override
            public void lookAt(Object obj) {

            }
        };

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

        communicate(Pascoe, Luis, phrasesPascoe, phrasesLuis);
        System.out.println("Вот и поговорили");

        // Второй обмен
        communicate(Pascoe, Luis, phrasesPascoe, phrasesLuis);
        System.out.println("Вот и поговорили");

        // Третий обмен
        communicate(Pascoe, Luis, phrasesPascoe, phrasesLuis);
        System.out.println("Вот и поговорили");
    }

    public static void communicate(Human person1, Human person2, List<String> person1Phrases, List<String> person2Phrases) {
        int person1Index = exchangeCounter % person1Phrases.size();
        int person2Index = exchangeCounter % person2Phrases.size();

        System.out.println(person1.getName() + ": " + person1Phrases.get(person1Index));
        System.out.println(person2.getName() + ": " + person2Phrases.get(person2Index));

        exchangeCounter++;

        // Сбросить счетчик, если достигнут предел одного из массивов
        if (exchangeCounter % person1Phrases.size() == 0 || exchangeCounter % person2Phrases.size() == 0) {
            exchangeCounter = 0;
        }
    }
}
