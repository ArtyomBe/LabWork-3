package animals;

import animals.types.Type;
import coordinates.Point;

import java.util.Objects;

public abstract class Animal {
    protected Animal(String name, Type type, boolean isAlive) {
        this.name = name;
        this.type = type;
        this.isAlive = isAlive;
    }

    public final String name;
    public final Type type;
    public boolean isAlive;
    private Point coordinates;

    public boolean isAlive() {
        return isAlive;
    }

    public abstract String getDescription();
    @Override
    public int hashCode() {
        return Objects.hash(name, type, isAlive);
    }
}
