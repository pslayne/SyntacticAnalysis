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
        current = states[0];
    }

    public void init_states() {
        // nos estados finais se eu receber CLASSE ou fim do input eu aceito a cadeia
        states[0] = new State("Q0", false, 
                        new Transition("CLASSE", 
                        "Q1", 
                        false, false)
                    );
        states[1] = new State("Q1", false, 
                        new Transition("AND", 
                            "Q2", 
                            false, false),
                        new Transition("PROPRIEDADE", 
                            "Q3", 
                            false, false),
                        new Transition("(", 
                            "Q1, Q8", 
                            true, false),
                        new Transition("{", 
                            "Q13", 
                            true, false)
                    );
        states[2] = new State("Q2", false, 
                        new Transition("PROPRIEDADE", 
                        "Q3", 
                        false, false),
                        new Transition("(", 
                        "Q2", 
                        true, false)
                    );
        states[3] = new State("Q3", false, 
                        new Transition("PALAVRA RESERVADA", 
                        "Q4", 
                        false, false),
                        new Transition("COMPARACAO", 
                        "Q5", 
                        false, false),
                        new Transition("VALUE", 
                        "Q5", 
                        false, false)
                    );
        states[4] = new State("Q1, Q8", false, 
                        new Transition("CLASSE", 
                        "Q9", 
                        false, false),
                        new Transition("AND", 
                        "Q2", 
                        false, false),
                        new Transition("PROPRIEDADE", 
                        "Q3", 
                        false, false),
                        new Transition("(", 
                        "Q1, Q8", 
                        true, false)
                    );
        states[5] = new State("Q4", false,
                        new Transition("CLASSE",
                        "Q7",
                        false, false
                        ), 
                        new Transition("NUMERO",
                        "Q6",
                        false, false
                        ), 
                        new Transition("(",
                        "Q4",
                        true, false
                        ), 
                        new Transition("[",
                        "Q4",
                        true, false
                        ), 
                        new Transition("OPERADOR RELACIONAL",
                        "Q18",
                        false, false
                        ),
                        new Transition("COMPARACAO", 
                        "Q5", 
                        false, false),
                        new Transition("VALUE", 
                        "Q5", 
                        false, false)
                    );
        states[6] = new State("Q5", false, 
                    new Transition("NUMERO", 
                    "Q6", 
                    false, false),
                    new Transition("[",
                    "Q5",
                    true, false
                    ),
                    new Transition("OPERADOR RELACIONAL",
                    "Q18",
                    false, false
                    ) 
                );
        states[7] = new State("Q9", false, 
                new Transition("OR", 
                "Q10", 
                false, false)
            );
        states[8] = new State("Q14", false, 
                new Transition(",", 
                "Q15", 
                false, false)
            );
        states[9] = new State("Q7", true, 
                new Transition("AND", 
                "Q2", 
                false, false),
                new Transition("PROPRIEDADE", 
                "Q3", 
                false, false),
                new Transition("OR", 
                "Q4", 
                false, false),
                new Transition(")", 
                "Q7", 
                false, true)
            );
        states[10] = new State("Q6", true, 
                new Transition("AND", 
                "Q2", 
                false, false),
                new Transition("CLASSE", 
                "Q7", 
                false, false),
                new Transition(")", 
                "Q6", 
                false, true),
                new Transition("]", 
                "Q6", 
                false, true)
            );
        states[11] = new State("Q18", false, 
            new Transition("NUMERO", 
            "Q6", 
            false, false)
            );
        states[12] = new State("Q10", false, 
            new Transition("CLASSE", 
            "Q11", 
            false, false)
            );
        states[13] = new State("Q15", false, 
            new Transition("INDIVIDUO", 
            "Q16", 
            false, false)
            );
        states[14] = new State("Q11", false, 
            new Transition("OR", 
            "Q10", 
            false, false),
            new Transition(")", 
            "Q12", 
            false, true)
            );
        states[15] = new State("Q16", false, 
            new Transition("}", 
            "Q17", 
            false, true),
            new Transition(",", 
            "Q15", 
            false, false)
            );
        states[16] = new State("Q12", true);
        states[17] = new State("Q8", false, 
            new Transition("CLASSE", 
            "Q9", 
            false, false),
            new Transition("PROPRIEDADE", 
            "Q3", 
            false, false)
            );
        states[18] = new State("Q13", false, 
            new Transition("CLASSE", 
            "Q14", 
            false, false)
            );
        states[19] = new State("Q17", true);
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
