package trabalho_2_backup;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Grafo {

	private ArrayList<Vertice> listaVertices = new ArrayList<Vertice>();
	private ArrayList<Aresta> arestas = new ArrayList<Aresta>();

	private Integer tipoGrafo;
	private Boolean isValorado;

	public int[][] matrizDistancia;

	// pergunta se grafo é valorado ou não
	public Boolean grafoValorado(String valor) {

		Boolean grafoValorado;

		switch (valor) {

		case "SIM":
			grafoValorado = true;
			break;

		case "NÃO":
			grafoValorado = false;
			break;

		case "1":
			grafoValorado = true;
			break;

		case "0":
			grafoValorado = false;
			break;

		default:
			grafoValorado = false;

		}

		return grafoValorado;
	}

	// método para informar vértices
	public void informarVertices() {

		String sair = "";

		// enquanto o usuário continuar informando vertices
		do {

			String nomesVertices = "";

			for (Vertice vertice : listaVertices) {
				nomesVertices += " \n " + vertice.getNome().toUpperCase();
			}

			// exibe lista de vertices cadastrados
			String ver = JOptionPane.showInputDialog("Lista de Vertices:" + nomesVertices + "\n Digite o vertice:");

			// cadastra novo vértice
			Vertice v = new Vertice();
			v.setNome(ver);

			// joga pra arraylist
			listaVertices.add(v);

			// pergunta se o usuário deseja cadastrar mais vértices
			sair = JOptionPane
					.showInputDialog("Sair?\n" + "Digite SIM = p/sair \n" + "Aperte ENTER para cadastrar mais");

		} while (sair.equals(""));

	}

	// ARESTAS
	public void informarArestas(Boolean isValorado) {

		String sair = "";

		// pega vertices já cadastrados
		String nomesVertices = "";

		for (Vertice vertice : listaVertices) {
			nomesVertices += " \n " + vertice.getNome();
		}

		// faz cadastro das arestas agora
		String arestasNomes = "";

		do {

			// faz cadastro
			String aresta1 = JOptionPane
					.showInputDialog("Lista de vértices:" + nomesVertices.toUpperCase() + "\n Lista de arestas: \n"
							+ arestasNomes.toUpperCase() + " \n Informe as arestas separadas por , \n Ex.: 1,2");

			// pega valores individualmente, quebrando por ,
			String[] vertice = aresta1.split(",");

			// cria dois vértices, CHEGADA e SAÍDA
			Vertice vertice1 = new Vertice();
			Vertice vertice2 = new Vertice();

			// varre lista de vértices e passa valores
			for (Vertice vertce : listaVertices) {
				if (vertce.getNome().equalsIgnoreCase(vertice[0])) {
					vertice1 = vertce;
				}
				if (vertce.getNome().equalsIgnoreCase(vertice[1])) {
					vertice2 = vertce;
				}
			}

			// define aresta de chegada e saída
			Aresta aresta = new Aresta();
			aresta.setVerticeChegada(vertice2);
			aresta.setVerticeSaida(vertice1);

			// se o grafo for valorado pede o valor da aresta
			if (getIsValorado() == true) {

				String valorAresta = JOptionPane.showInputDialog("Qual o valor da aresta " + aresta1 + "? (INTEGER)");

				if (valorAresta.equals("")) {
					valorAresta = "0";
				}

				aresta.setValorAresta(Integer.parseInt(valorAresta));

			}

			// joga para o arraylist
			arestas.add(aresta);

			arestasNomes = "";

			// varre arralist de arestas
			for (Aresta art : arestas) {

				if (getIsValorado() == false) {
					arestasNomes += "(" + art.getVerticeSaida().getNome() + "," + art.getVerticeChegada().getNome()
							+ ")";
				} else {
					arestasNomes += "(" + art.getVerticeSaida().getNome() + "," + art.getVerticeChegada().getNome()
							+ ")" + " - Valor: " + art.getValorAresta() + "\n";
				}

			}

			// pergunta se usuário deseja cadastrar mais
			sair = JOptionPane.showInputDialog(
					"Lista de Vertices: " + nomesVertices + "\n" + "Lista De Arrestas: \n" + arestasNomes + " \n "
							+ "Digite - SIM para sair" + " \n " + "Aperte ENTER para cadastrar mais arestas");

		} while (sair.equals(""));

	}

	
	// lista arestas
	public void listarArestas() {

		System.out.println("");
		System.out.println("Lista de Arestas");

		String chegada = "";
		String saida = "";
		String valorLista = "  ";

		// varre lista de arestas
		for (Aresta aresta : arestas) {
			saida += aresta.getVerticeSaida().getNome() + "   |   ";
			chegada += aresta.getVerticeChegada().getNome() + "   |   ";

			// checa se existem valores
			if (getIsValorado() == true) {
				valorLista += aresta.getValorAresta() + "  | ";
			} else {
				valorLista = "--- Grafo não valorado ---";
			}

		}

		// mostra arestas de chegada e saída nos dois conjuntos - V e E
		System.out.println("v  : " + saida);
		System.out.println("e  : " + chegada);
		System.out.println("   " + valorLista);

	}

	
	
	
	// lista matriz de adjacência
	public void listaAdjacencia() {

		System.out.println("\nLista de adjacência");

		// varre arraylist de vértices
		for (Vertice vert : listaVertices) {

			System.out.print("|" + vert.getNome() + "|");

			// varre arestas
			for (Aresta arest : arestas) {

				// se vertice de saida for igual ao vertice atual da lista mostra o de chegada
				if (arest.getVerticeSaida().getNome().equals(vert.getNome())) {

					System.out.print(" -> |" + arest.getVerticeChegada().getNome() + "|");

					// se não mostra o vertice de saída apenas - tipo de grafo deve ser (1) = não
					// orientado
				} else if (this.getTipoGrafo() == 1 && arest.getVerticeChegada().getNome().equals(vert.getNome())) {

					System.out.print(" -> |" + arest.getVerticeSaida().getNome() + "|");

				}

			}
			System.out.println("|/|");
		}
	}
	
	
	

	// matriz de adjacência é uma matriz |V| x |V|
	// a entrada na linha i e coluna j será 1 se e somente se a aresta (i, j)
	// estiver no grafo.
	public void matrizAdjacencia() {

		System.out.println("\nMatriz de adjacência");
		System.out.print("  ");

		// varre vértices
		for (Vertice vert : listaVertices) {
			System.out.print(vert.getNome() + " ");
		}

		System.out.print("\n");

		// cria matriz
		for (int i = 1; i <= listaVertices.size(); i++) {

			Vertice vert = listaVertices.get(i - 1);

			System.out.print(vert.getNome());

			for (int j = 1; j <= listaVertices.size(); j++) {

				Vertice vertice = listaVertices.get(j - 1);
				boolean estaNoGrafo = false;

				// se o gráfico for do tipo 2 = ORIENTADO
				if (tipoGrafo == 2) {

					// varre lista arestas em busca de que a aresta (i, j) esteja no grafo
					for (Aresta aresta : arestas) {

						if (aresta.getVerticeSaida().getNome().equals(vert.getNome())
								&& aresta.getVerticeChegada().getNome().equals(vertice.getNome())) {

							// se a aresta estiver no grafo, seta o boolean
							estaNoGrafo = true;
						}

					}

					// SE NÃO FOR ORIENTADO
				} else {

					// se o grafo não for orientado mas mesmo assim a aresta estiver no grafo
					for (Aresta aresta : arestas) {

						if (aresta.getVerticeSaida().getNome().equals(vert.getNome())
								&& aresta.getVerticeChegada().getNome().equals(vertice.getNome())
								|| aresta.getVerticeChegada().getNome().equals(vert.getNome())
										&& aresta.getVerticeSaida().getNome().equals(vertice.getNome())) {

							// se a aresta estiver no grafo, seta o boolean
							estaNoGrafo = true;
						}

					}

				}

				// se está no grafo a saída será 1, SE NÃO será 0
				if (estaNoGrafo) {
					System.out.print(" 1");
				} else {
					System.out.print(" 0");
				}

			}
			System.out.print("\n");
		}
	}

	
	
	
	// MATRIZ INCIDENCIA
	public void matrizIncidencia() {

		System.out.println("");
		System.out.println("Matriz de Incidencia");
		System.out.print("  ");

		// mostra os dois vértices agrupados
		for (Aresta aresta : arestas) {
			System.out.print(aresta.getVerticeSaida().getNome() + "," + aresta.getVerticeChegada().getNome() + "  ");
		}

		System.out.print("\n");

		// varre os vértices
		for (int i = 1; i <= listaVertices.size(); i++) {

			Vertice vert = listaVertices.get(i - 1);
			System.out.print(vert.getNome());

			for (int j = 1; j <= arestas.size(); j++) {

				Aresta aresta = arestas.get(j - 1);
				int esta = 0;

				// se for um grafo ORIENTADO
				if (tipoGrafo == 2 && aresta.getVerticeSaida().getNome().equals(vert.getNome())) {

					esta = -1;

					// se for um grafo NÃO ORIENTADO
				} else if (tipoGrafo == 1
						&& (aresta.getVerticeSaida().getNome().equals(vert.getNome())
								|| aresta.getVerticeChegada().getNome().equals(vert.getNome()))
						|| tipoGrafo == 2 && aresta.getVerticeChegada().getNome().equals(vert.getNome())) {

					esta = 1;

					// em qualquer outro cenário será 0
				} else {

					esta = 0;

				}

				System.out.print(" " + esta + "   ");
			}

			System.out.print("\n");
		}
	}
	
	
	

	// Dijkstra - MATRIZ MENOR CAMINHO
	public void matrizDistanciaDijkstra(String verticeInicial) {

		
		System.out.println("\n Matriz Distancia - Dijkstra \n");
		System.out.println("---> Partindo do vértice: " + verticeInicial);

		List<Aresta> arestasList = new ArrayList<Aresta>();
		List<Vertice> verticesList = new ArrayList<Vertice>();
		
		// inicia vetor de int com tamanho do arraylist (matriz quadrada)
		matrizDistancia = new int[listaVertices.size()][listaVertices.size()];
		
		
		// esquema do vértice visitado
		for (Vertice vertices2 : listaVertices) {
			
			Vertice vert = vertices2;
			vert.setVerticeAnterior(null);
			verticesList.add(vert);
			
		}

		// adiciona arestas ao arraylist recém criado
		for (Aresta aresta : arestas) {

			Aresta novaAresta = new Aresta();
			aresta.setValorAresta(1);

			for (Vertice vert : verticesList) {
				
				if (vert.getNome().equals(aresta.getVerticeSaida().getNome())) {
					novaAresta.setVerticeSaida(vert);
				} else if (vert.getNome().equals(aresta.getVerticeChegada().getNome())) {
					novaAresta.setVerticeChegada(vert);
				}
				
			}

			novaAresta.setValorAresta(1);
			arestasList.add(novaAresta);
		}
		
		
		// SE for um grafo NÃO ORIENTADO
		if (tipoGrafo == 1) {
			
			arestasList = new ArrayList<Aresta>();
			for (Aresta aresta : arestasList) {
				Aresta arrestaNova = new Aresta();

				for (Vertice vert : verticesList) {
					if (vert.getNome().equals(aresta.getVerticeSaida())) {
						arrestaNova.setVerticeSaida(vert);
					} else if (vert.getNome().equals(aresta.getVerticeChegada())) {
						arrestaNova.setVerticeChegada(vert);
					}
				}

				arrestaNova.setValorAresta(1);
				arestasList.add(arrestaNova);
			}
		}

		int cont = 0;
		for (Vertice vertice : verticesList) {

			
			// define vértice de partida
			for (Vertice vert : verticesList) {
				
				// define vértice de partida
				if (vert.getNome().equals(verticeInicial)) {
					vert.setValorVertice(0);
				} else {
					vert.setValorVertice(99999);
				}
				vert.setVerticeAnterior(null);
				
			}

			for (int i = 0; i < verticesList.size(); i++) {
				for (Aresta aresta : arestasList) {

					int val = aresta.getVerticeSaida().getValorVertice() + aresta.getValorAresta();

					if (aresta.getVerticeChegada().getValorVertice() > val) {
						aresta.getVerticeChegada().setValorVertice(val);
						
						// seta vértice anterior
						aresta.getVerticeChegada().setVerticeAnterior(aresta.getVerticeSaida());
					}
				}
			}

			
			for (int i = 0; i < verticesList.size(); i++) {
				Vertice vert = verticesList.get(i);
				matrizDistancia[cont][i] = vert.getValorVertice();

			}
			cont = cont + 1;
		}

		for (int i = 0; i < matrizDistancia.length; i++) {
			Vertice vert = verticesList.get(i);
			for (int j = 0; j < matrizDistancia.length; j++) {

				if (matrizDistancia[i][j] > vert.getVerticeChegada()) {
					vert.setVerticeChegada(matrizDistancia[i][j]);
				}

				if (matrizDistancia[i][j] > vert.getVerticeSaida()) {
					vert.setVerticeSaida(matrizDistancia[i][j]);
				}

				System.out.println(" -> " + vert.getVerticeChegada());
			}
		}

		listarExentricidades();

		int raio = 99999;
		for (Vertice vertice : listaVertices) {
			if (vertice.getVerticeChegada() < raio) {
				raio = vertice.getVerticeChegada();
			}
		}

		System.out.println("\n Raio: " + raio);

		System.out.println("CENTROS");
		List<Vertice> centros = new ArrayList<Vertice>();
		for (Vertice vertice : listaVertices) {
			if (vertice.getVerticeChegada() == raio)
				centros.add(vertice);
		}

		for (Vertice verticeCentro : centros) {
			System.out.println(verticeCentro.getNome());
		}

	}

	
	
	private void listarExentricidades() {

		int[][] matriz;
		
		// SE for um grafo ORIENTADO
		if (tipoGrafo == 2) {

			int[][] matrizTransposta = new int[matrizDistancia[0].length][matrizDistancia.length];
			
			for (int i = 0; i < matrizTransposta.length; i++) {
				
				for (int j = 0; j < matrizTransposta[0].length; j++) {
					matrizTransposta[j][i] = matrizTransposta[i][j];
				}
				
			}

			matriz = new int[matrizDistancia[0].length][matrizTransposta[0].length];
			for (int i = 0; i < matrizDistancia[0].length; i++) {
				
				for (int j = 0; j < matrizDistancia[0].length; j++) {
					matriz[i][j] = matrizDistancia[i][j] + matrizTransposta[i][j];
				}
				
			}
		} else {
			matriz = matrizDistancia;
		}

		
		//
		for (int i = 0; i < matriz.length; i++) {
			
			Vertice vertice = listaVertices.get(i);
			
			for (int j = 0; j < matriz.length; j++) {
				
				// atribui 
				if (matriz[i][j] > vertice.getVerticeChegada()) {
					vertice.setVerticeChegada(matriz[i][j]);
				}
				
				if (matriz[j][i] > vertice.getVerticeSaida()) {
					vertice.setVerticeSaida(matriz[j][i]);
				}
			}
			
		}
	}
	
	
	

	public ArrayList<Vertice> getVertices() {
		return listaVertices;
	}

	public void setVertices(ArrayList<Vertice> vertice) {
		this.listaVertices = vertice;
	}

	public Integer getTipoGrafo() {
		return tipoGrafo;
	}

	public void setTipoGrafo(Integer tipoGrafo) {
		this.tipoGrafo = tipoGrafo;
	}

	public ArrayList<Aresta> getArrestas() {
		return arestas;
	}

	public void setArrestas(ArrayList<Aresta> arestas) {
		this.arestas = arestas;
	}

	public Boolean getIsValorado() {
		return isValorado;
	}

	public void setIsValorado(Boolean isValorado) {
		this.isValorado = isValorado;
	}
}
