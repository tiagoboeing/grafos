package trabalho_extra_sudoku;

import java.util.LinkedList;
import java.util.Queue;


// grafo n�o orientado
public class Grafo {

	private Vertice[] vertices;
	private int numVertices = 0;


	/**
	 cria grafo com n v�rtices
	*/
	public Grafo(int n) {
		
		numVertices = n;
		vertices = new Vertice[n];
		
		for (int i = 0; i < n; i++)
			vertices[i] = new Vertice(i);
		
	}

	public int size() {
		return numVertices;
	}

	public Vertice getVertex(int i) {
		return vertices[i];
	}

	public void setVertex(int i) {
		vertices[i] = new Vertice(i);
	}
	
	public Vertice[] getVertices() { 
		return vertices;
	}

	
	// visita o vertice v e define vizinho dele
	private void Visitar(Vertice v, int p) {
		
		v.setVisited(true);
		v.setPredecessor(p);
		
		LinkedList<ListaAdjacencia> L = v.getAdjList();
		
		for (ListaAdjacencia node : L) {
			int n = node.getverticeNumero();
			if (!vertices[n].getVisited()) {
				Visitar(vertices[n], v.getIndex());
			}
		}
		
	}

	// realiza busca em profundidade no grafo
	public void dfs() {
		for (Vertice v : vertices) {
			v.setVisited(false);
		}
		for (Vertice v : vertices) {
			if (!v.getVisited()) {
				Visitar(v, -1);
			}
		}
	}


	/**
	 faz primeira busca
	 */
	public void bfs() {
		
		// define como n�o visitado
		for (Vertice v : vertices) v.setVisited(false);
		Queue<Vertice> fila = new LinkedList<Vertice>();
		
		for (Vertice v : vertices) {
			
			if (!v.getVisited()) {
				v.setVisited(true);
				v.setPredecessor(v.getIndex());
				fila.add(v);
				
				while (!fila.isEmpty()) {
					Vertice u = fila.remove();
					for (ListaAdjacencia adj : u.getAdjList()) {
						
						int index = adj.getverticeNumero();
						Vertice w = vertices[index];
						
						if (!w.getVisited()) {
							w.setVisited(true);
							w.setPredecessor(u.getIndex());
							fila.add(w);
						}
						
					} // fecha for
					
				} // fecha while
			}
			
		}
	}
}
