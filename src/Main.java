import java.io.*;
import java.util.*;

import Utils.*;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Aresta> edgesList = new ArrayList<>();
        Grafo grafo = new Grafo(edgesList);
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String fileName = read.readLine();

        grafo = ReadGraph.readGraph(fileName);
        AdjList.ordenarSucessores(grafo);
        AdjList.printList(grafo);
    }
}