package Components;
import java.util.*;

public class Grafo {
    public List<List<Integer>> adjList = new ArrayList<>();

    public Grafo(List<Aresta> arestas) {
        for(int i = 0; i <= ReadGraph.numVertex; i++)
            adjList.add(i, new ArrayList<>());

        for(Aresta i : arestas)
            adjList.get(i.origem).add(i.destino);

        // Para grafos não-direcionados:
        // for(Aresta i : arestas)
        //     adjList.get(i.destino).add(i.origem);
    }

    public int getSize() {
        return adjList.size();
    }

    public void reverseEdges(int v, int w) {
        // removendo arestas.
        int remove_VW = adjList.get(v).indexOf(w);
        adjList.get(v).remove(remove_VW);
        // adicionando em ordem inversa.
        adjList.get(w).add(v);
    }
}