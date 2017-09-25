package trabalho_2_gui;

import java.util.ArrayList;

public class Grafo {

	private Vertice[] vertices;
	
	private int quantVertices;
	private int quantArestas;
	
	private static ArrayList<Aresta> listaArestas = new ArrayList<Aresta>();

	
	
	// função de calculo do grafo - recebe um arraylist
	public Grafo(ArrayList<Aresta> listaArestas) {
		
		
		// atribui recebimento do método
		this.listaArestas = listaArestas;
		this.quantVertices = calculaQuantDeVertices(listaArestas); // 5 vértices no grafo de exemplo
		this.vertices = new Vertice[this.quantVertices]; // vetor de tamanho [5]
		
		for (int i = 0; i < this.quantVertices; i++) {
			this.vertices[i] = new Vertice();
		}

		// quantidade de arestas é o tamanho do arraylist
		this.quantArestas = listaArestas.size(); // 7 no grafo de exemplo
		
		
		for (int ar = 0; ar < this.quantArestas; ar++) {
			
			
			//this.vertices[listaArestas.get(ar).getVerticeOrigem()].getListaArestas().add(listaArestas.get(ar));

			//this.vertices[listaArestas.get(ar).getVerticeDestino()].getListaArestas().add(listaArestas.get(ar));
			
			
		}
	}

	// calcula quantidade de arestas
	private int calculaQuantDeVertices(ArrayList<Aresta> arestas) {

		int quantDeArestas = 0;

		for (Aresta a : arestas) {
			if (a.getVerticeDestino() > quantVertices) {
				quantVertices = a.getVerticeDestino();
			} else if (a.getVerticeOrigem() > quantVertices) {
				quantVertices = a.getVerticeOrigem();
			}
		}

		//quantVertices++;

		return quantVertices;
	}
	
	
	

	// algoritmo de dijkstra - calcula menor distância
	public void calculaMenorDistancia() {

		// vértice de origem é 0
		this.vertices[0].setDistanciaDaOrigem(0);
		int proximoVertice = 0;

		// visita todos os vértices
		for (int i = 0; i <= this.vertices.length; i++) {

			// rodear a vizinhança
			ArrayList<Aresta> currentArestaVertices = this.vertices[proximoVertice].getListaArestas();

			for (int a = 0; a < currentArestaVertices.size(); a++) {
				int centroIndice = currentArestaVertices.get(a).getCentro(proximoVertice);

				// somente se não for visitado
				if (!this.vertices[centroIndice].isVisitado()) {

					int tentative = this.vertices[proximoVertice].getDistanciaDaOrigem()
							+ currentArestaVertices.get(a).getValor();

					if (tentative < vertices[centroIndice].getDistanciaDaOrigem()) {
						vertices[centroIndice].setDistanciaDaOrigem(tentative);
					}
				}
			}

			// toda vizinhança visitada, passou todos os vértices
			vertices[proximoVertice].setVisitado(true);

			// próximo vértice deve ter distância mais curta
			proximoVertice = getVerticeMenorDistancia();

		}
	}

	// implementa método de menor distância
	private int getVerticeMenorDistancia() {

		int verticePartida = 0;
		int storedDist = Integer.MAX_VALUE;

		for (int i = 0; i <= this.vertices.length; i++) {

			int currentDist = this.vertices[i].getDistanciaDaOrigem();

			// SE o vértice não foi visitado ainda AND a distância da vértice atual for
			// menor que infinito
			// ENTÃO valor que era infino recebe a distância do vértice atual
			if (!this.vertices[i].isVisitado() && currentDist < storedDist) {
				storedDist = currentDist;
				verticePartida = i;
			}
		}

		return verticePartida;
	}

	// mostra resultado
	public void mostraResultado() {
		String saida = "";

		saida += "Quantidade de vértices: " + this.quantVertices;
		saida += "\n Quantidade de arestas: " + this.quantArestas;
		
		for (int i = 0; i <= this.vertices.length; i++) {
			saida += "\n O menor caminho do vértice 0 ao " + i + " é " + vertices[i].getDistanciaDaOrigem();
		}
		
		System.out.println(saida);
	}
	
	
	
	
	public int getQuantArestas() {
		return quantVertices;
	}

	public int getQuantVertices() {
		return quantArestas;
	}

	public Vertice[] getVertices() {
		return vertices;
	}

	public void setVertices(Vertice[] vertices) {
		this.vertices = vertices;
	}

	public void setQuantVertices(int quantVertices) {
		this.quantVertices = quantVertices;
	}

	public void setQuantArestas(int quantArestas) {
		this.quantArestas = quantArestas;
	}

	public static ArrayList<Aresta> getListaArestas() {
		return listaArestas;
	}

	public static void setListaArestas(ArrayList<Aresta> listaArestas) {
		Grafo.listaArestas = listaArestas;
	}

}
