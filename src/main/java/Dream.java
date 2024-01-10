import animals.Animal;
import exceptions.WakeUpException;
import items.Bones;

public class Dream {
    public Dream(Animal[] persons, Object[] items) {
        this.persons = persons;
        this.items = items;
    }
    public final Animal[] persons;
    public final Object[] items;

    public Bones bonesTurning(Object item){
        item = null;
        return new Bones();
    }

    public void wakeUp() throws WakeUpException {
        throw new WakeUpException("The dream is over!");
    }
}
