package Components;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe para a representação e manipulação da lista de adjacência.
 */
public class AdjList {
    /**
     * Método para print da lista de adjacência.
     * @param grafo - Grafo que será printado.
     */
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

    /**
     * Método para obter os sucessores (ou vizinhança) de um vértice, isto é, os membros de sua lista de adjacência.
     * @param grafo - lista de adjacência.
     * @param vertex - vértice para obter os seus sucessores.
     * @return - vetor com todos os sucessores do vértice do parâmetro.
     */
    public static int[] conjuntoSucessores(Grafo grafo, int vertex) {
        return grafo.adjList.get(vertex).stream().mapToInt(i->i).toArray();
    }

    /**
     * Método para obter os predecessores de um vértice, como a lista de adjacência é construída por sucessores
     * para obter os predecessores é necessário caminhar por todos os vértices e suas respectivas listas de adjacência
     * para verificar se o vértice desejado está presente.
     * @param grafo - lista de adjacência.
     * @param vertex - vértice para obter seus predecessores.
     * @return - vetor com todos os predecessores do vértice do parâmetro.
     */
    public static int[] conjuntoPredecessores(Grafo grafo, int vertex) {
        int n = grafo.getSize();
        List<Integer> tempList = new ArrayList<Integer>();

        for(int i = 0; i < n; i++)
            // Verificando cada lista de adjacência.
            for(int j : grafo.adjList.get(i))
                if(j == vertex) {
                    tempList.add(i);
                }

        return tempList.stream().mapToInt(i->i).toArray();
    }

    /**
     * Método para ordenar cada lista de sucessores dos vértices.
     * Não é necessário essa ordenação, no entanto, para grafos aleatórios 
     * é uma abordagem interessante para manter a ordem lexicografica.
     * @param grafo - grafo para ordenar a lista de adjacência.
     */
    public static void ordenarSucessores(Grafo grafo) {
        int n = grafo.getSize();

        for(int i = 0; i < n; i++) {
            Collections.sort(grafo.adjList.get(i));
        }
    }
}