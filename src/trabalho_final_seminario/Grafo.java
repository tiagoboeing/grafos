package trabalho_final_seminario;

import java.util.*;

public class Grafo {
	
    private static final int UNDEFINED = -1;
    private int vertices[][];

    
    public Grafo(int numVertices) {
        vertices = new int[numVertices][numVertices];
    }

    // @param vérticeOrigem, vérticeDestino, tipoGrafo = Orientado/true
    public void criaAresta(int vertex1, int vertex2, int valor, boolean isOrientado) {
        vertices[vertex1][vertex2] = valor;
        
        // se o grafo for não orientado, adiciona caminho de volta
        if(isOrientado == false) {
        	vertices[vertex2][vertex1] = valor;
        }
    }

    public void removeAresta(int vertex1, int vertex2) {
        vertices[vertex1][vertex2] = 0;
        vertices[vertex2][vertex1] = 0;
    }

    public int getCusto(int vertex1, int vertex2) {
        return vertices[vertex1][vertex2];
    }
    
    

    /**
     * @param vértice Origem
     * @return uma lista com o índice de todos os vértices conectados ao vértice informado
     */
    public List<Integer> getCentro(int vertex) {
    	
        List<Integer> vizinhos = new ArrayList<>();
        
        for (int i = 0; i < vertices[vertex].length; i++)
            if (vertices[vertex][i] > 0) {
                vizinhos.add(i);
            }

        return vizinhos;
    }

    /**
     * Implementação de Dijkstra.
     * @param vértice de origem
     * @param verticeDestino vértice de destino
     * @return o caminho.
     */
    public List<Integer> caminho(int verticeOrigem, int verticeDestino) {
  
        int custo[] = new int[vertices.length];
        int anterior[] = new int[vertices.length];
        Set<Integer> naoVisitado = new HashSet<>();

        // o custo para sair do vértice de início é 0 e não possui anteriores
        custo[verticeOrigem] = 0;

        // Todos os outros nós (vértices) terão o custo ajustado para INFINITO (max_value) e o anterior INDEFINIDO
        for (int v = 0; v < vertices.length; v++) {
            if (v != verticeOrigem) {
                custo[v] = Integer.MAX_VALUE;
            }
            anterior[v] = UNDEFINED;
            naoVisitado.add(v);
        }

        // BUSCA NO GRAFO
        while (!naoVisitado.isEmpty()) {
        	
            int proximo = maisProximo(custo, naoVisitado);
            naoVisitado.remove(proximo);

            for (Integer vizinho : getCentro(proximo)) {
               
            	int custoTotal = custo[proximo] + getCusto(proximo, vizinho);
            	
                if (custoTotal < custo[vizinho]) {
                    custo[vizinho] = custoTotal;
                    anterior[vizinho] = proximo;
                }
                
            }
            
            // Encontrou?
            if (proximo == verticeDestino) {
                return criaListadeCaminhos(anterior, proximo);
            }
        }

        // Nenhum caminho encontrado
        return Collections.emptyList();
    }

    
    // pega vertice mais próximo
    private int maisProximo(int[] dist, Set<Integer> unvisited) {
    	
        double minDist = Integer.MAX_VALUE;
        int minIndex = 0;
        for (Integer i : unvisited) {
            if (dist[i] < minDist) {
                minDist = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private List<Integer> criaListadeCaminhos(int[] anterior, int u) {
        
    	List<Integer> caminho = new ArrayList<>();
        caminho.add(u);
        
        while (anterior[u] != UNDEFINED) {
            caminho.add(anterior[u]);
            u = anterior[u];
        }
        Collections.reverse(caminho);
        return caminho;
    }
}
