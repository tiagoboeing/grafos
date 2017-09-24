package grafos;

import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import grafos.estrutura.Aresta;
import grafos.estrutura.Grafo;
import grafos.estrutura.Representacoes;

public class Processador {

	public static Representacoes processaGrafo(Grafo grafo) {
		Representacoes representacoes = new Representacoes();
		representacoes.setListasDeAdjacencia(geraListasDeAdjacencia(grafo));
		representacoes.setMatrizDeAdjacencia(geraMatrizDeAdjacencia(grafo));
		representacoes.setMatrizDeIncidencia(geraMatrizDeIncidencia(grafo));
		representacoes.setListasDeArestas(geraListasDeArestas(grafo));
		int[][] matrizCentro = geraMatrizDeCentro(grafo);
		representacoes.setCentroGrafo(encontraCentroGrafo(matrizCentro, grafo));
		return representacoes;
	}

	private static ArrayList<String> encontraCentroGrafo(int[][] matrizCentro, Grafo grafo) {
		ArrayList<Integer> excentricidades = new ArrayList<>();
		for (int i = 0; i < matrizCentro.length; i++) {
			int maiorValor = 0;
			for (int j = 0; j < matrizCentro[i].length; j++) {
				if(matrizCentro[i][j] > maiorValor){
					maiorValor = matrizCentro[i][j];
				}
			}
			excentricidades.add(maiorValor);
		}
		return centrosGrafo(grafo,excentricidades);
	}

	private static ArrayList<String> centrosGrafo(Grafo grafo, ArrayList<Integer> excentricidades) {
		int menorValor = encontraMenorValor(excentricidades);
		ArrayList<String> centros = new ArrayList<>();
		for (int i = 0; i < excentricidades.size(); i++) {
			if(excentricidades.get(i) == menorValor){
				centros.add(grafo.getVertices().get(i));
			}
		}
		return centros;
	}

	private static int encontraMenorValor(ArrayList<Integer> excentricidades) {
		int menorValor = 9999;
		for (Integer valor : excentricidades) {
			if(valor < menorValor){
				menorValor = valor;
			}
		}
		return menorValor;
	}

	private static int[][] geraMatrizDeCentro(Grafo grafo) {
		ArrayList<String> vertices = grafo.getVertices();
		int [][] matrizCentro = new int[vertices.size()][vertices.size()];
		for (int i = 0; i < vertices.size(); i++) {
			for (int j = 0; j < vertices.size(); j++) {
				int distancia = 0;
				boolean encontrouCaminho = false;
				ArrayList<Aresta> caminhos = grafo.getListaArestaPorVeticeNaoDirigido(vertices.get(i));
				while (!encontrouCaminho) {
					distancia++;
					encontrouCaminho = verificaCaminhoEncontrado(caminhos, vertices.get(j));
					if(!encontrouCaminho){
						caminhos = encontraCaminhos(caminhos, grafo);
					}
					if(vertices.get(i).equals(vertices.get(j))){
						distancia = 0;
						encontrouCaminho = true;
					}
				}
				matrizCentro[i][j] = distancia;
			}
		}
		return matrizCentro;
	}

	private static boolean verificaCaminhoEncontrado(ArrayList<Aresta> caminhos, String vertice) {
		for (Aresta aresta : caminhos) {
			if(vertice.equals(aresta.getPontoA()) || vertice.equals(aresta.getPontoB())){
				return true;
			}
		}
		return false;
	}

	private static ArrayList<Aresta> encontraCaminhos(ArrayList<Aresta> caminhos, Grafo grafo) {
		ArrayList<Aresta> caminhosRetorno = new ArrayList<>();
		for (Aresta aresta : caminhos) {
				caminhosRetorno.addAll(grafo.getListaArestaPorVeticeNaoDirigido(aresta.getPontoA()));
				caminhosRetorno.addAll(grafo.getListaArestaPorVeticeNaoDirigido(aresta.getPontoB()));
		}
		return caminhosRetorno;
	}

	private static ArrayList<ArrayList<String>> geraListasDeArestas(Grafo grafo) {
		ArrayList<ArrayList<String>> listaDeArestas = new ArrayList<ArrayList<String>>();
		ArrayList<String> listaPontosA = new ArrayList<String>();
		ArrayList<String> listaPontosB = new ArrayList<String>();
		for (Aresta aresta : grafo.getArestas()) {
			listaPontosA.add(aresta.getPontoA());
			listaPontosB.add(aresta.getPontoB());
		}
		listaDeArestas.add(listaPontosA);
		listaDeArestas.add(listaPontosB);
		
		return listaDeArestas;
	}

