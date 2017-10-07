package trabalho_3_backup;

import java.util.*;

public class Grafo {
	
    private static final int UNDEFINED = -1;
    private int no[][];

    
    // define vetor de nós - grafo com 10 vertices (new int[10][10])
    public Grafo(int numVertices) {
    	
        no = new int[numVertices][numVertices];
               
    }
    

    // @param vérticeOrigem, vérticeDestino, tipoGrafo = Orientado/true
    public void criaAresta(int vertice1, int vertice2, int custoAresta, boolean isOrientado) {

    	System.out.println(vertice1 + "," + vertice2 + " = " + custoAresta);
    	
        no[vertice1][vertice2] = custoAresta;
        
        // se o grafo for não orientado, adiciona caminho de volta
        if(isOrientado == false) {
        	no[vertice2][vertice1] = custoAresta;
        }
        
    }

    
    // apenas para testes
    public void removeAresta(int vertex1, int vertex2) {
        no[vertex1][vertex2] = 0;
        no[vertex2][vertex1] = 0;
    }

    	
    // descobre custo de uma aresta
    public int getCusto(int vertex1, int vertex2) {
        return no[vertex1][vertex2];
    }
    
    

    // ordena por custo - ORDEM CRESCENTE
    public void colocaOrdemCrescente(){
    	
    	Arrays.sort(no[0]);
    	
    	System.out.println(Arrays.toString(no[1]));

    	
    }
    
    

    /**
     * @param vértice Origem
     * @return uma lista com o índice de todos os vértices conectados ao vértice informado
     */
    public List<Integer> getCentro(int vertex) {
    	
        List<Integer> listaVizinhos = new ArrayList<>();
        
        for (int i = 0; i < no[vertex].length; i++)
        	
            if (no[vertex][i] > 0) {
                listaVizinhos.add(i);
            }

        return listaVizinhos;
    }
    
    
    /**
     * Implementação de ordenação de valores
     */
    
    

    /**
     * Implementação de Dijkstra.
     * @param vértice de origem
     * @param verticeDestino vértice de destino
     * @return o caminho.
     */
    public List<Integer> caminho(int verticeOrigem, int verticeDestino) {
  
        int custo[] = new int[no.length];
        int anterior[] = new int[no.length];
        Set<Integer> listaNaoVisitados = new HashSet<>();

        // o custo para sair do vértice de início é 0 e não possui anteriores
        custo[verticeOrigem] = 0;

        // Todos os outros nós (vértices) terão o custo ajustado para INFINITO (max_value) e o anterior INDEFINIDO
        for (int v = 0; v < no.length; v++) {
            
        	if (v != verticeOrigem) {
                custo[v] = Integer.MAX_VALUE;
            }
            
            anterior[v] = UNDEFINED;
            
            // esquema de fila
            listaNaoVisitados.add(v);
            
            
            
        }
        
        
        

        // BUSCA NO GRAFO
        /**
         * Executa fila enquanto houver vértices não visitado, em outras palavras, 
         * enquanto a listaNaoVisitados tiver itens
         */ 
        while (!listaNaoVisitados.isEmpty()) {
        	
            int proximo = maisProximo(custo, listaNaoVisitados);
            
            // tira o vértice adjacente com menor custo da lista de não visitados, ou seja: marca como visitado
            listaNaoVisitados.remove(proximo);

            
            for (Integer vizinho : getCentro(proximo)) {
            	
            	/** o custoTotal = custo para ir do A,C é 20 + custo para ir do C,D é 5, por exemplo
            	 * custoTotal <- 25 (custo de ir do A até o D)
            	 * se o custo de ir do A > D for menor que o custo pra ir do A,B por ex.:
            	 * ENTÃO
            	 */
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

    
    
    /** pega vertice mais próximo
     * 
     * @param Distância dos vértices da fila
     * @param Fila de vértices que falta visitar
     * @return vértice adjacente com menor custo
     */
    private int maisProximo(int[] dist, Set<Integer> unvisited) {
    	
        double minDist = Integer.MAX_VALUE;
        int minIndex = 0;
        
        for (Integer i : unvisited) {
        	
        	/** Ex.: se o custo para ir de A,C = 20
        	 *  
        	 * SE 20 < infinito ENTÃO 
        	 * 
        	 * infinito <- 20
        	 * minIndex <- vértice[i] 
        	 */
            if (dist[i] < minDist) {
                minDist = dist[i];
                minIndex = i;
            }
            
        }
        return minIndex;
    }

    
    // grava caminho (vértices anteriores)
    private List<Integer> criaListadeCaminhos(int[] anterior, int u) {
        
    	List<Integer> listaCaminho = new ArrayList<>();
        listaCaminho.add(u);
               
        
        while (anterior[u] != UNDEFINED) {
            listaCaminho.add(anterior[u]);
            u = anterior[u];
        }
        
        // pega caminho anterior
        Collections.reverse(listaCaminho);
        
        return listaCaminho;
    }
}
