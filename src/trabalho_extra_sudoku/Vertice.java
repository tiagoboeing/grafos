package trabalho_extra_sudoku;

import java.util.LinkedList;


/**
 class to represent a vertex in a graph
*/
public class Vertice {
   
    private LinkedList<ListaAdjacencia> adjList ; // the adjacency list of the vertex 
    private int index; // the index of the vertex
    
    // possibly other fields, for example representing data
    // stored at the node, whether the vertex has been visited
    // in a traversal, its predecessor in such a traversal, etc.

    boolean visited; // whether vertex has been visited in a traversal
    int predecessor; // index of predecessor vertex in a traversal
    
    int number; // The number stored at this vertex.

    /**
	 creates a new instance of Vertex
	*/
    public Vertice(int n) {
    	adjList = new LinkedList<ListaAdjacencia>();
    	index = n;
    	visited = false;
        number = -1; // undefined initially.
    }
    
    /**
	 copy constructor
	*/
    public Vertice(Vertice v){
    	adjList = v.getAdjList();
    	index = v.getIndex();
    	visited = v.getVisited();
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
    	return visited;
    }
    
    public void setVisited(boolean b){
    	visited = b;
    }
    
    public int getPredecessor(){
    	return predecessor;
    }
    
    public void setPredecessor(int n){
    	predecessor = n;
    }
    
    public int getNumber() {
        return number;
    }
    
    public void setNumber(int n) {
        number = n;
    }
    
    public void addToAdjList(int n, int w){
        adjList.addLast(new ListaAdjacencia(n, w));
    }
    
    public int vertexDegree(){
        return adjList.size();
    }
}
