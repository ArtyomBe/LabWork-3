import animals.Animal;
import exceptions.WakeUpException;
import items.Bones;

public record Dream(Animal[] persons) {
    public Bones bonesTurning() {
        return new Bones();
    }

    public void wakeUp() throws WakeUpException {
        throw new WakeUpException("The dream is over!");
    }
}
