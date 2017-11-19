package trabalho_final_seminario;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static ArrayList<Vertice> listaVertices = new ArrayList<Vertice>();
	int[] vertices;
	
	private static int leConsole(String tipo, Scanner entrada) {

		while (true) {

			System.out.print(tipo + ":");
			String verticeInformado = entrada.nextLine().trim();

			if (verticeInformado.isEmpty()) {
				System.out.println("Programa encerrado!");
				System.exit(0);
			}
			try {

				int vertInf = Integer.parseInt(verticeInformado);
				if (vertInf >= 0) {
					return vertInf;
				}

			} catch (NumberFormatException e) {
			}

			System.out.println("Vértice inválido!");
		}
	}
	

	
	public static void main(String[] args) {

		System.out.println("--------------------------");

		int contVertices = 0;
		
		
		System.out.println("0 = Centro\r\n" + 
				"1 = Vila Medianeira\r\n" + 
				"2 = Nossa Sra. Aparecida\r\n" + 
				"3 = Vila José Nazário\r\n" + 
				"4 = Sertãozinho\r\n" + 
				"5 = São Francisco\r\n" + 
				"6 = Vila São Bernardo\r\n" + 
				"7 = Vila Nova\r\n" + 
				"8 = Sertão dos Correas\r\n" + 
				"9 = Portal\r\n" + 
				"10 = Mãe Peregrina\r\n" + 
				"11 = São Cristóvão\r\n" + 
				"12 = São Roque\r\n" + 
				"13 = São José\r\n" + 
				"14 = Bom Jesus\r\n" + 
				"15 = Olaria\r\n" + 
				"16 = Santa Terezinha\r\n" + 
				"17 = São João do Capivari\r\n" + 
				"18 = Barro Vermelho \n -----------------");
		
		
		
		// enquanto console estiver rodando
		while (true) {
			
			
			// tipo de grafo
			Boolean grafoOrientado = false;
								
			
			// cadastra vértices
			Vertice v0 = new Vertice();
			v0.setNomeVertice(0);
			
			Vertice v1 = new Vertice();
			v1.setNomeVertice(1);
			
			Vertice v2 = new Vertice();
			v2.setNomeVertice(2);
			
			Vertice v3 = new Vertice();
			v3.setNomeVertice(3);
			
			Vertice v4 = new Vertice();
			v4.setNomeVertice(4);
			
			Vertice v5 = new Vertice();
			v5.setNomeVertice(5);
			
			Vertice v6 = new Vertice();
			v6.setNomeVertice(6);
			
			Vertice v7 = new Vertice();
			v7.setNomeVertice(7);

			Vertice v8 = new Vertice();
			v8.setNomeVertice(8);
			
			Vertice v9 = new Vertice();
			v9.setNomeVertice(9);
			
			Vertice v10 = new Vertice();
			v10.setNomeVertice(10);
			
			Vertice v11 = new Vertice();
			v11.setNomeVertice(11);
			
			Vertice v12 = new Vertice();
			v12.setNomeVertice(12);
			
			Vertice v13 = new Vertice();
			v13.setNomeVertice(13);
			
			Vertice v14 = new Vertice();
			v14.setNomeVertice(14);
			
			Vertice v15 = new Vertice();
			v15.setNomeVertice(15);
			
			Vertice v16 = new Vertice();
			v16.setNomeVertice(16);
			
			Vertice v17 = new Vertice();
			v17.setNomeVertice(17);
			
			Vertice v18 = new Vertice();
			v18.setNomeVertice(18);

			
			// adiciona na lista
			listaVertices.add(v0);
			listaVertices.add(v1);
			listaVertices.add(v2);
			listaVertices.add(v3);
			listaVertices.add(v4);
			listaVertices.add(v5);
			listaVertices.add(v6);
			listaVertices.add(v7);
			listaVertices.add(v8);
			listaVertices.add(v9);
			listaVertices.add(v10);
			listaVertices.add(v11);
			listaVertices.add(v12);
			listaVertices.add(v13);
			listaVertices.add(v14);
			listaVertices.add(v15);
			listaVertices.add(v16);
			listaVertices.add(v17);
			listaVertices.add(v18);
			
			
			/* LEGENDA DE BAIRROS
			* 
				0 = Centro
				1 = Vila Medianeira
				2 = Nossa Sra. Aparecida
				3 = Vila José Nazário
				4 = Sertãozinho
				5 = São Francisco
				6 = Vila São Bernardo
				7 = Vila Nova
				8 = Sertão dos Correas
				9 = Portal
				10 = Mãe Peregrina
				11 = São Cristóvão
				12 = São Roque
				13 = São José
				14 = Bom Jesus
				15 = Olaria
				16 = Santa Terezinha
				17 = São João do Capivari
				18 = Barro Vermelho
			*	
			*/
			
			
			// cria grafo
			Grafo grafo = new Grafo(listaVertices.size());
			

			// ARESTAS E CUSTOS - origem, destino, custo, orientado??

			// CENTRO
			grafo.criaAresta(0, 1, 1, grafoOrientado);
			grafo.criaAresta(0, 2, 1, grafoOrientado);
			grafo.criaAresta(0, 3, 1, grafoOrientado);
			grafo.criaAresta(0, 4, 1, grafoOrientado);
			grafo.criaAresta(0, 5, 2, grafoOrientado);
			
			// VILA MEDIANEIRA
			grafo.criaAresta(1, 5, 1, grafoOrientado);
			grafo.criaAresta(1, 6, 1, grafoOrientado);
			grafo.criaAresta(1, 7, 2, grafoOrientado);
			
			// NOSSA SENHORA APARECIDA
			grafo.criaAresta(2, 4, 1, grafoOrientado);
			grafo.criaAresta(2, 8, 2, grafoOrientado);
			
			// VILA JOSÉ NAZÁRIO
			grafo.criaAresta(3, 9, 1, grafoOrientado);
			
			// SERTÃOZINHO
			grafo.criaAresta(4, 8, 2, grafoOrientado);
			
			// SÃO FRANCISCO
			grafo.criaAresta(5, 10, 2, grafoOrientado);
			grafo.criaAresta(5, 11, 4, grafoOrientado);
			
			// VILA SÃO BERNARDO
			grafo.criaAresta(6, 12, 5, grafoOrientado);
			
			// VILA NOVA
			grafo.criaAresta(7, 13, 7, grafoOrientado);
			grafo.criaAresta(7, 14, 4, grafoOrientado);
			
			// SERTÃO DOS CORREAS
			grafo.criaAresta(8, 10, 2, grafoOrientado);
			
			// PORTAL
			grafo.criaAresta(9, 15, 2, grafoOrientado);
			
			// MÃE PEREGRINA
			grafo.criaAresta(10, 16, 4, grafoOrientado);
			
			// SÃO CRISTÓVÃO
			grafo.criaAresta(11, 17, 3, grafoOrientado);
			grafo.criaAresta(11, 14, 1, grafoOrientado);
			
			// SÃO ROQUE
			grafo.criaAresta(12, 18, 4, grafoOrientado);
			
			// OLARIA
			grafo.criaAresta(15, 18, 2, grafoOrientado);
				
			
				System.out.println("DESEJA INFORMAR ORIGEM E DESTINO? \nDigite: SIM ou NÃO");
								
				Scanner entrada = new Scanner(System.in);
				String entradaConsole = entrada.nextLine().trim();
				
				if(entradaConsole.equalsIgnoreCase("SIM")) {
					
					// SOLICITA ORIGEM E DESTINO
					Scanner in = new Scanner(System.in);
					int origem = leConsole("\n \nBairro de origem", in);
					System.out.println("");
					
					Scanner in2 = new Scanner(System.in);
					int destino = leConsole("Bairro de destino", in2);
					System.out.println("");
					
						for (Integer i : grafo.caminho(origem, destino)) {
							System.out.print((i) + " --> ");
						}
						
						System.out.println("FIM");

					
				} else {
					
					// SOLICITA SOMENTE ORIGEM
					Scanner in = new Scanner(System.in);
					int origem = leConsole("\n \nBairro de origem", in);
					System.out.println("");
					
					for(int a = 0; a < listaVertices.size(); a++) {

						for (Integer i : grafo.caminho(origem, a)) {
							System.out.print((i) + " --> ");
						}
						
						System.out.println("FIM");
					}	
					
				}
				
			
				
			
		}
	}
	

	
	private static void listarVertices() {

		System.out.println("\n\n===========\nLISTA DE VÉRTICES");
		for (Vertice v : listaVertices) {

			System.out.println(v.getNomeVertice());

		}

	}

}
