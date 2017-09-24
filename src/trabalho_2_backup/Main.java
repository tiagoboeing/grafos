package trabalho_2_backup;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		int tipo = Integer.parseInt(JOptionPane.showInputDialog("Tipo de grafo \n 1 - NÃO ORIENTADO | 2 - ORIENTADO"));

		Grafo g = new Grafo();

		// questiona tipo de grafo
		g.setTipoGrafo(tipo);

		// pede para informar vértices
		g.informarVertices();

			// EM DIJKSTRA O GRAFO DEVE SER VALORADO SEMPRE
			String valorado = "SIM";
			Boolean isValor = g.grafoValorado(valorado.toUpperCase());
			g.setIsValorado(isValor);

		// pede valor das arestas
		g.informarArestas(isValor);

		// listagem pós cadastros
		g.listarArestas();
		g.listaAdjacencia();

		// exibe matrizes
		g.matrizAdjacencia();
		g.matrizIncidencia();

		// pergunta qual vértice será ponto de partida
		String verticePartida = JOptionPane.showInputDialog(
											"Vamos calcular Dijkstra!! \n "
											+ "Qual vértice será o ponto de partida? \n "
											+ "(precisa estar presente na lista de vértices)");

		// chama algoritmo de dijkstra
		g.matrizDistanciaDijkstra(verticePartida);

	}
}
