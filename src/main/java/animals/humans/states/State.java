package animals.humans.states;

public enum State {
    NOTHING("nothing"),
    FEAR("fear"),
    SNEER("sneer"),
    SCREAM("scream"),
    CRY("cry"),
    MOVE("move"),
    THINK("think"),
    CROAK("croak"),
    SPEAK("speak");

    private final String state;
    State(String state){
        this.state = state;
    }

    @Override
    public String toString() {
        return "Type{" +
                "state='" + state + '\'' +
                '}';
    }
}
