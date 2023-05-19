public class Chain {
    public String chain;
    public String definition; //estado final se for uma cadeia aceita
    public boolean accepted; //se foi aceita

    public Chain() {
        this.chain = "";
        this.definition = null;
        this.accepted = false;
    }

    public void add(String token) {
        chain += token + " "; 
    }

    public String toString() {
        return chain + " -> " + definition;
    }
}
