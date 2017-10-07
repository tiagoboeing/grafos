package trabalho_3_backup;

import java.util.*;

public class Grafo {
	
    private static final int UNDEFINED = -1;
    private int no[][];

    
    // define vetor de n�s - grafo com 10 vertices (new int[10][10])
    public Grafo(int numVertices) {
    	
        no = new int[numVertices][numVertices];
               
    }
    

    // @param v�rticeOrigem, v�rticeDestino, tipoGrafo = Orientado/true
    public void criaAresta(int vertice1, int vertice2, int custoAresta, boolean isOrientado) {

    	System.out.println(vertice1 + "," + vertice2 + " = " + custoAresta);
    	
        no[vertice1][vertice2] = custoAresta;
        
        // se o grafo for n�o orientado, adiciona caminho de volta
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
     * @param v�rtice Origem
     * @return uma lista com o �ndice de todos os v�rtices conectados ao v�rtice informado
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
     * Implementa��o de ordena��o de valores
     */
    
    

    /**
     * Implementa��o de Dijkstra.
     * @param v�rtice de origem
     * @param verticeDestino v�rtice de destino
     * @return o caminho.
     */
    public List<Integer> caminho(int verticeOrigem, int verticeDestino) {
  
        int custo[] = new int[no.length];
        int anterior[] = new int[no.length];
        Set<Integer> listaNaoVisitados = new HashSet<>();

        // o custo para sair do v�rtice de in�cio � 0 e n�o possui anteriores
        custo[verticeOrigem] = 0;

        // Todos os outros n�s (v�rtices) ter�o o custo ajustado para INFINITO (max_value) e o anterior INDEFINIDO
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
         * Executa fila enquanto houver v�rtices n�o visitado, em outras palavras, 
         * enquanto a listaNaoVisitados tiver itens
         */ 
        while (!listaNaoVisitados.isEmpty()) {
        	
            int proximo = maisProximo(custo, listaNaoVisitados);
            
            // tira o v�rtice adjacente com menor custo da lista de n�o visitados, ou seja: marca como visitado
            listaNaoVisitados.remove(proximo);

            
            for (Integer vizinho : getCentro(proximo)) {
            	
            	/** o custoTotal = custo para ir do A,C � 20 + custo para ir do C,D � 5, por exemplo
            	 * custoTotal <- 25 (custo de ir do A at� o D)
            	 * se o custo de ir do A > D for menor que o custo pra ir do A,B por ex.:
            	 * ENT�O
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

    
    
    /** pega vertice mais pr�ximo
     * 
     * @param Dist�ncia dos v�rtices da fila
     * @param Fila de v�rtices que falta visitar
     * @return v�rtice adjacente com menor custo
     */
    private int maisProximo(int[] dist, Set<Integer> unvisited) {
    	
        double minDist = Integer.MAX_VALUE;
        int minIndex = 0;
        
        for (Integer i : unvisited) {
        	
        	/** Ex.: se o custo para ir de A,C = 20
        	 *  
        	 * SE 20 < infinito ENT�O 
        	 * 
        	 * infinito <- 20
        	 * minIndex <- v�rtice[i] 
        	 */
            if (dist[i] < minDist) {
                minDist = dist[i];
                minIndex = i;
            }
            
        }
        return minIndex;
    }

    
    // grava caminho (v�rtices anteriores)
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
