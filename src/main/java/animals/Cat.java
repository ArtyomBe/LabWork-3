package animals;
import animals.types.Type;
import java.util.Objects;

public abstract class Cat extends Animal {

    protected Cat(String name, boolean isAlive) {
        super(name, Type.CAT, isAlive);
    }
    protected String description = "";

    @Override
    public String getDescription() {
        return description;
    }

    protected void setDescription() {
        this.description = "docile";
    }

    @Override
    public String toString() {
        return "Cat{" +
                "description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", isAlive=" + isAlive +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(description, cat.description)
                && Objects.equals(name, cat.name)
                && Objects.equals(isAlive, cat.isAlive());
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, name, type, isAlive);
    }
}
