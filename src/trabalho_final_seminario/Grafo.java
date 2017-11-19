package trabalho_final_seminario;

import java.util.*;

public class Grafo {
	
    private static final int UNDEFINED = -1;
    private int vertices[][];

    
    public Grafo(int numVertices) {
        vertices = new int[numVertices][numVertices];
    }

    // @param v�rticeOrigem, v�rticeDestino, tipoGrafo = Orientado/true
    public void criaAresta(int vertex1, int vertex2, int valor, boolean isOrientado) {
        vertices[vertex1][vertex2] = valor;
        
        // se o grafo for n�o orientado, adiciona caminho de volta
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
     * @param v�rtice Origem
     * @return uma lista com o �ndice de todos os v�rtices conectados ao v�rtice informado
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
     * Implementa��o de Dijkstra.
     * @param v�rtice de origem
     * @param verticeDestino v�rtice de destino
     * @return o caminho.
     */
    public List<Integer> caminho(int verticeOrigem, int verticeDestino) {
  
        int custo[] = new int[vertices.length];
        int anterior[] = new int[vertices.length];
        Set<Integer> naoVisitado = new HashSet<>();

        // o custo para sair do v�rtice de in�cio � 0 e n�o possui anteriores
        custo[verticeOrigem] = 0;

        // Todos os outros n�s (v�rtices) ter�o o custo ajustado para INFINITO (max_value) e o anterior INDEFINIDO
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

    
    // pega vertice mais pr�ximo
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
