package Components;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjList {
    public static void printList (Grafo grafo) {
        int origem = 1;
        int n = grafo.getSize();

        while(origem < n) {
            System.out.print("| " + origem + " | (");
            for(int i : grafo.adjList.get(origem))
            System.out.print(" " + i + " ");

            System.out.println(")");
            origem++;
        }
    }

    public static int[] conjuntoSucessores(Grafo grafo, int vertex) {
        int[] sucessores = grafo.adjList.get(vertex).stream().mapToInt(i->i).toArray();

        return sucessores;
    }

    public static int[] conjuntoPredecessores(Grafo grafo, int vertex) {
        int n = grafo.getSize();
        List<Integer> tempList = new ArrayList<Integer>();

        for(int i = 0; i < n; i++)
            for(int j : grafo.adjList.get(i))
                if(j == vertex) {
                    tempList.add(i);
                }

        int[] predecessores = tempList.stream().mapToInt(i->i).toArray();

        return predecessores;
    }

    // Ordenar a lista de vizinhança de cada um dos vértices.
    public static void ordenarSucessores(Grafo grafo) {
        int n = grafo.getSize();

        for(int i = 0; i < n; i++) {
            Collections.sort(grafo.adjList.get(i));
        }
    }
}
