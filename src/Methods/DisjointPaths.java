package Methods;

import java.util.*;
import Components.*;

public class DisjointPaths {
    // Lista de arestas de caminhos disjuntos.
    static List<Aresta> disjointpaths = new ArrayList<>();

    /**
     * Método para print dos caminhos disjuntos encontrados no grafo.
     */
    static void printDisjointPaths() {
        // Invertendo a ordem da lista -> os vértices são adicionados do destino para a origem, ou seja, de forma inversa do caminho.
        Collections.reverse(disjointpaths);

        // Como as arestas estão invertidas a ordem é {w, v} e não {v, w}.
        for(Aresta i : disjointpaths) {
            System.out.println(i.destino + " -> " + i.origem);
        }

        System.out.println("----");

        // Limpa a lista depois de printar um caminho encontrado.
        disjointpaths.clear();
    }

    /**
     * Método para a busca de caminhos disjuntos. Realiza buscas em larguras enquanto houver caminho entre
     * os vértices origem e destino. A cada caminho achado na busca em largura as arestas são invertidas. De
     * forma semelhante as redes e fluxos, aqui cada aresta teria capacidade 1 ou nula.
     * @param grafo - Grafo para procurar caminhos disjuntos.
     * @param origem - Vértice origem para busca em largura.
     * @param destino - Vértice de destino para busca em largura.
     * @return - Número máximo de caminhos disjuntos ou <fluxo máximo> do grafo com capacidade 1 em todas as arestas.
     */
    public static int findDisjointPath(Grafo grafo, int origem, int destino) {
        // Clone do grafo original, para que ele não seja modificado no processo.
        Grafo residual = grafo;
        int max_disjointPaths = 0;

        System.out.println("Caminhos Disjuntos: ");

        // Enquanto houver uma forma de chegar no destino partindo da origem faça:
        while(BFS.buscaEmLargura(residual, origem, destino)) {
            int v, w;
            // "Backtracking" no vetor de *pai* gerado na busca em largura para inverter cada uma das arestas.
            // Começando pelo destino até chegar na origem.
            // O resultado será a inversão de todas as arestas encontradas em um caminho, do destino até a origem.
            for(v = destino; v != origem; v = BFS.pai[v]) {
                w = BFS.pai[v];
                // Inverte a aresta: pai->filho para pai<-filho.
                residual.reverseEdges(w, v);
                // Adiciona os vértices a lista de caminhos disjuntos.
                disjointpaths.add(new Aresta(v, w));
            }
            
            // Printa o caminho encontrado e limpa a lista para os próximos caminhos.
            printDisjointPaths();
            max_disjointPaths++;
        }

        // Fluxo máximo / número de caminhos disjuntos encontrados.
        return max_disjointPaths;
    }
}
