package animals;

import animals.types.Type;

import java.util.Objects;

public abstract class Cat extends Animal{
    protected Cat(String name, boolean is_alive) {
        super(name, Type.CAT, is_alive);
    }

    protected String description = "";

    @Override
    public String getDescription() {
        return description;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "description='" + description + '\'' +
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
        return Objects.hash(description, name, isAlive);
    }
}
