package items;

import animals.Animal;
import exceptions.AnimalIsNotDeadException;

import java.util.Objects;

public class Grave {
    public Grave(Animal dead){
        if (dead.isAlive()){
            throw new AnimalIsNotDeadException(
                    String.format("Animal %s is not dead, you cannot put it at the grave", dead.name)
            );
        }
        this.dead = dead;
    }
    private final Animal dead;
    @Override
    public String toString() {
        return String.format("«%s %s  %s, он был послушным»", dead.type, dead.name, dead.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(dead);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grave grave = (Grave) o;
        return Objects.equals(dead, grave.dead);
    }
}