	private static int[][] geraMatrizDeIncidencia(Grafo grafo) {
		int matriz [][] = new int[grafo.getVertices().size()][grafo.getArestas().size()];
		for (int i = 0; i < matriz.length; i++) {
			String vertice = grafo.getVertices().get(i);
			for (int j = 0; j < matriz[i].length; j++) {
				if (grafo.isDirigido()) {
					matriz[i][j] = isVerticeInicialOuFinal(vertice, grafo.getArestas().get(j));
				}else{
					matriz[i][j] = isVerticeInicial(vertice, grafo.getArestas().get(j));
				}
			}
		}
		
		return matriz;
	}

	private static int isVerticeInicialOuFinal(String vertice, Aresta aresta) {
		if (vertice.equals(aresta.getPontoA())) {
			return 1;
		}else if(vertice.equals(aresta.getPontoB())){
			return -1;
		}
		return 0;
	}

	private static int isVerticeInicial(String vertice, Aresta aresta) {
		if (vertice.equals(aresta.getPontoA())) {
			return 1;
		}
		return 0;
	}

	private static int[][] geraMatrizDeAdjacencia(Grafo grafo) {
		int matriz [][] = new int[grafo.getVertices().size()][grafo.getVertices().size()];
		for (int i = 0; i < matriz.length; i++) {
			String verticeI = grafo.getVertices().get(i);
			for (int j = 0; j < matriz[i].length; j++) {
				String verticeJ = grafo.getVertices().get(j);
				boolean temAresta;
				if (grafo.isDirigido()) {
					temAresta = verificaSeTemArestaDirigido(verticeI, verticeJ, grafo.getArestas());
				}else{
					temAresta = verificaSeTemArestaNaoDirigido(verticeI, verticeJ, grafo.getArestas());
				}
				if (temAresta) {
					matriz[i][j]++;
				}
			}
			
		}
		return matriz;
	}

	private static boolean verificaSeTemArestaDirigido(String verticeI, String verticeJ, ArrayList<Aresta> arestas) {
		for (Aresta aresta : arestas) {
			if ((aresta.getPontoA().equals(verticeI) && aresta.getPontoB().equals(verticeJ))) {
				return true;
			}
		}
		return false;
	}

	private static boolean verificaSeTemArestaNaoDirigido(String verticeI, String verticeJ, ArrayList<Aresta> arestas) {
		for (Aresta aresta : arestas) {
			if ((aresta.getPontoA().equals(verticeI) && aresta.getPontoB().equals(verticeJ)) || (aresta.getPontoA().equals(verticeJ)&& aresta.getPontoB().equals(verticeI))) {
				return true;
			}
		}
		return false;
	}

	private static HashMap<String, ArrayList<String>> geraListasDeAdjacencia(Grafo grafo) {
		HashMap<String, ArrayList<String>> listaDeAdjacencias = new HashMap<String, ArrayList<String>>();
		if (grafo.isDirigido()) {
			for (Aresta aresta : grafo.getArestas()) {
				adicionaNaListaDeAdjacencia(listaDeAdjacencias, aresta.getPontoA(), aresta.getPontoB());
			}
		}else{
			for (Aresta aresta : grafo.getArestas()) {
				adicionaNaListaDeAdjacencia(listaDeAdjacencias, aresta.getPontoA(), aresta.getPontoB());
				adicionaNaListaDeAdjacencia(listaDeAdjacencias, aresta.getPontoB(), aresta.getPontoA());
			}
		}
		
		return listaDeAdjacencias;
	}

	private static void adicionaNaListaDeAdjacencia(
			HashMap<String, ArrayList<String>> listaDeAdjacencias, String saida, String entrada) {
		if (listaDeAdjacencias.containsKey(saida)) {
			listaDeAdjacencias.get(saida).add(entrada);
		}else{
			ArrayList<String> adjacencia = new ArrayList<String>();
			adjacencia.add(entrada);
			listaDeAdjacencias.put(saida, adjacencia);
		}
	}

}
