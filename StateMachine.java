import java.util.Stack;

public class StateMachine {
    public String[] opening = { "(", "[", "{"};
    public String[] closing = { ")", "]", "}"};

    public static Stack<String> open_close_blocks;
    public static State[] states;

    public static State current;

    public StateMachine(int n) {
        open_close_blocks = new Stack<>();
        states = new State[n];
        init_states();
    }

    public void init_states() {
        // nos estados finais se eu receber CLASSE ou fim do input eu aceito a cadeia
        states[0] = new State("Q0", false, 
                        new Transition("CLASSE", "Q1", false, false)
                    );
    }

    public boolean next_state(String input) {
        Transition transition = current.search_transition(input);
        if(transition != null) {
            current = serch_state(transition.next_state);
            boolean s = stack(transition.push, transition.pop, input);
            return s ? true : false;
        }
        return false;
    }

    public State serch_state(String name) {
        for (int i = 0; i < states.length; i++) {
            if(states[i].name.equals(name)) {
                return states[i];
            }
        }
        return null;
    }

    public boolean stack(boolean push, boolean pop, String input) {
        if(!push && !pop) return true;
        
        boolean r = true;
        if(push) {
            open_close_blocks.push(input);
        }
        if(pop) {
            int i = 0;
            for(; i < 3; i++) {
                if(input.equals(closing[i])) break;
            }
            if( opening[i].equals( open_close_blocks.peek() ) ) {
                open_close_blocks.pop();
            } else {
                r = false;
            }
        }
        return r;
    }
}
