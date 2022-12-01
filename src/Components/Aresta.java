package Components;

/**
 * Classe que representa uma aresta no grafo.
 * Aresta direta origem -> destino.
 */
public class Aresta {
    public int origem, destino;

    // Construtor de uma aresta.
    public Aresta(int origem, int destino) {
        this.origem = origem;
        this.destino = destino;
    }
}