package modelo;

import java.util.Scanner;

public class Main {
	
    private static final int V1 = 0;
    private static final int V2 = 1;
    private static final int V3 = 2;
    private static final int V4 = 3;
    private static final int V5 = 4;


    private static int readStation(String type, Scanner in) {
        while (true) {
            System.out.println(type + ":");
            String line = in.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("Programa encerrado!");
                System.exit(0);
            }
            try {
                int station = Integer.parseInt(line);
                if (station >= 1 && station <= 20) return station-1;
            } catch (NumberFormatException e) {
            }
            System.out.println("Vértice inválido!");
        }
    }


    public static void main(String[] args) {
        // Create the Graphland Subway System
        // (see subwaySystem.pdf file in extra folder)
        //--------------------------------------------
        Grafo grafo = new Grafo(20);

        // ARESTAS E CUSTOS - origem e destino
        grafo.makeEdge(V1, V2, 5);
        grafo.makeEdge(V1, V3, 20);
        grafo.makeEdge(V1, V4, 40);
        grafo.makeEdge(V1, V5, 50);
        grafo.makeEdge(V2, V4, 15);
        grafo.makeEdge(V3, V5, 5);
        grafo.makeEdge(V4, V5, 5);


        //Graphland Subway Terminal
        //-------------------------
        Scanner in = new Scanner(System.in);
        System.out.println("-------------------------------------------------------");

        while (true) {
            System.out.println("Informe o vértice de partida e o de destino \n(deixa em branco para fechar)\n");
            int origem = readStation("Vértice de inicial", in);
            int destino = readStation("Destino", in);

            System.out.println("Caminho mais curto:");
            for (Integer station : grafo.path(origem, destino)) {
                System.out.print((station+1) + " -> ");
            }
            System.out.println("EXIT");
        }
    }
}
