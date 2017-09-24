package Larroyd;

import javax.swing.JOptionPane;

public class principal {
	public static void main(String[] args) {
		int tipo = Integer.parseInt(JOptionPane.showInputDialog(
				"Digite o tipo de grafo \n 1 - não orientado \n 2 - orientado"));
		
		Grafo grafo = new Grafo();
		
		int valorado = Integer.parseInt(JOptionPane.showInputDialog(
				"Possui valores \n 1 - não possui \n 2 - possui"));
		
		if(valorado == 2){
			grafo.setValorado(true);
		}else{
			grafo.setValorado(false);
		}
		
		grafo.setTipoGrafo(tipo);
		grafo.informarVertices();
		grafo.informarArrestas();
		grafo.listarArestas();
		grafo.listaAdjacencia();
		grafo.matrizAdjacencia();
		grafo.matrizIncidencia();
		grafo.matrisDistancia();
	}
}