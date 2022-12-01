package Components;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe para a leitura de um arquivo de texto com uma lista de adjacência.
 */
public class ReadGraph {
    public static int numVertex;
    public static int numEdges;

    /**
     * Método para a leitura do arquivo de texto.
     * @param fileName - nome do arquivo de input do usuário.
     * @return - grafo construído pela leitura do arquivo.
     * @throws Exception - arquivo não encontrado.
     */
    public static Grafo readGraph(String fileName) throws Exception {
        FileReader file = new FileReader(fileName);
        BufferedReader rd = new BufferedReader(file);

        int vEdge = 0;
        int wEdge = 0;
        // Lista de arestas para construção do grafo.
        List<Aresta> edgesList = new ArrayList<>();

        // Leitura de arquivo e seu cabeçalho com número de vértices e arestas.
        String line = rd.readLine();
        String[] delimiter = line.split("\\s+"); // split por espaços " ".
        numVertex = Integer.parseInt(delimiter[0]);
        numEdges = Integer.parseInt(delimiter[1]);

        // Leitura de vértices v -> w (Grafo direcionado).
        while((line = rd.readLine()) != null) {
            String[] vertices = line.split("\\s+"); // split por espaços " ".
            // Vértice da primeira coluna tem uma aresta direcionada para o vértice da segunda coluna.
            vEdge = Integer.parseInt(vertices[1]); // <tab> v.
            wEdge = Integer.parseInt(vertices[2]); // <tab> v <tab> w.
            edgesList.add(new Aresta(vEdge, wEdge)); // Adicionando aresta direcioanda a uma lista de arestas.
        }

        file.close();
        // Atribuindo a lista de arestas para o construtor do grafo.
        Grafo grafo = new Grafo(edgesList);
        
        return (grafo);
    }
}