package trabalho_2;

import java.util.ArrayList;

public class Vertice {
	
	private int distanciaDaOrigem = Integer.MAX_VALUE;
	
	private boolean visitado;
	
	private ArrayList<Aresta> listaArestas = new ArrayList<Aresta>();
	
	
	// GET E SET
	public int getDistanciaDaOrigem() {
		return distanciaDaOrigem;
	}

	public void setDistanciaDaOrigem(int distanciaDaOrigem) {
		this.distanciaDaOrigem = distanciaDaOrigem;
	}

	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public ArrayList<Aresta> getListaArestas() {
		return listaArestas;
	}

	public void setListaArestas(ArrayList<Aresta> listaArestas) {
		this.listaArestas = listaArestas;
	}
	
	
}
