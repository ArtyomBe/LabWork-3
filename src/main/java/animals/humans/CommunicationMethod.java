package animals.humans;

import java.util.List;

public class CommunicationMethod {
    private static int exchange = 0;

    public static void communicate(Human person1, Human person2, List<String> person1Phrases, List<String> person2Phrases) {
        int person1Index = exchange % person1Phrases.size();
        int person2Index = exchange % person2Phrases.size();

        System.out.println(person1.getName() + ": " + person1Phrases.get(person1Index));
        System.out.println(person2.getName() + ": " + person2Phrases.get(person2Index));

        exchange++;
    }
}
