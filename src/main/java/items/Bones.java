package items;

public class Bones {

    public void snap() {
        System.out.printf("обнажив зубы%n");
    }

    public void move() {
        System.out.print("Окровавленные губы раздвинулись, ");
    }

    @Override
    public String toString() {
        return "шевелящиеся кости.";
    }
}
