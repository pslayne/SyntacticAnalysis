public class Chain {
    public String chain;
    public String final_state; //estado final se for uma cadeia aceita
    public boolean accepted; //se foi aceita

    public Chain() {
        this.chain = "";
        this.final_state = null;
        this.accepted = false;
    }

    //this.chain += token + " "; 
}
