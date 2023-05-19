public class State {
    public String name;
    public boolean is_final;
    public Transition[] transitions;

    public State(String name, boolean is_final, Transition... transitions) {
        this.name = name;
        this.is_final = is_final;
        this.transitions = transitions;
    }

    public Transition search_transition(String input) {
        for (int i = 0; i < transitions.length; i++) {
            if(transitions[i].input.equals(input)) {
                return transitions[i];
            }
        }
        return null;
    }
}
