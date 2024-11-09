import java.util.Stack;

public class CaminhamentoProfundidade {
    private boolean[] marked;
    private int[] edgeTo;
    private int s; //vetice inicial
    private int linhas, colunas;
    private char[][] labirinto;

    public CaminhamentoProfundidade(char[][] labirinto, int linhas, int colunas, int s){
        this.labirinto = labirinto;
        this.linhas = linhas;
        this.colunas = colunas;
        this.s = s;

        int tamanho = linhas*colunas; //numero total de celulas
        marked = new boolean[tamanho];
        edgeTo = new int[tamanho];

        dfs(s);
    }

    private void dfs (int v){
        //    System.out.println("Entrei em: " + v);
        marked[v] = true;
        int i = v/colunas;
        int j = v% colunas;

        //obter valor hexadecimal
        int valorHexa = Character.digit(labirinto[i][j], 16);

        //sem parede acima
        if ((valorHexa & 8) == 0 && i>0){
            int vizinho = (i -1) * colunas +j;
            if (!marked[vizinho]){
                edgeTo[vizinho] = v;
                dfs(vizinho);
            }
        }

        //sem parede a direita
        if ((valorHexa & 4) == 0 && j < colunas - 1){
            int vizinho = i * colunas + (j + 1);
            if (!marked[vizinho]){
                edgeTo[vizinho] =v;
                dfs(vizinho);
            }
        }

        //sem parede abaixo
        if ((valorHexa & 2) == 0 && i < linhas -1){
            int vizinho = (i + 1) * colunas + j;
            if (!marked[vizinho]){
                edgeTo[vizinho] =v;
                dfs(vizinho);
            }
        }

        //sem parede a esquerda
        if ((valorHexa & 1) == 0 && j>0){
            int vizinho = i * colunas +(j - 1);
            if (!marked[vizinho]){
                edgeTo[vizinho] =v;
                dfs(vizinho);
            }
        }
    }


    public boolean hasPathTo (int v){
        return marked[v];
    }


    public Iterable<Integer> pathTo(int v){
        if (!hasPathTo(v))
            return null;
        Stack<Integer> path = new Stack<>();
        while(v != s){
            path.push(v);
            v = edgeTo[v];
        }
        path.push(s);
        return path;
    }
}

