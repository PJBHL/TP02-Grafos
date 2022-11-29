import java.io.*;
import java.util.*;
import Components.*;
import Methods.*;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Aresta> edgesList = new ArrayList<>();
        Grafo grafo = new Grafo(edgesList);
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String fileName = read.readLine();

        grafo = ReadGraph.readGraph(fileName);
        AdjList.ordenarSucessores(grafo);
        AdjList.printList(grafo);
        String origem = read.readLine();
        String destino = read.readLine();
        System.out.println("O número máximo de caminhos disjuntos é: " + DisjointPaths.findDisjointPath(grafo, Integer.parseInt(origem), Integer.parseInt(destino)));
    }
}