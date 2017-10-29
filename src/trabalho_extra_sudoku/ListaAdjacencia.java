package trabalho_extra_sudoku;

// lista de adjacência de um vértice no grafo
public class ListaAdjacencia {

	private int verticeNumero;
	private int verticePeso;
	// could be other fields, for example representing
	// properties of the edge - weight, capacity, ...
	
    /* creates a new instance */
	public ListaAdjacencia(int n, int w){
		verticeNumero = n;
		verticePeso = w;
	}
	
	public int getverticeNumero(){
		return verticeNumero;
	}
	
	public void setverticeNumero(int n){
		verticeNumero = n;
	}

	public int getverticePeso() {
		return verticePeso;
	}

	public void setverticePeso(int w) {
		verticePeso = w;
	}
	
}
