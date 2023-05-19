import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //inicia a classe SyntacticAnalyser e recebe o arquivo txt com o cod
        String FilePath = "C://Users//Usuario//Desktop//materiais de aula//UFERSA - CC//8º semestre//Compiladores//3//SyntacticAnalysis//lexical_analysis_result.txt";
        SyntacticAnalyser.readFile(FilePath);    

        List<Chain> result = SyntacticAnalyser.analyse();
        int cont = 1;
        for (Chain chain : result) {
            System.out.println(cont++ + ") " + chain.definition);
        }

    }
}
