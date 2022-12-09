import java.io.*;
import java.util.*;
import Components.*;
import Methods.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Construção do grafo com lista vazia de arestas.
        List<Aresta> edgesList = new ArrayList<>();
        Grafo grafo = new Grafo(edgesList);

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String fileName = read.readLine();

        // Leitura do arquivo, construção da lista de adjacência (por sucessores) e ordenação de cada lista.
        grafo = ReadGraph.readGraph(fileName);
        AdjList.ordenarSucessores(grafo);
        // AdjList.printList(grafo);

        // Leitura do vértice de origem e destino e procura de caminhos disjuntos.
        String origem = read.readLine();
        String destino = read.readLine();
        System.out.println("O número máximo de caminhos disjuntos é: " + DisjointPaths.findDisjointPath(grafo, Integer.parseInt(origem), Integer.parseInt(destino)));

        // Grafo.writeGraph(grafo);
    }
}