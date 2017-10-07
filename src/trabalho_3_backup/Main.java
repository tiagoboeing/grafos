/*
 * TRABALHO 3
 *  
 * - Leonardo May (github.com/leonardojcmay)
 * - Tiago Boeing (github.com/tiagoboeing)
 * 
 * Resolução do problema da árvore geradora mínima:
 * 
 * Entrada:
 * - Tipo de grafo: não-orientado - ok
 * - Valorado - somente arestas - ok
 * - Conjunto V - ok
 * - Conjunto E - ok
 * 
 * Saída:
 * - As arestas do subgrafo (árvore geradora mínima) e o custo.
 * 
 * Implementar os dois algoritmos: Kruskal e Prim-Jarnik */

package trabalho_3_backup;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static ArrayList<Vertice> listaVertices = new ArrayList<Vertice>();
	int[] vertices;

	
	// função de entrada de dados
	private static int leConsole(String tipo, Scanner entrada) {

		while (true) {

			System.out.println(tipo + ":");
			String verticeInformado = entrada.nextLine().trim();

			if (verticeInformado.isEmpty()) {
				System.out.println("Programa encerrado!");
				System.exit(0);
			}

		}

	}
	

	// MAIN
	public static void main(String[] args) {
		

		System.out.println("--------------------------");

		int contVertices = 0;
		
		// enquanto console estiver rodando
		while (true) {
			
			// Calcula somente como grafo não-orientado
			Boolean grafoOrientado = false;
			
				
			// CADASTRA VÉRTICES
			Scanner pedeDados = new Scanner(System.in);
			String pedeVertice2 = " ";

			System.out.println("Informe os vértices para cadastrar \n(somente inteiros) - Parar deixe em branco \n");
			while (!pedeVertice2.equals("")) {

				// pede vértices
				System.out.print("Informe um vértice: ");
				pedeVertice2 = pedeDados.nextLine().trim();

				if (!pedeVertice2.equals("")) {
					Vertice v = new Vertice();
					v.setNomeVertice(Integer.parseInt(pedeVertice2));
					listaVertices.add(v);
				}

				contVertices++;
			}

			System.out.println(contVertices);
			// cria grafo
			Grafo grafo = new Grafo(contVertices-1); // cont = quantidade de vértices cadastrados

			
			// CADASTRA ARESTAS
			Scanner pedeDados2 = new Scanner(System.in);
			String pedeArestas = " ";
			String pedeValorArestas = " ";
			int arestaOrigem;
			int arestaDestino;
			int contArestas = 0;

			System.out.println("\n\n============\n"
					+ "Informe as arestas \n(separadas por , Ex.: 1,2) - PARAR? Deixe em branco \n");
			while (!pedeArestas.equals("")) {

				try {

					// PEDE PAR DE ARESTAS
					System.out.print("Arestas: ");
					pedeArestas = pedeDados2.nextLine().trim();

					String[] dados = pedeArestas.split(",");
					arestaOrigem = Integer.parseInt(dados[0])-1;
					arestaDestino = Integer.parseInt(dados[1])-1;

					// PEDE VALOR DO PAR DE ARESTAS
					System.out.print("Valor do par de arestas " + pedeArestas + " (inteiro): ");
					pedeArestas = pedeDados2.nextLine().trim();

					int valorAresta = Integer.parseInt(pedeArestas);

					contArestas++; // contador

					// só aceita par
					if (dados.length > 0 && dados.length <= 2) {

						if (!pedeArestas.equals("")) {

							for (int i = 0; i < contArestas; i++) {
								grafo.criaAresta(arestaOrigem, arestaDestino, valorAresta, grafoOrientado);
							}
							
						}

					} else {
						System.out.println("OPSS, PRECISA SER UM PAR DE ARESTAS!");
						pedeArestas = pedeDados2.nextLine().trim();
					}

				} catch (Exception e) {
					System.out.println("\n-----------------\n A aresta não faz parte da lista de vértices ou você digitou valores inválidos.\n Caso tenha utilizado a função SAIR, ignore a mensagem \n\n");
				}	
				
			}
			
			
			grafo.colocaOrdemCrescente();
			
			
		}
	}
	

	
	private static void listaVertices() {

		System.out.println("\n\n===========\nLISTA DE VÉRTICES");
		for (Vertice v : listaVertices) {

			System.out.println(v.getNomeVertice());

		}

	}

}
