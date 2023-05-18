public class State {
    public String state; //estado atual
    public String final_state; //estado final se for uma cadeia aceita
    public boolean accepted; //se foi aceita

    public State(String state, String final_state, boolean accepted) {
        this.state = state;
        this.final_state = final_state;
        this.accepted = accepted;
    }
}
