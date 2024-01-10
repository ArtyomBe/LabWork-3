import animals.Animal;
import animals.Cat;
import animals.Smack;
import animals.humans.Luis;
import animals.humans.Pascoe;
import exceptions.WakeUpException;
import items.Bones;
import items.Brushwood;
import items.Grave;
import interfaces.Upperable;

public class Main {
    public static void main(String[] args) throws WakeUpException {
        Cat smack = new Smack(false);
        Grave smacksGrave = new Grave(smack);

        String[] pascoePhrases = {"Hi there!", "What's up?", "Nice weather, isn't it?"};
        Pascoe pascoe = new Pascoe(false, pascoePhrases);

        Luis luis = new Luis(true);

        Dream dream = new Dream(new Animal[]{pascoe, luis}, new Object[]{smacksGrave});

        pascoe.stayAround(smacksGrave);
        pascoe.speakToSomeone(luis);

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

        luis.speakToSomeone(something);
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
        pascoe.speakToSomeone(luis);
        pascoe.sayTo(luis, "Don't go there, no matter how much you want to. This boundary must not be destroyed. Remember: There's more power there than you think. It is an ancient force, and it knows no rest. Remember that.");

        dream.wakeUp();
    }
}
