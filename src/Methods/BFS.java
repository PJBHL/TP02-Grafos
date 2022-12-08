package Methods;
import java.util.*;
import Components.*;

/**
 * Classe para a execução de uma busca em largura no grafo, usada para a procura de caminhos disjuntos.
 */
public class BFS {
    // Variáveis para controle da busca em largura.
    static Queue<Integer> fila = new LinkedList<>();
    static int time;
    static boolean[] visited;
    static int[] indice;
    static int[] pai;
    static int graphSize;

    /**
     * Metodo para inicializar os valores de controle da busca em largura.
     * @param grafo - que será realizado a busca.
     */
    static void inicializarValores(Grafo grafo) {
        graphSize = grafo.getSize();
        time = 0;
        // Preenche todos os vetores com 0, do tamanho do grafo.
        visited = new boolean[graphSize];
        indice = new int[graphSize];
        pai = new int[graphSize];
    }

    /**
     * Busca em largura modificada que testa se há caminho entre um vértice "source" e outro vértice "dest"
     * @param grafo - Grafo que será realizado a busca em largura.
     * @param source - Vértice de origem da busca.
     * @param dest - Vértice de destino da busca.
     * @return - true se há um caminho entre origem e destino, falso caso contrário.
     */
    public static boolean buscaEmLargura(Grafo grafo, int source, int dest) {
        inicializarValores(grafo);

        // Adiciona na fila o vértice explorado e marca o seu vetor.
        fila.add(source);
        visited[source] = true;

        // Enquanto a fila não está vazia há vértices para serem explorados.
        while(!fila.isEmpty()) {
            // Pega o primeiro elemento da fila.
            int v = fila.peek();
            fila.remove();
            int[] vizinhanca = AdjList.conjuntoSucessores(grafo, v);
            // Analiza os vizinhos de v e faz atribuições caso algum deles ainda não tenha sido visitado.
            for(int w : vizinhanca) {
                if(!visited[w]) {
                    visited[w] = true; // W é visitado pela primeira vez.
                    pai[w] = v; // V é o pai de W na árvore de busca.
                    time = time + 1;
                    indice[w] = time;
                    fila.add(w); // Adiciona W na fila para continuar a busca enquanto a fila não estiver vazia.
                }
            }
        }

        // Se o destino foi visitado na busca retorna true, caso contrario não há caminho entre os vértices de origem e destino
        return visited[dest] == true ? true : false;
    }
}