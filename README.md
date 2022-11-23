## Trabalho Prático 02 - Teória dos Grafos e Computabilidade.

Dado um grafo direcionado e simples, um caminho simples é um caminho sem vértices repetidos. Caminhos disjuntos de arestas representam caminhos que não tem nenhuma aresta em comum, mas com a mesma origem e destino.

O trabalho envolve determinar:
 - O número máximo de caminho disjuntos de arestas.
 - Listar cada um dos dos caminhos disjuntos encontrados.
 
 A implementação foi feita em Java, o grafo é representado por uma lista de adjacência e os grafos usados no trabalho são retirados de arquivos de texto que seguem o seguinte padrão:

### grafo.txt
| Número de Vértices do Grafo | Número de Arestas do Grafo |
| :---:   | :---: |
| Vértice v | Vértice w |

A primeira coluna representa o vértice cujo terá uma aresta direcionada ligada ao vértice da segunda coluna, isto é v -> w.
