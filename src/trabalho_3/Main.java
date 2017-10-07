/*
 * TRABALHO 3
 *  
 * - Leonardo May (github.com/leonardojcmay)
 * - Tiago Boeing (github.com/tiagoboeing)
 * 
 * Resolu��o do problema da �rvore geradora m�nima:
 * 
 * Entrada:
 * - Tipo de grafo: n�o-orientado - ok
 * - Valorado - somente arestas - ok
 * - Conjunto V - ok
 * - Conjunto E - ok
 * 
 * Sa�da:
 * - As arestas do subgrafo (�rvore geradora m�nima) e o custo.
 * 
 * Implementar os dois algoritmos: Kruskal e Prim-Jarnik */

package trabalho_3;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	private static ArrayList<Vertice> listaVertices = new ArrayList<Vertice>();

	
	// fun��o de entrada de dados
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
			
			// Calcula somente como grafo n�o-orientado
			Boolean grafoOrientado = false;
			
				
			// CADASTRA V�RTICES
			Scanner pedeDados = new Scanner(System.in);
			String pedeVertice2 = " ";

			System.out.println("Informe os v�rtices para cadastrar \n(somente inteiros) - Parar deixe em branco \n COMECE DO V�RTICE ZERO (0)");
			while (!pedeVertice2.equals("")) {

				// pede v�rtices
				System.out.print("Informe um v�rtice: ");
				pedeVertice2 = pedeDados.nextLine().trim();

				
				// somente para listar v�rtices
				if (!pedeVertice2.equals("")) {
					Vertice v = new Vertice();
					v.setNomeVertice(Integer.parseInt(pedeVertice2));
					listaVertices.add(v);
				}

				contVertices++;
			}

			
			// cria grafo
			Grafo grafo = new Grafo(contVertices-1); // cont = quantidade de v�rtices cadastrados

			
			// CADASTRA ARESTAS
			Scanner pedeDados2 = new Scanner(System.in);
			String pedeArestas = " ";
			String pedeValorArestas = " ";
			int vertice1;
			int vertice2;


			System.out.println("\n\n============\n"
					+ "Informe as arestas \n(separadas por , Ex.: 1,2) - PARAR? Deixe em branco \n");
			while (!pedeArestas.equals("")) {

				try {

					// PEDE PAR DE ARESTAS
					System.out.print("Aresta: ");
					pedeArestas = pedeDados2.nextLine().trim();

					String[] dados = pedeArestas.split(",");
					vertice1 = Integer.parseInt(dados[0]);
					vertice2 = Integer.parseInt(dados[1]);

					// PEDE VALOR DO PAR DE ARESTAS
					System.out.print("Valor da aresta " + pedeArestas + " (inteiro): ");
					pedeArestas = pedeDados2.nextLine().trim();

					int valorAresta = Integer.parseInt(pedeArestas);

					// s� aceita par
					if (dados.length > 0 && dados.length <= 2) {

						if (!pedeArestas.equals("")) {
							
							// cria aresta no grafo
							grafo.novaAresta(vertice1, vertice2, valorAresta, grafoOrientado);
						}

					} else {
						System.out.println("OPSS, PRECISA SER UM PAR DE ARESTAS!");
						pedeArestas = pedeDados2.nextLine().trim();
					}

				} catch (Exception e) {
					System.out.println("\n-----------------\n A aresta n�o faz parte da lista de v�rtices ou voc� digitou valores inv�lidos.\n Caso tenha utilizado a fun��o SAIR, ignore a mensagem \n\n");
				}	
			}
			

			// chama algoritmo de prim
			System.out.println("ALGORITMO DE PRIM-JARNIK \n =========== \n");
			grafo.primJarnik();
			System.out.println("\n ============= \n");
			
		}
		
		
		
		
		
		
	} // fecha MAIN
	

	
	private static void listaVertices() {
		System.out.println("\n\n===========\nLISTA DE V�RTICES");
		for (Vertice v : listaVertices) {
			System.out.println(v.getNomeVertice());
		}
	}

}
