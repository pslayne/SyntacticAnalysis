package SyntacticAnalysis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SyntacticAnalyser {
    
    public static List<String> tokens = new ArrayList<>();

    public static void readFile(String caminhoArquivo) {
        //Função que recebe o arquivo txt ele lê cada linha e separa as palavras pelo caractere de espaço " " depois adiciona cada palavra ao vetor tokens
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                tokens.add(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> analyse() {
        List<String> result = new ArrayList<>();
        
        Stack<String> open_close_parentesis = new Stack<>();
        Stack<String> open_close_brackets = new Stack<>();

        // estado inicial da máquina de estados
        State init = new State("Inicial", "", false);

        for(String element : tokens) {
            
        }

        return result;
    }

    public static State state_machine(State current, String input) {
        
    }

}
