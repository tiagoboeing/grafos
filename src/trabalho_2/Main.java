package trabalho_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
/*
	private static final int V1 = 0;
	private static final int V2 = 1;
	private static final int V3 = 2;
	private static final int V4 = 3;
	private static final int V5 = 4;*/

	private static ArrayList<Vertice> listaVertices = new ArrayList<Vertice>();
	int[] vertices;

	private static int leConsole(String tipo, Scanner entrada) {

		while (true) {

			System.out.println(tipo + ":");
			String verticeInformado = entrada.nextLine().trim();

			if (verticeInformado.isEmpty()) {
				System.out.println("Programa encerrado!");
				System.exit(0);
			}
			try {

				int vertInf = Integer.parseInt(verticeInformado);
				if (vertInf >= 1) {
					return vertInf - 1;
				}

			} catch (NumberFormatException e) {
			}

			System.out.println("V�rtice inv�lido!");
		}

	}
	

	public static void main(String[] args) {

		System.out.println("--------------------------");

		int contVertices = 0;
		
		// enquanto console estiver rodando
		while (true) {
			
			// CADASTRA V�RTICES
			Scanner pedeDados = new Scanner(System.in);
			String pedeVertice2 = " ";

			System.out.println("Informe os v�rtices para cadastrar \n(somente inteiros) - Parar deixe em branco \n");
			while (!pedeVertice2.equals("")) {

				// pede v�rtices
				System.out.print("Informe um v�rtice: ");
				pedeVertice2 = pedeDados.nextLine().trim();

				if (!pedeVertice2.equals("")) {
					Vertice v = new Vertice();
					v.setNomeVertice(Integer.parseInt(pedeVertice2));
					listaVertices.add(v);
				}

				contVertices++;
			}

			
			// cria grafo
			Grafo grafo = new Grafo(contVertices); // cont = quantidade de v�rtices cadastrados
			

			// ARESTAS E CUSTOS - origem e destino
		/*	grafo.criaAresta(V1, V2, 5);
			grafo.criaAresta(V1, V3, 20);
			grafo.criaAresta(V1, V4, 40);
			grafo.criaAresta(V1, V5, 50);
			grafo.criaAresta(V2, V4, 15);
			grafo.criaAresta(V3, V5, 5);
			grafo.criaAresta(V4, V5, 5);*/

			// para entrada de dados diretamente no console
			/*Scanner in = new Scanner(System.in);

			System.out.println("\nInforme o v�rtice de partida e o de destino \n(deixa em branco para fechar)\n");
			int origem = leConsole("V�rtice de inicial", in);
			int destino = leConsole("Destino", in);

			System.out.println("Caminho mais curto:");
			for (Integer i : grafo.caminho(origem, destino)) {
				System.out.print((i + 1) + " -> ");
			}
*/
				
			
			// CADASTRA ARESTAS
			Scanner pedeDados2 = new Scanner(System.in);
			String pedeArestas = " ";
			String pedeValorArestas = " ";
			int arestaOrigem = 0;
			int arestaDestino = 0;
			int contArestas = 0;

			System.out.println("\n\n============\n"
					+ "Informe as arestas \n(separadas por , Ex.: 1,2) - PARAR? Deixe em branco \n");
			while (!pedeArestas.equals("")) {

				try {

					// PEDE PAR DE ARESTAS
					System.out.print("Arestas: ");
					pedeArestas = pedeDados2.nextLine().trim();

					String[] dados = pedeArestas.split(",");
					arestaOrigem = Integer.parseInt(dados[0]);
					arestaDestino = Integer.parseInt(dados[1]);

					// PEDE VALOR DO PAR DE ARESTAS
					System.out.print("Valor do par de arestas " + pedeArestas + " (inteiro): ");
					pedeArestas = pedeDados2.nextLine().trim();

					int valorAresta = Integer.parseInt(pedeArestas);

					contArestas++; // contador

					// s� aceita par
					if (dados.length > 0 && dados.length <= 2) {

						if (!pedeArestas.equals("")) {

							for (int i = 0; i < contArestas; i++) {
								grafo.criaAresta(arestaOrigem-1, arestaDestino-1, valorAresta);
							}
						}

					} else {
						System.out.println("OPSS, PRECISA SER UM PAR DE ARESTAS!");
						pedeArestas = pedeDados2.nextLine().trim();
					}

				} catch (Exception e) {
					System.out.println("\n-----------------\n A aresta n�o faz parte da lista de v�rtices ou voc� digitou valores inv�lidos.\n Caso tenha utilizado a fun��o SAIR, ignore a mensagem \n\n");
				}	
				
			}
			
			
			// SOLICITA PONTO INICIAL e mostra melhor caminho
			Scanner in = new Scanner(System.in);

			/*System.out.println("\nInforme o v�rtice de partida \n(deixe em branco para fechar)\n");
			int origem = leConsole("V�rtice de in�cio", in);
			int destino = leConsole("Destino", in);

			System.out.println("Caminho mais curto:");
			for (Integer i : grafo.caminho(origem, destino)) {
				System.out.print((i + 1) + " -> ");
			}*/

			
			System.out.println("\nInforme o v�rtice de partida \n(deixe em branco para fechar)\n");
			int origem = leConsole("V�rtice de in�cio", in);
			
			System.out.println("Caminho mais curto, partindo do v�rtice: " + origem+1);
			
			for(int a = 0; a < contVertices; a++) {
				
				for (Integer i : grafo.caminho(origem, a)) {
					System.out.print((i + 1) + " -> ");
				}
				System.out.println("CHEGOU");
			}		
			
			
		}
	}
	

	
	private static void listaVertices() {

		System.out.println("\n\n===========\nLISTA DE V�RTICES");
		for (Vertice v : listaVertices) {

			System.out.println(v.getNomeVertice());

		}

	}

}
