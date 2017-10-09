package trabalho_3_backup;

// Kruskal exibe a mesma árvore geradora mínima que o algoritmo de PRIM
// a diferença é o tempo de execução
import java.util.*;
import java.lang.*;
import java.io.*;

class Kruskal
{
    // classe que representa as arestas do grafo
    class Aresta implements Comparable<Aresta>
    {
        int origem, destino, peso;
 
        // Comparação usada para classificar arestas com base em seu peso
        public int compareTo(Aresta compareEdge)
        {
            return this.peso-compareEdge.peso;
        }
    };
 
    // class que representa o subconjunto que encontra união (nó)
    class subset
    {
        int pai, rank;
    };
 
    
    int V, E;    // recebe tamanho do grafo
    Aresta aresta[]; // conjunto de arestas
 
    
    // cria grafo
    Kruskal(int v, int e)
    {
        V = v;
        E = e;
        aresta = new Aresta[E];
        for (int i=0; i < e; ++i)
            aresta[i] = new Aresta();
    }
 
    /** encontrar o conjunto de um elemento (vértice)
     * 
     * @param i = vértice a descobrir melhor caminho
     * @return vértice de origem, de onde tenho que vir para ter a melhor solução
     */
    int find(subset subsets[], int i)
    {
        // encontra a origem e torna pai do vértice
        if (subsets[i].pai != i)
            subsets[i].pai = find(subsets, subsets[i].pai);
 
        return subsets[i].pai;
    }
 
    // faz a união (nó) de dois vértices 
    // o nó é criado de acordo com a ordem - peso
    void Union(subset subsets[], int x, int y)
    {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
 
        // define a árvore com menor custo - baseia-se na árvore de maior custo
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].pai = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].pai = xroot;
 
        // se os custos forem iguals
        else
        {
            subsets[yroot].pai = xroot;
            subsets[xroot].rank++;
        }
    }
 
    // Principal função para construir uma árvore geradora mínima - Minimum spanning tree
    // Algoritmo de Kruskal
    void KruskalMST(int grafo[][])
    {
        Aresta result[] = new Aresta[V];  // Armazena arestas escolhidas da árvore
        int e = 0;  // aux para resultado
        int i = 0;  // aux para arestas ordenadas
        
        for (i=0; i< grafo.length; ++i)
            result[i] = new Aresta();
 
        // Primeiro, classificar arestas em ordem crescente de peso
        // Se não for possível alterar o grafo, ao menos cria uma matriz de arestas
        Arrays.sort(aresta);
 
        // cria subconjuntos
        subset subconjuntos[] = new subset[V];
        
        for(i=0; i < grafo.length; ++i) {
            subconjuntos[i]=new subset();
        }
 
        // Cria subconjunto V com elementos únicos
        for (int v = 0; v < V; ++v)
        {
            subconjuntos[v].pai = v;
            subconjuntos[v].rank = 0;
        }
 
        i = 0;  // índice usado para escolher próximo nó
 
        
        // Número de arestas a ser visitada é igual a V-1 (fila)
        while (e < V - 1){
        	
            // Etapa 2: pega aresta com menos peso
            Aresta proxima_aresta = new Aresta();
            proxima_aresta = aresta[i++];
 
            int x = find(subconjuntos, proxima_aresta.origem);
            int y = find(subconjuntos, proxima_aresta.destino);
 
            // Inclui apenas arestas que não causam ciclo
            // incrementa a variável result para o índice do próximo nó[][]
            if (x != y)
            {
                result[e++] = proxima_aresta;
                Union(subconjuntos, x, y);
            }
            // se criar ciclo, descarta a próxima aresta
        }
 
        // mostra árvore com resultado
        System.out.println("Aresta   Peso");
        for (i = 0; i < e; ++i) {
            System.out.println(result[i].origem + " - " + result[i].destino + "    " + result[i].peso);
        }
        
    }
 
}