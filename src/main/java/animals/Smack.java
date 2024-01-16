package animals;

import java.util.Objects;

public class Smack extends Cat{
    public Smack(boolean is_alive) {
        super("Smack", is_alive);
        setDescription("docile");
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
