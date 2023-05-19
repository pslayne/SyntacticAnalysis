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

        // inicia a cadeia
        Chain chain = new Chain();

        for(String element : tokens) {
            // quando chegar num estado final chain.accepted = true
            // se o próximo token for CLASSE ou o fim da lista, aceita a cadeia e recomeça
            // se não chain.accepted = false e continua a computação
        }

        return result;
    }

}
