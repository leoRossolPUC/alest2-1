import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            // Criar uma instância de ArvoreFrutinhas e ler o arquivo
            Grafo grafo = new Grafo("src/casos4/caso40_4.txt");

            // imprimir matriz
            grafo.imprimirMatriz();

            //contar e imprimir n de regioes
            int regioes = grafo.contarRegioes();
            System.out.println("Número de regiões: " + regioes);

        } catch (FileNotFoundException e){
            System.err.println("Arquivo não encontrado: " + e.getMessage());
        }
    }
}