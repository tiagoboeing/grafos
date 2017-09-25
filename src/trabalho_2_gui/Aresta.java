package trabalho_2_gui;

public class Aresta {

	private int verticeOrigem;
	private int verticeDestino;
	private int valor;
	
	
	public Aresta(int verticeOrigem, int verticeDestino, int valor) {
		this.verticeOrigem = verticeOrigem;
		this.verticeDestino = verticeDestino;
		this.valor = valor;
	}

	
	public int getCentro(int arestaOrigem) {
		
		if(this.getVerticeOrigem() == verticeOrigem) {
			return this.verticeDestino;
		} else {
			return this.verticeOrigem;
		}

	}


	
	// GET E SET
	public int getVerticeOrigem() {
		return verticeOrigem;
	}

	public void setVerticeOrigem(int verticeOrigem) {
		this.verticeOrigem = verticeOrigem;
	}

	public int getVerticeDestino() {
		return verticeDestino;
	}

	public void setVerticeDestino(int verticeDestino) {
		this.verticeDestino = verticeDestino;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}


}
