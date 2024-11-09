import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Grafo {
    private char[][] matriz;
    private boolean[][] visitados;
    private int linhas;
    private int colunas;

    // Construtor que lê o grafo a partir de um arquivo
    public Grafo(String caminhoArquivo) throws FileNotFoundException {
        lerArquivo(new File(caminhoArquivo));
    }

    public char[][] getMatriz() { return matriz; }

    public int getLinhas() { return linhas; }

    public int getColunas() { return colunas; }

    // Função para ler o arquivo e preencher a matriz
    private void lerArquivo(File arquivo) throws FileNotFoundException {
        Scanner in = new Scanner(arquivo);
        linhas = in.nextInt();
        colunas = in.nextInt();
        in.nextLine(); // Avançar para a próxima linha

        matriz = new char[linhas][colunas];
        visitados = new boolean[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            String linha = in.nextLine();
            String[] valores = linha.split(" ");
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = valores[j].charAt(0);
            }
        }
        in.close();
    }

    // Método para imprimir a matriz
    public void imprimirMatriz() {
        System.out.println("Matriz carregada:");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    //contador de regioes
    public int contarRegioes(){
        int regioes = 0;
        for(int i = 0; i < linhas; i++){
            for (int j =0; j < colunas; j++){
                if (!visitados [i][j]){
                    int verticeInicial = i * colunas + j;
                    CaminhamentoProfundidade cp = new CaminhamentoProfundidade(matriz, linhas, colunas, verticeInicial);
                    for (int v = 0; v < linhas * colunas; v++){
                        if (cp.hasPathTo(v)){
                            int x = v/ colunas;
                            int y = v% colunas;
                            visitados[x][y] = true;
                        }
                    }
                    regioes++;
                }
            }
        }
        return regioes;
    }








}