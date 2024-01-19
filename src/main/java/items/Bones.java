package items;

public class Bones {

    public void snap() {
        Teeth teeth = new Teeth();
        System.out.printf(teeth.snap());
    }

    public void move() {
        System.out.print("Окровавленные губы раздвинулись, ");
    }

    @Override
    public String toString() {
        return "шевелящиеся кости.";
    }
    public static class Teeth{
        public String snap(){
            return "обнажив зубы";
        }
    }
}
