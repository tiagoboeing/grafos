package grafos.estrutura;

import java.util.ArrayList;

public class Grafo {
	
	private ArrayList<String> vertices = new ArrayList<String>();
	private ArrayList<Aresta> arestas = new ArrayList<Aresta>();
	
	private boolean dirigido;
	
	public ArrayList<Aresta> getListaArestaPorVeticeNaoDirigido(String vertice){
		ArrayList<Aresta> caminhos = new ArrayList<>();
		for (Aresta aresta : arestas) {
			if (aresta.getPontoA().equals(vertice) || aresta.getPontoB().equals(vertice)) {
				caminhos.add(aresta);
			}
		}
		return caminhos;
	}

	public ArrayList<String> getVertices() {
		return vertices;
	}
	public void setVertices(ArrayList<String> vertices) {
		this.vertices = vertices;
	}
	public ArrayList<Aresta> getArestas() {
		return arestas;
	}
	public void setArestas(ArrayList<Aresta> arestas) {
		this.arestas = arestas;
	}
	public boolean isDirigido() {
		return dirigido;
	}
	public void setDirigido(boolean dirigido) {
		this.dirigido = dirigido;
	}
	
}
