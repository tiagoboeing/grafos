package trabalho_2_teste;

import java.util.ArrayList;

public class Grafo {

	private Vertice[] vertices;
	private int quantVertices;

	private Aresta[] arestas;
	private int quantArestas;

	public Grafo(Aresta[] arestas) {
		this.arestas = arestas;

		// cria todas as arestas para serem atualizadas junto com os v�rtices
		this.quantVertices = calculaQuantDeVertices(arestas);
		this.vertices = new Vertice[this.quantVertices];

		for (int i = 0; i < this.quantVertices; i++) {
			this.vertices[i] = new Vertice();
		}

		// adiciona todos os v�rtices para as arestas, duas vezes (origem e destino)
		this.quantArestas = arestas.length;

		for (int arestaParaAdicionar = 0; arestaParaAdicionar < this.quantArestas; arestaParaAdicionar++) {
			this.vertices[arestas[arestaParaAdicionar].getVerticeOrigem()].getListaArestas()
					.add(arestas[arestaParaAdicionar]);
			this.vertices[arestas[arestaParaAdicionar].getVerticeDestino()].getListaArestas()
					.add(arestas[arestaParaAdicionar]);
		}

	}

	// calcula quantidade de arestas
	private int calculaQuantDeVertices(Aresta[] arestas) {

		int quantDeArestas = 0;

		for (Aresta a : arestas) {
			if (a.getVerticeDestino() > quantVertices) {
				quantVertices = a.getVerticeDestino();
			} else if (a.getVerticeOrigem() > quantVertices) {
				quantVertices = a.getVerticeOrigem();
			}
		}

		quantVertices++;

		return quantVertices;

	}

	// algoritmo de dijkstra - calcula menor dist�ncia
	public void calculaMenorDistancia() {

		// v�rtice de origem � 0
		this.vertices[0].setDistanciaDaOrigem(0);
		int proximoVertice = 0;

		// visita todos os v�rtices
		for (int i = 0; i < this.vertices.length; i++) {

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

		for (int i = 0; i < this.vertices.length; i++) {

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
		
		for (int i = 0; i < this.vertices.length; i++) {
			saida += "\n O menor caminho do v�rtice 0 ao " + i + " � " + vertices[i].getDistanciaDaOrigem();
		}
		
		System.out.println(saida);
	}
	
	
	
	

	public Vertice[] getArestas() {
		return vertices;
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

	public void setArestas(Aresta[] arestas) {
		this.arestas = arestas;
	}

	public void setQuantArestas(int quantArestas) {
		this.quantArestas = quantArestas;
	}

}
