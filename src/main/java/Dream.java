import animals.Animal;
import exceptions.WakeUpException;
import items.Bones;

public class Dream {
    public Dream(Animal[] persons) {
        this.persons = persons;
    }
    public final Animal[] persons;

    public Bones bonesTurning(Object item){
        item = null;
        return new Bones();
    }

    public void wakeUp() throws WakeUpException {
        throw new WakeUpException("The dream is over!");
    }
}
