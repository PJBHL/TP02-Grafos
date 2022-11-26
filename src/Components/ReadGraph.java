package Components;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadGraph {
    public static int numVertex;
    public static int numEdges;

    public static Grafo readGraph(String fileName) throws Exception {
        FileReader file = new FileReader(fileName);
        BufferedReader rd = new BufferedReader(file);

        int vEdge = 0;
        int wEdge = 0;
        List<Aresta> edgesList = new ArrayList<>(); // Lista de arestas para construção do grafo.

        // Leitura de arquivo e seu cabeçalho com número de vértices e arestas.
        String line = rd.readLine();
        String[] delimiter = line.split("\\s+"); // split por espaços " ".
        numVertex = Integer.parseInt(delimiter[0]);
        numEdges = Integer.parseInt(delimiter[1]);

        // Leitura de vértices v -> w (Grafo direcionado).
        while((line = rd.readLine()) != null) {
            String[] vertices = line.split("\\s+");
            vEdge = Integer.parseInt(vertices[1]);
            wEdge = Integer.parseInt(vertices[2]);
            edgesList.add(new Aresta(vEdge, wEdge));
        }

        file.close();
        Grafo grafo = new Grafo(edgesList);
        
        return (grafo);
    }
}
