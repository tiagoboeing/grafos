package trabalho_final_seminario;

import java.util.ArrayList;
import java.util.Scanner;

public class Financeiramente {

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

			System.out.println("VÈrtice inv·lido!");
		}
	}
	

	
	public static void main(String[] args) {

		System.out.println("--------------------------");

		int contVertices = 0;
		
		
		
		
		// enquanto console estiver rodando
		while (true) {
			
			
			// tipo de grafo
			Boolean grafoOrientado = false;
								
			
			// cadastra vÈrtices
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
			
			
			
			// cria grafo
			Grafo grafo = new Grafo(listaVertices.size());
			

			// ARESTAS E CUSTOS - origem, destino, custo, orientado??

			// EDUCA«√O
			grafo.criaAresta(0, 1, 3323126, grafoOrientado); // 2015
			grafo.criaAresta(0, 2, 3347332, grafoOrientado); //2016
			grafo.criaAresta(0, 3, 2945936, grafoOrientado); //2017
			
			grafo.criaAresta(1, 4, 3323126, grafoOrientado);
			grafo.criaAresta(2, 4, 3347332, grafoOrientado);
			grafo.criaAresta(3, 4, 2945936, grafoOrientado);
			

			// AGRICULTURA
			grafo.criaAresta(4, 5, 626764, grafoOrientado); // 2015
			grafo.criaAresta(4, 6, 628595, grafoOrientado); //2016
			grafo.criaAresta(4, 7, 564548, grafoOrientado); //2017
			
			grafo.criaAresta(5, 8, 626764, grafoOrientado);
			grafo.criaAresta(6, 8, 628595, grafoOrientado);
			grafo.criaAresta(7, 8, 564548, grafoOrientado);
			
			
			// TI
			grafo.criaAresta(8, 9, 198935, grafoOrientado); // 2015
			grafo.criaAresta(8, 10, 179113, grafoOrientado); //2016
			grafo.criaAresta(8, 11, 218034, grafoOrientado); //2017
			
			grafo.criaAresta(9, 12, 198935, grafoOrientado);
			grafo.criaAresta(10, 12, 179113, grafoOrientado);
			grafo.criaAresta(11, 12, 218034, grafoOrientado);
			
			
			// SeguranÁa
			grafo.criaAresta(12, 13, 2368289, grafoOrientado); // 2015
			grafo.criaAresta(12, 14, 2614242, grafoOrientado); //2016
			grafo.criaAresta(12, 15, 2289408, grafoOrientado); //2017
			
			grafo.criaAresta(13, 16, 2368289, grafoOrientado);
			grafo.criaAresta(14, 16, 2614242, grafoOrientado);
			grafo.criaAresta(15, 16, 2289408, grafoOrientado);
			
				
			
				System.out.println("DESEJA INFORMAR ORIGEM E DESTINO? \nDigite: SIM ou N√O");
								
				Scanner entrada = new Scanner(System.in);
				String entradaConsole = entrada.nextLine().trim();
				
				if(entradaConsole.equalsIgnoreCase("SIM")) {
					
					// SOLICITA ORIGEM E DESTINO
					Scanner in = new Scanner(System.in);
					int origem = leConsole("\n \n¡rea/ano de origem", in);
					System.out.println("");
					
					Scanner in2 = new Scanner(System.in);
					int destino = leConsole("¡rea/ano de destino", in2);
					System.out.println("");
					
						for (Integer i : grafo.caminho(origem, destino)) {
							System.out.print((i) + " --> ");
						}
						
						System.out.println("FIM");

					
				} else {
					
					// SOLICITA SOMENTE ORIGEM
					Scanner in = new Scanner(System.in);
					int origem = leConsole("\n \n¡rea/ano de origem", in);
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

		System.out.println("\n\n===========\nLISTA DE V…RTICES");
		for (Vertice v : listaVertices) {

			System.out.println(v.getNomeVertice());

		}

	}

}
