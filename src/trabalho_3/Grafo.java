package trabalho_3;

import java.util.*;

public class Grafo {
	
    private static final int UNDEFINED = -1;
    private int no[][];

    
    /**
     *  define vetor de n�s - grafo com 5 vertices (new int[5][5])
     * @param numVertices: quantidade de v�rtices
     * cria matriz de dist�ncias
     */
    public Grafo(int numVertices) {
    	
    	System.out.println("Quant. v�rtices: " + (numVertices));
    	
    	no = new int[numVertices][numVertices];
    	
//        no = new int[4][4];
        
        // GRAFO EXEMPLO
//        no[0][1] = 30;
//        no[1][0] = 30;
//        
//        no[0][2] = 20;
//        no[2][0] = 20;
//        
//        no[2][3] = 5;
//        no[3][2] = 5;
//        
//        no[2][1] = 10;
//        no[1][2] = 10;
        
        
        // chamar na principal
//        primJarnik();
        
    }
    
    
    public void novaAresta(Integer vertice1, Integer vertice2, Integer valorAresta, Boolean isOrientado) {
    	
		no[vertice1][vertice2] = valorAresta;
		
		if(isOrientado == false)
			no[vertice2][vertice1] = valorAresta;
    }
    
    
    // apenas para testes
    public void tabelaValores() {
    	// SA�DA DA TABELA DIST�NCIAS
        for (int i = 0; i < no.length; i++) {
        	System.out.println(Arrays.toString(no[i]));
		}
    }
    
    
    
    /** ENCONTRAR V�RTICE DE MENOR VALOR
     * 
     * @param chaveInicial: v�rtice que ser� origem
     * @param naArvore: indica se est� inclu�do na �rvore
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
     * CONSTR�I �RVORE GERADORA M�NIMA - ALGORITMO DE PRIM JARNIK
     * @param grafo
     * utiliza matriz de adjac�ncia
     */
    void primJarnik()
    {
    	
    	int grafo[][];
    	// passa grafo padr�o
    	grafo = no;
    	
        // guardar o pai para construir �rvore
        int pai[] = new int[no.length];
 
        // para escolher menor custo a ser utilizado
        int chaveOrigem[] = new int [no.length];
 
        // informa o conjunto ainda n�o incluso na �rvore
        Boolean naArvore[] = new Boolean[no.length];
 
        // inicializa os valores como infinito
        for (int i = 0; i < no.length; i++)
        {
            chaveOrigem[i] = Integer.MAX_VALUE;
            naArvore[i] = false;
        }
 
        // sempre incluir o primeiro v�rtice na �rvore geradora
        // define 0 como a origem
        chaveOrigem[0] = 0; 
                    
        // a origem n�o possui pai, � ele mesmo a raiz
        pai[0] = -1; 
 

        for (int count = 0; count < no.length-1; count++)
        {
            // Pega a aresta com menor custo nos 'n�s[][]' e que n�o est� na �rvore ainda
            int u = menorCusto(chaveOrigem, naArvore);
 
            // informa que o v�rtice agora passa a estar na �rvore
            naArvore[u] = true;
 
            // Atualiza o da origem e o pai do v�rtice adjacente
            // considera apenas o que n�o est� na �rvore
            for (int v = 0; v < no.length; v++) {
 
                // n�o pode estar na �rvore
                // Atualiza a origem, somente SE o valor da aresta atual for menor que da origem
                if (grafo[u][v] !=0 && naArvore[v] == false && grafo[u][v] <  chaveOrigem[v]){
                    pai[v]  = u;
                    chaveOrigem[v] = grafo[u][v];
                }
            }
        }
 
        // constr�i �rvore geradora m�nima
        constroiArvore(pai, no.length, grafo);
        
    }
    
    
}
