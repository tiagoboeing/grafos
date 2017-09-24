package trabalho_2;

import javax.swing.JOptionPane;

public class Main {
	
	public static void main(String[] args) {
		
		
		Aresta[] arestas = {
				
				new Aresta(0, 2, 1),
				new Aresta(0, 3, 4),
				new Aresta(0, 4, 2),
				new Aresta(0, 1, 3),
				new Aresta(1, 3, 2),
				new Aresta(1, 4, 3),
				new Aresta(1, 5, 1),
				new Aresta(2, 4, 1),
				new Aresta(3, 5, 4),
				new Aresta(4, 5, 2),
				new Aresta(4, 6, 7),
				new Aresta(4, 7, 2),
				new Aresta(5, 6, 4),
				new Aresta(6, 7, 5)				
		};
		
		
		Grafo g = new Grafo(arestas);
		g.calculaMenorDistancia();
		
		g.mostraResultado();
		
		
	}

}
