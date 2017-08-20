package trabalho_1;

import javax.swing.JOptionPane;

public class main {
	
	public static void main(String[] args) {
		
		int tipo = Integer.parseInt(JOptionPane.showInputDialog("Tipo de grafo \n 1 - NÃO ORIENTADO | 2 - ORIENTADO"));
		
		Grafo g = new Grafo();
		
		// questiona tipo de grafo
		g.setTipoGrafo(tipo);
		
		// pede para informar vértices
		g.informarVertices();
		
		// pergunta arestas
		g.informarArrestas();
		
		// listagem pós cadastros
		g.listarArestas();
		g.listaAdjacencia();
		
		// exibe matrizes
		g.matrizAdjacencia();
		g.matrizIncidencia();
		
	}
}
