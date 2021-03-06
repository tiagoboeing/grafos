package trabalho_extra_sudoku;

import java.util.LinkedList;

// classe para representar um v�rtice em um gr�fico
public class Vertice {
   
	// lista de adjac�ncia do v�rtice
    private LinkedList<ListaAdjacencia> adjList;
    
    //o �ndice/posi��o do v�rtice
    private int index;
    
    // se o v�rtice foi visitado
    boolean visitado;
    
    // �ndice do v�rtice anterior ao visitado atualmente
    int predecessor; 
    
    // valor armazenado no v�rtice.
    int numero;

    
    // nova inst�ncia de v�rtice
    public Vertice(int n) {
    	
    	adjList = new LinkedList<ListaAdjacencia>();
    	index = n;
    	visitado = false;
    	
    	// indefinido por padr�o
        numero = -1;
        
    }
    
    // repete construtor
    public Vertice(Vertice v){
    	
    	adjList = v.getAdjList();
    	index = v.getIndex();
    	visitado = v.getVisited();
    	
    }
     
    public LinkedList<ListaAdjacencia> getAdjList(){
        return adjList;
    }
    
    public int getIndex(){
    	return index;
    }
    
    public void setIndex(int n){
    	index = n;
    }
    
    public boolean getVisited(){
    	return visitado;
    }
    
    public void setVisited(boolean b){
    	visitado = b;
    }
    
    public int getPredecessor(){
    	return predecessor;
    }
    
    public void setPredecessor(int n){
    	predecessor = n;
    }
    
    public int getNumber() {
        return numero;
    }
    
    public void setNumber(int n) {
        numero = n;
    }
    
    public void addToAdjList(int n, int w){
        adjList.addLast(new ListaAdjacencia(n, w));
    }
    
    public int vertexDegree(){
        return adjList.size();
    }
}
