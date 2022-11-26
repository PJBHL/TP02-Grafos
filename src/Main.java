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
        if(BFS.buscaEmLargura(grafo, 2, 5)) {
            System.out.println("Há caminho entre: 2 e 5");
        }
    }
}