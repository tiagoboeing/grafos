package trabalho_extra_sudoku.copy;

import java.util.LinkedList;
import java.util.Queue;


// grafo não orientado
public class Grafo {

	private Vertice[] vertices;
	private int numVertices = 0;


	/**
	 cria grafo com n vértices
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

	/* realiza busca em profundidade no grafo */
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
	 carry out a breadth first search/traversal of the graph
	 psedocode version
	 */
	public void bfs() {
		for (Vertice v : vertices) v.setVisited(false);
		Queue<Vertice> queue = new LinkedList<Vertice>();
		for (Vertice v : vertices) {
			if (!v.getVisited()) {
				v.setVisited(true);
				v.setPredecessor(v.getIndex());
				queue.add(v);
				while (!queue.isEmpty()) {
					Vertice u = queue.remove();
					for (ListaAdjacencia adj : u.getAdjList()) {
						int index = adj.getverticeNumero();
						Vertice w = vertices[index];
						if (!w.getVisited()) {
							w.setVisited(true);
							w.setPredecessor(u.getIndex());
							queue.add(w);
						}
					}
				}
			}
		}
	}
}
