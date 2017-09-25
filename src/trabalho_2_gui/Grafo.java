package trabalho_2_gui;

import java.util.ArrayList;

public class Grafo {

	private Vertice[] vertices;
	
	private int quantVertices;
	private int quantArestas;
	
	private static ArrayList<Aresta> listaArestas = new ArrayList<Aresta>();

	
	
	// fun��o de calculo do grafo - recebe um arraylist
	public Grafo(ArrayList<Aresta> listaArestas) {
		
		
		// atribui recebimento do m�todo
		this.listaArestas = listaArestas;
		this.quantVertices = calculaQuantDeVertices(listaArestas); // 5 v�rtices no grafo de exemplo
		this.vertices = new Vertice[this.quantVertices]; // vetor de tamanho [5]
		
		for (int i = 0; i < this.quantVertices; i++) {
			this.vertices[i] = new Vertice();
		}

		// quantidade de arestas � o tamanho do arraylist
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
	
	
	

	// algoritmo de dijkstra - calcula menor dist�ncia
	public void calculaMenorDistancia() {

		// v�rtice de origem � 0
		this.vertices[0].setDistanciaDaOrigem(0);
		int proximoVertice = 0;

		// visita todos os v�rtices
		for (int i = 0; i <= this.vertices.length; i++) {

			// rodear a vizinhan�a
			ArrayList<Aresta> currentArestaVertices = this.vertices[proximoVertice].getListaArestas();

			for (int a = 0; a < currentArestaVertices.size(); a++) {
				int centroIndice = currentArestaVertices.get(a).getCentro(proximoVertice);

				// somente se n�o for visitado
				if (!this.vertices[centroIndice].isVisitado()) {

					int tentative = this.vertices[proximoVertice].getDistanciaDaOrigem()
							+ currentArestaVertices.get(a).getValor();

					if (tentative < vertices[centroIndice].getDistanciaDaOrigem()) {
						vertices[centroIndice].setDistanciaDaOrigem(tentative);
					}
				}
			}

			// toda vizinhan�a visitada, passou todos os v�rtices
			vertices[proximoVertice].setVisitado(true);

			// pr�ximo v�rtice deve ter dist�ncia mais curta
			proximoVertice = getVerticeMenorDistancia();

		}
	}

	// implementa m�todo de menor dist�ncia
	private int getVerticeMenorDistancia() {

		int verticePartida = 0;
		int storedDist = Integer.MAX_VALUE;

		for (int i = 0; i <= this.vertices.length; i++) {

			int currentDist = this.vertices[i].getDistanciaDaOrigem();

			// SE o v�rtice n�o foi visitado ainda AND a dist�ncia da v�rtice atual for
			// menor que infinito
			// ENT�O valor que era infino recebe a dist�ncia do v�rtice atual
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

		saida += "Quantidade de v�rtices: " + this.quantVertices;
		saida += "\n Quantidade de arestas: " + this.quantArestas;
		
		for (int i = 0; i <= this.vertices.length; i++) {
			saida += "\n O menor caminho do v�rtice 0 ao " + i + " � " + vertices[i].getDistanciaDaOrigem();
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
