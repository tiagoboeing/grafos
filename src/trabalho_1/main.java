package trabalho_1;

import javax.swing.JOptionPane;

public class main {
	
	public static void main(String[] args) {
		
		int tipo = Integer.parseInt(JOptionPane.showInputDialog("Tipo de grafo \n 1 - N�O ORIENTADO | 2 - ORIENTADO"));
		
		Grafo g = new Grafo();
		
		// questiona tipo de grafo
		g.setTipoGrafo(tipo);

		// pede para informar v�rtices
		g.informarVertices();
		
			// pergunta arestas e se grafo � valorado ou n�o
			String valorado = JOptionPane.showInputDialog("Grafo valorado? SIM - N�O | 1 ou 0");
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
		
	}
}
