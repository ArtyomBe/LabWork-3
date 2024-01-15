package animals;

import animals.types.Type;

public abstract class Animal {
    protected Animal(String name, Type type, boolean isAlive){
        this.name = name;
        this.type = type;
        this.isAlive = isAlive;
    }
    public final String name;
    public final Type type;
    public static boolean isAlive;

    public static boolean isAlive() {
        System.out.println("Current state: " + isAlive);
        return isAlive;
    }
    public abstract String getDescription();
}
