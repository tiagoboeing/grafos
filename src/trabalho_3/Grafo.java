package trabalho_3;

import java.util.*;

public class Grafo {
	
    private static final int UNDEFINED = -1;
    private int no[][];
    private int quantVertices = 0;

    
    /**
     *  define vetor de nós - grafo com 5 vertices (new int[5][5])
     * @param numVertices: quantidade de vértices
     * cria matriz de distâncias
     */
    public Grafo(int numVertices) {
    	
    	System.out.println("Quant. vértices: " + (numVertices));
    	
    	
    	// inicializa grafo para kruskal
//    	Kruskal kruskal = new Kruskal(numVertices, numVertices);
    	
    	
    	// inicializa para prim jarnik
    	no = new int[numVertices][numVertices];
    	
    	
    	// passa quantidade de vértices para uma variável acessível
    	quantVertices = numVertices; 	
    	        
    }
    
    
    public void novaAresta(Integer vertice1, Integer vertice2, Integer valorAresta, Boolean isOrientado) {
    	
		no[vertice1][vertice2] = valorAresta;
		
		if(isOrientado == false)
			no[vertice2][vertice1] = valorAresta;
    }
    
    
    
    // apenas para testes
    public void tabelaValores() {
    	// SAÍDA DA TABELA DISTÂNCIAS
        for (int i = 0; i < no.length; i++) {
        	System.out.println(Arrays.toString(no[i]));
		}
    }
    
    
    
    /** ENCONTRAR VÉRTICE DE MENOR VALOR
     * 
     * @param chaveInicial: vértice que será origem
     * @param naArvore: indica se está incluído na árvore
     * @return menor valor
     */
    int menorCusto(int chaveInicial[], Boolean naArvore[])
    {
        // Inicializa menor valor
        int min = Integer.MAX_VALUE, min_index=-1;
 
        for (int v = 0; v < no.length; v++)
            if (naArvore[v] == false && chaveInicial[v] < min)
            {
                min = chaveInicial[v];
                min_index = v;
            }
 
        return min_index;
    }
    
    
    void constroiArvore(int parent[], int n, int graph[][])
    {
        System.out.println("Aresta   Peso");
        for (int i = 1; i < no.length; i++)
            System.out.println(parent[i]+" - "+ i+"    "+
                               graph[i][parent[i]]);
    }
        
 	
    // descobre custo de uma aresta
    public int getCusto(int vertex1, int vertex2) {
        return no[vertex1][vertex2];
    }
    
    
    
    
    /**
     * CONSTRÓI ÁRVORE GERADORA MÍNIMA - ALGORITMO DE PRIM JARNIK
     * utiliza matriz de adjacência
     */
    void primJarnik()
    {
    	
    	int grafo[][];
    	// passa grafo padrão
    	grafo = no;
    	
        // guardar o pai para construir árvore
        int pai[] = new int[no.length];
 
        // para escolher menor custo a ser utilizado
        int chaveOrigem[] = new int [no.length];
 
        // informa o conjunto ainda não incluso na árvore
        Boolean naArvore[] = new Boolean[no.length];
 
        // inicializa os valores como infinito
        for (int i = 0; i < no.length; i++)
        {
            chaveOrigem[i] = Integer.MAX_VALUE;
            naArvore[i] = false;
        }
 
        // sempre incluir o primeiro vértice na árvore geradora
        // define 0 como a origem
        chaveOrigem[0] = 0; 
                    
        // a origem não possui pai, é ele mesmo a raiz
        pai[0] = -1; 
 

        for (int count = 0; count < no.length-1; count++)
        {
            // Pega a aresta com menor custo nos 'nós[][]' e que não está na árvore ainda
            int u = menorCusto(chaveOrigem, naArvore);
 
            // informa que o vértice agora passa a estar na árvore
            naArvore[u] = true;
 
            // Atualiza o da origem e o pai do vértice adjacente
            // considera apenas o que não está na árvore
            for (int v = 0; v < no.length; v++) {
 
                // não pode estar na árvore
                // Atualiza a origem, somente SE o valor da aresta atual for menor que da origem
                if (grafo[u][v] !=0 && naArvore[v] == false && grafo[u][v] <  chaveOrigem[v]){
                    pai[v]  = u;
                    chaveOrigem[v] = grafo[u][v];
                }
            }
        }
 
        // constrói Árvore geradora mínima
        constroiArvore(pai, no.length, grafo);  
    }
    
    
    
    
    // ALGORITMO DE KRUSKAL
    void Kruskal() {
    	
    	// inicializa grafo para kruskal
    	Kruskal kruskal = new Kruskal(no.length, no.length);
    	
    	// pega custo e cadastra arestas para Kruskal
        for (int i = 0; i < no.length; i++) {
        	for (int j = 0; j < no.length; j++) {
        		
        		// se o custo for maior que zero quer dizer que não é origem
        		if(getCusto(i, j) > 0){
  
        			kruskal.aresta[i].origem = i;
        			kruskal.aresta[i].destino = j;
        			kruskal.aresta[i].peso = getCusto(i, j);
        			
        		}
        		
			}        	
		}
        
        // chama classe Kruskal que realiza calcule e mostra resultado
    	kruskal.KruskalMST(no);
    	
    }
    
    
    
  
    
}
