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
                System.out.println("Bye bye!");
                System.exit(0);
            }
            try {
                int station = Integer.parseInt(line);
                if (station >= 1 && station <= 20) return station-1;
            } catch (NumberFormatException e) {
            }
            System.out.println("Invalid station! Try again.");
        }
    }


    public static void main(String[] args) {
        // Create the Graphland Subway System
        // (see subwaySystem.pdf file in extra folder)
        //--------------------------------------------
        Graph subway = new Graph(20);

        // ARESTAS E CUSTOS - origem e destino
        subway.makeEdge(V1, V2, 5);
        subway.makeEdge(V1, V3, 20);
        subway.makeEdge(V1, V4, 40);
        subway.makeEdge(V1, V5, 50);
        subway.makeEdge(V2, V4, 15);
        subway.makeEdge(V3, V5, 5);
        subway.makeEdge(V4, V5, 5);


        //Graphland Subway Terminal
        //-------------------------
        Scanner in = new Scanner(System.in);
        System.out.println("-------------------------------------------------------");

        while (true) {
            System.out.println("Please, enter your desired route. Leave the field blank to exit.");
            int source = readStation("Source", in);
            int destination = readStation("Destination", in);

            System.out.println("Fastest route:");
            for (Integer station : subway.path(source, destination)) {
                System.out.print((station+1) + " -> ");
            }
            System.out.println("EXIT");
        }
    }
}
