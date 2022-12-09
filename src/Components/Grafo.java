package Components;
import java.util.*;
import java.io.*;

/**
 * Classe construtora de um grafo.
 * Um grafo recebe uma lista de arestas.
 * Representação feita por uma lista de adjacência.
 */
public class Grafo {
    public List<List<Integer>> adjList = new ArrayList<>();

    /**
     * Construtor de um grafo.
     * @param arestas - lista de arestas para a construção da lista de adjacência.
     */
    public Grafo(List<Aresta> arestas) {
        // alocação de memória para cada vértice.
        for(int i = 0; i <= ReadGraph.numVertex; i++)
            adjList.add(i, new ArrayList<>());

        // Cada vértice <origem> tem uma aresta para outro vértice <destino>.
        for(Aresta i : arestas)
            adjList.get(i.origem).add(i.destino);

        // Para grafos não-direcionados: basta adicionar destino a origem.
        // for(Aresta i : arestas)
        //     adjList.get(i.destino).add(i.origem);
    }

    /**
     * Tamanho do grafo - número de vértices do grafo.
     * @return - inteiro com o tamanho do grafo.
     */
    public int getSize() {
        return adjList.size();
    }

    /**
     * Método para inverter a direção das arestas.
     * Uma aresta de v para w {v, w} se torna w para v {w, v}.
     * @param v - vértice v.
     * @param w - vértice w.
     * Os paramêtros representam uma aresta de v -> w.
     */
    public void reverseEdges(int v, int w) {
        // indice de w na lista de v.
        int remove_VW = adjList.get(v).indexOf(w);
        // remoção do vértice w na lista de v.
        adjList.get(v).remove(remove_VW);
        // adição do vértice v na lista de w.
        adjList.get(w).add(v);
    }

    public static int getEdgesListSize(Grafo grafo) {
        int sizeT = 0;

        for(int vertex = 1; vertex < grafo.getSize(); vertex++) {
            int size = grafo.adjList.get(vertex).size();
            sizeT += size;
        }

        return sizeT;
    }

    public static void writeGraph(Grafo grafo) throws IOException {
        FileWriter file = new FileWriter("k2500.txt");
        file.write(ReadGraph.numVertex + " " + getEdgesListSize(grafo) + "\n");

        for(int vertex = 1; vertex <= ReadGraph.numVertex; vertex++) {
            List<Integer> list = grafo.adjList.get(vertex);
            Collections.sort(list);
            int[] sucessores = grafo.adjList.get(vertex).stream().mapToInt(i->i).toArray();
				int size = list.size();
                for(int j = 0; j < size; j++) {
                    file.write("    " + vertex + " " + sucessores[j] + "\n");
                }
        }

        file.close();
    }
}