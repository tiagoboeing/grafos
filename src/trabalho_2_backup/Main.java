package trabalho_2_backup;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		int tipo = Integer.parseInt(JOptionPane.showInputDialog("Tipo de grafo \n 1 - N�O ORIENTADO | 2 - ORIENTADO"));

		Grafo g = new Grafo();

		// questiona tipo de grafo
		g.setTipoGrafo(tipo);

		// pede para informar v�rtices
		g.informarVertices();

			// EM DIJKSTRA O GRAFO DEVE SER VALORADO SEMPRE
			String valorado = "SIM";
			Boolean isValor = g.grafoValorado(valorado.toUpperCase());
			g.setIsValorado(isValor);

		// pede valor das arestas
		g.informarArestas(isValor);

		// listagem p�s cadastros
		g.listarArestas();
		g.listaAdjacencia();

		// exibe matrizes
		g.matrizAdjacencia();
		g.matrizIncidencia();

		// pergunta qual v�rtice ser� ponto de partida
		String verticePartida = JOptionPane.showInputDialog(
											"Vamos calcular Dijkstra!! \n "
											+ "Qual v�rtice ser� o ponto de partida? \n "
											+ "(precisa estar presente na lista de v�rtices)");

		// chama algoritmo de dijkstra
		g.matrizDistanciaDijkstra(verticePartida);

	}
}
