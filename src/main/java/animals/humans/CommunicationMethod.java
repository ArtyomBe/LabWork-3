package animals.humans;

import java.util.List;

public class CommunicationMethod {
    private static int exchange = 0;

    public static void communicate(Human person1, Human person2, List<String> person1Phrases, List<String> person2Phrases) throws InterruptedException {
        int person1Index = exchange % person1Phrases.size();
        int person2Index = exchange % person2Phrases.size();
        Thread.sleep(150);
        System.out.printf("****************************************%n");
        Thread.sleep(250);
        System.out.print("\u001B[1m" + person1.getName() + ": " + person1Phrases.get(person1Index) + "\u001B[0m");
        Thread.sleep(150);
        System.out.println();
        System.out.print("\u001B[1m" + person2.getName() + ": " + person2Phrases.get(person2Index) + "\u001B[0m");
        Thread.sleep(150);
        System.out.println();
        System.out.printf("****************************************%n");
        exchange++;
    }
}
