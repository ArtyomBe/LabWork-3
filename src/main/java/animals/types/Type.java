package animals.types;

public enum Type {
    CAT("cat"),
    HUMAN("human");

    private final String type;
    Type(String type){
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
