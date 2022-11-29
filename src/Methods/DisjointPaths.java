package Methods;

import java.util.*;
import Components.*;

public class DisjointPaths {

    public static boolean temVizinhos(Grafo grafo, int vertex) {
        return AdjList.conjuntoSucessores(grafo, vertex).length > 0;
    }

    // public static int findDisjointPath(Grafo grafo, int origem, int destino) {

    //     int[] fluxo = new int[grafo.getSize()];
    //     Grafo redeResidual = grafo;

    //     int max_disjointPaths = 0;

    //     while(BFS.buscaEmLargura(redeResidual, origem, destino)) {
    //         // Encontrar o gargalo no caminho encontrado.
    //         int delta = 999;
    //         int v, w;
    //         for(v = destino; v != origem; v = BFS.pai[v]) {
    //             w = BFS.pai[v];
    //             delta = Math.min(delta, fluxo[w]);
    //         }

    //         for(v = destino; v != origem; v = BFS.pai[v]) {
    //             w = BFS.pai[v];
    //             redeResidual.reverseEdges(w, v);
    //         }
    //     }
        

    //     return -1;
    // }

    static List<Aresta> disjointpaths = new ArrayList<>();

    static void printDisjointPaths() {
        Collections.reverse(disjointpaths);

        for(Aresta i : disjointpaths) {
            System.out.println(i.destino + " -> " + i.origem);
        }

        System.out.println("----");

        disjointpaths.clear();
    }

    public static int findDisjointPath(Grafo grafo, int origem, int destino) {
        Grafo residual = grafo;
        int max_disjointPaths = 0;

        System.out.println("Caminhos Disjuntos: ");

        while(BFS.buscaEmLargura(residual, origem, destino)) {
            int v, w;
            for(v = destino; v != origem; v = BFS.pai[v]) {
                w = BFS.pai[v];
                residual.reverseEdges(w, v);
                disjointpaths.add(new Aresta(v, w));
            }
            
            printDisjointPaths();
            max_disjointPaths++;
        }

        return max_disjointPaths;
    }
}
