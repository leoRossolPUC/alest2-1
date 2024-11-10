import java.io.FileNotFoundException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            // Criar uma instância de ArvoreFrutinhas e ler o arquivo
            Grafo grafo = new Grafo("src/casos4/teste2.txt");

            // imprimir matriz
            grafo.imprimirMatriz();

            //contar e monstros
            Map<Integer, Integer> monstrosRegiao = grafo.contarRegioes();

            //resultados
            for (Map.Entry<Integer, Integer> entry : monstrosRegiao.entrySet()){
                System.out.println("Regiao" + entry.getKey() + ":" + entry.getValue() + "monstros");
            }


        } catch (FileNotFoundException e){
            System.err.println("Arquivo não encontrado: " + e.getMessage());
        }
    }
}