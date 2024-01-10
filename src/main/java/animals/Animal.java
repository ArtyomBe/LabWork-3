package animals;

import animals.types.Type;

public abstract class Animal {
    protected Animal(String name, Type type, boolean is_alive){
        this.name = name;
        this.type = type;
        this.isAlive = is_alive;
    }
    public final String name;
    public final Type type;
    protected boolean isAlive;

    public boolean isAlive(){
        return isAlive;
    }

    public abstract String getDescription();
}
