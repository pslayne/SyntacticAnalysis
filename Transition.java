public class Transition {
    public String input; // token de entrada
    public String next_state; // próximo estado
    public boolean push; // push na pilha
    public boolean pop; // pop da pilha - checar a ordem

    public Transition(String input, String next_state, boolean push, boolean pop) {
        this.input = input;
        this.next_state = next_state;
        this.push = push;
        this.pop = pop;
    }
}
