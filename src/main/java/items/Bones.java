package items;

public class Bones {

    public void snap() {
        System.out.println("Bones clicking");
    }

    public void move() {
        System.out.println("Bones moving");
    }

    @Override
    public String toString() {
        return "A pile of bones";
    }
}
