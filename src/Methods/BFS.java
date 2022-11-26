package Methods;
import java.util.*;
import Components.*;

/**
 * Classe para a execução de uma busca em largura, usada em outros métodos.
 */
public class BFS {
    static Queue<Integer> fila = new LinkedList<>();
    static int time;
    static boolean[] visited;
    static int[] indice;
    static int[] pai;
    static int graphSize;

    /**
     * Metodo para inicializar os valores para uma busca em largura.
     * @param grafo - que será realizado a busca.
     */
    static void inicializarValores(Grafo grafo) {
        graphSize = grafo.getSize();
        time = 0;
        // Preenche todos os vetores com 0.
        visited = new boolean[graphSize];
        indice = new int[graphSize];
        pai = new int[graphSize];
    }

    public static boolean buscaEmLargura(Grafo grafo, int source, int dest) {
        inicializarValores(grafo);

        fila.add(source);
        visited[source] = true;

        while(!fila.isEmpty()) {
            int v = fila.peek();
            System.out.println(v + " ");
            fila.remove();
            int[] vizinhanca = AdjList.conjuntoSucessores(grafo, v);
            for(int w : vizinhanca) {
                if(!visited[w]) {
                    visited[w] = true;
                    pai[w] = v;
                    time = time + 1;
                    indice[w] = time;
                    fila.add(w);
                }
            }
        }

        // Se o destino foi visitado na busca retorna true, caso contrario não há caminho entre os vértices de origem e destino
        return visited[dest] == true ? true : false;
    }
}
