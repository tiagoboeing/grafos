package trabalho_extra_sudoku;

// lista de adjac�ncia de um v�rtice no grafo
public class ListaAdjacencia {

	private int verticeNumero;
	private int verticePeso;
	
	
    // cria nova inst�ncia
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
