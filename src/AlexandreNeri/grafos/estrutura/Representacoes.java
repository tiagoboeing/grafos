package grafos.estrutura;

import java.util.ArrayList;
import java.util.HashMap;

public class Representacoes {
	
	private HashMap<String,ArrayList<String>> listasDeAdjacencia = new HashMap<String, ArrayList<String>>();
	private int[][] matrizDeAdjacencia;
	private int[][] matrizDeIncidencia;
	private ArrayList<String> centroGrafo = new ArrayList<>(); 
	private ArrayList<ArrayList<String>> listasDeArestas = new ArrayList<ArrayList<String>>();	
	
	public ArrayList<String> getCentroGrafo() {
		return centroGrafo;
	}
	public void setCentroGrafo(ArrayList<String> centroGrafo) {
		this.centroGrafo = centroGrafo;
	}
	public HashMap<String, ArrayList<String>> getListasDeAdjacencia() {
		return listasDeAdjacencia;
	}
	public void setListasDeAdjacencia(
			HashMap<String, ArrayList<String>> listasDeAdjacencia) {
		this.listasDeAdjacencia = listasDeAdjacencia;
	}
	public int[][] getMatrizDeAdjacencia() {
		return matrizDeAdjacencia;
	}
	public void setMatrizDeAdjacencia(int[][] matrizDeAdjacencia) {
		this.matrizDeAdjacencia = matrizDeAdjacencia;
	}
	public int[][] getMatrizDeIncidencia() {
		return matrizDeIncidencia;
	}
	public void setMatrizDeIncidencia(int[][] matrizDeIncidencia) {
		this.matrizDeIncidencia = matrizDeIncidencia;
	}
	public ArrayList<ArrayList<String>> getListasDeArestas() {
		return listasDeArestas;
	}
	public void setListasDeArestas(ArrayList<ArrayList<String>> listasDeArestas) {
		this.listasDeArestas = listasDeArestas;
	}
	
}
