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
                tokens.add(linha.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Chain> analyse() {
        List<Chain> result = new ArrayList<>();

        // inicia a cadeia
        Chain chain = new Chain();
        //instancia a máquina de estados com 20 estados
        StateMachine state_machine = new StateMachine(20);
        for(String token : tokens) {
            // quando chegar num estado final chain.accepted = true
            // se o próximo token for CLASSE ou o fim da lista, aceita a cadeia e recomeça
            // se não chain.accepted = false e continua a computação

            if(chain.accepted) {
                if(token.equals("CLASSE")) {
                    result.add(chain);
                    chain = new Chain();
                    state_machine.reset();
                } else {
                    chain.accepted = false;
                }
            }
            
            State previous = state_machine.current;
            if(state_machine.next_state(token)) {
                chain.add(token);
                
                State current = state_machine.current;
                if(previous.name.equals("Q1")) {
                    switch(current.name) {
                        case "Q2": chain.definition = "Classe Definida"; break;
                        case "Q3": chain.definition = "Classe Primitiva"; break;
                        case "Q13": chain.definition = "Classe Enumerada"; break;
                        case "Q1, Q8": chain.definition = "Classe Coberta"; break;
                    }
                }
            } 
            if (state_machine.current.is_final && state_machine.open_close_blocks.empty()) {
                chain.accepted = true;
            }

        }

        if (state_machine.current.is_final) {
            result.add(chain);
        }

        return result;
    }

    //drawTable e padRight são funções só estéticas que fazem o papel de desenha a tabela no terminal pra melhor visualização
    public static void drawTable(List<List<String>> data) {
        int numRows = data.size();
        int numColumns = data.get(0).size();

        // Calcular a largura das colunas
        int[] columnWidths = new int[numColumns];
        for (int col = 0; col < numColumns; col++) {
            for (int row = 0; row < numRows; row++) {
                int width = data.get(row).get(col).length();
                if (width > columnWidths[col]) {
                    columnWidths[col] = width;
                }
            }
        }

        // Desenhar a tabela
        for (int row = 0; row < numRows; row++) {
            List<String> rowData = data.get(row);
            for (int col = 0; col < numColumns; col++) {
                String cell = rowData.get(col);
                System.out.print("| " + padRight(cell, columnWidths[col]) + " ");
            }
            System.out.println("|");
            if (row == 0) {
                for (int col = 0; col < numColumns; col++) {
                    System.out.print("+");
                    for (int i = 0; i < columnWidths[col] + 2; i++) {
                        System.out.print("-");
                    }
                }
                System.out.println("+");
            }
        }
    }

    public static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }
}
