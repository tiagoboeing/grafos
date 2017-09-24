package modelo;

import java.util.Scanner;

public class Main {
	
    private static final int V1 = 0;
    private static final int V2 = 1;
    private static final int V3 = 2;
    private static final int V4 = 3;
    private static final int V5 = 4;


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
                	return vertInf-1;
                }
                
            } catch (NumberFormatException e) { }
            
            System.out.println("Vértice inválido!");
        }
    	
    }


    public static void main(String[] args) {
        
    	// cria grafo
        Grafo grafo = new Grafo(20);

        // ARESTAS E CUSTOS - origem e destino
        grafo.makeEdge(V1, V2, 5);
        grafo.makeEdge(V1, V3, 20);
        grafo.makeEdge(V1, V4, 40);
        grafo.makeEdge(V1, V5, 50);
        grafo.makeEdge(V2, V4, 15);
        grafo.makeEdge(V3, V5, 5);
        grafo.makeEdge(V4, V5, 5);


        // para entrada de dados diretamente no console
        Scanner in = new Scanner(System.in);
        System.out.println("--------------------------");

        // enquanto console estiver rodando
        while (true) {
        	
            System.out.println("\nInforme o vértice de partida e o de destino \n(deixa em branco para fechar)\n");
            int origem = leConsole("Vértice de inicial", in);
            int destino = leConsole("Destino", in);

            System.out.println("Caminho mais curto:");
            for (Integer i : grafo.path(origem, destino)) {
                System.out.print((i+1) + " -> ");
            }
            
        }
    }
}
