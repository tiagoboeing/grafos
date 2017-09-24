package Larroyd;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class Grafo {
	
	private ArrayList<Vertice> vertices = new ArrayList<Vertice>();
	private ArrayList<Aresta> arrestas = new ArrayList<Aresta>();
	private boolean isValorado;
	private Integer tipoGrafo;
	
	public int[][] matrizDistancia;

	public void informarVertices(){
		String sair = "nao";
		while(sair.equals("nao")) {
			String nomesVertices = "";
			
			for (Vertice vertice : vertices) {
				nomesVertices += " \n "+vertice.getNome();
			}
			
			String ver = JOptionPane.showInputDialog("Lista de Vertices: \n"+nomesVertices+
					"\n Digite o vertice");
			Vertice vertice = new Vertice();
			vertice.setNome(ver);
			
			vertices.add(vertice);
			sair = JOptionPane.showInputDialog("Deseja sair ? \n Digite - sim para sair"
					+ " \n Digite - nao para informar mais vertices");
		}
	}
	
	public void informarArrestas(){
		String sair = "nao";
		
		String nomesVertices = "";
		for (Vertice vertice : vertices) {
			nomesVertices += " \n "+vertice.getNome();
		}
		
		String arrestasNomes = "";
		while(sair.equals("nao")) {
				
			String arrasta = JOptionPane.showInputDialog("Lista de Vertices: \n"+nomesVertices+
					"\n Lista de Arrestas: \n"+arrestasNomes+
					" \n Digite a arresta separada por , \n ex.: 1,2");
			
			
			String[] vertice = arrasta.split(",");
			
			Vertice vertice1 = new Vertice();
			Vertice vertice2 = new Vertice();
			
			for (Vertice vertce : vertices) {
				if(vertce.getNome().equalsIgnoreCase(vertice[0])){
					vertice1 = vertce;
				}
				if(vertce.getNome().equalsIgnoreCase(vertice[1])){
					vertice2 =  vertce;
				}
			}
			
			Aresta arresta = new Aresta();
			arresta.setVerticeChegada(vertice2);
			arresta.setVerticeSaida(vertice1);
			
			if(this.isValorado){
				int valor = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor desta arresta: "));
				arresta.setValor(valor);
			}
			
			arrestas.add(arresta);
			
			arrestasNomes = "";
			for (Aresta art : arrestas) {
				arrestasNomes += "("+art.getVerticeSaida().getNome()+","+art.getVerticeChegada().getNome()+")";
			}
			sair = JOptionPane.showInputDialog(
					"Lista de Vertices: \n"+nomesVertices+" \n "+ 
					"Lista De Arrestas: \n"+arrestasNomes+" \n "+
					"Deseja sair ? \n Digite - sim para sair"+" \n "+
					"Digite - nao para informar mais vertices");
		}
	}
	
	public void listarArestas(){
		
		System.out.println("");
		System.out.println("Lista de Arestas");
		
		String chegada = "";
		String saida = "";
		
		for (Aresta arresta : arrestas) {
			saida += arresta.getVerticeSaida().getNome()+" ";
			chegada += arresta.getVerticeChegada().getNome()+" ";
		}
		
		System.out.println("g  : "+ saida);
		System.out.println("h  :    "+ chegada);
	}
	
	public void listaAdjacencia(){
		System.out.println("Lista de adjacência");
		for(Vertice vert : vertices) {
			System.out.print("|"+ vert.getNome() +"|");
			for(Aresta arest : arrestas) {
				if(arest.getVerticeSaida().getNome().equals(vert.getNome())){
					System.out.print(" -> |"+ arest.getVerticeChegada().getNome()+"|");
				}else if(this.getTipoGrafo() == 1 && 
						arest.getVerticeChegada().getNome().equals(vert.getNome())){
					System.out.print(" -> |"+ arest.getVerticeSaida().getNome()+"|");
				}
			}
			System.out.println("|/|");
		}
	}
	
	public void matrizAdjacencia(){
		System.out.println("Matriz de adjacência");
		System.out.print("  ");
		for(Vertice vert : vertices) {
			System.out.print(vert.getNome()+" ");
		}
		System.out.print("\n");
		for (int i = 1; i <= vertices.size(); i++) {
			Vertice vert = vertices.get(i-1);
			System.out.print(vert.getNome());
			for (int j = 1; j <= vertices.size(); j++) {
				Vertice vertice = vertices.get(j-1);
				boolean exist = false;
				if(tipoGrafo == 2){
					for (Aresta arresta : arrestas) {
						if(arresta.getVerticeSaida().getNome().equals(vert.getNome()) &&  
								arresta.getVerticeChegada().getNome().equals(vertice.getNome())){
							exist = true;
						}
					}	
				}else{
					for (Aresta arresta : arrestas) {
						if(arresta.getVerticeSaida().getNome().equals(vert.getNome()) &&  
								arresta.getVerticeChegada().getNome().equals(vertice.getNome()) || 
								arresta.getVerticeChegada().getNome().equals(vert.getNome()) &&  
								arresta.getVerticeSaida().getNome().equals(vertice.getNome())){
							exist = true;
						}
					}
				}
				if(exist){ 
					System.out.print(" 1");
				}else{
					System.out.print(" 0");
				}
			}	
			System.out.print("\n");	
		}
	}
	
	public void matrizIncidencia(){
		System.out.println("");
		System.out.println("Matriz de Incidencia");
		System.out.print("  ");
		for(Aresta arresta : arrestas) {
			System.out.print(arresta.getVerticeSaida().getNome()+","+arresta.getVerticeChegada().getNome()+"  ");
		}
		
		System.out.print("\n");
		
		for (int i = 1; i <= vertices.size(); i++) {
			
			Vertice vert = vertices.get(i-1);
			System.out.print(vert.getNome());
			for (int j = 1; j <= arrestas.size(); j++) {
				Aresta arresta = arrestas.get(j-1);
				int exist = 0;
				
					if(tipoGrafo == 2 && arresta.getVerticeSaida().getNome().equals(vert.getNome())){
						exist = -1;
					}else if(tipoGrafo == 1 && 
							(arresta.getVerticeSaida().getNome().equals(vert.getNome()) 
									|| arresta.getVerticeChegada().getNome().equals(vert.getNome())) || 
									tipoGrafo == 2 && arresta.getVerticeChegada().getNome().equals(vert.getNome())){
						exist = 1;
					}else{
						exist = 0;
					}
				System.out.print(" "+exist+"   ");
			}	
			
			System.out.print("\n");
			
		}
		
	}
	
	public void matrisDistancia(){
		System.out.println("--| Matriz Distancia |--");
		
		List<Vertice>verticesList = new ArrayList<Vertice>();
		matrizDistancia = new int[vertices.size()][vertices.size()];
		List<Aresta>arrestasList = new ArrayList<Aresta>();
		
		for (Vertice vertices2 : vertices) {
			Vertice vert = vertices2;
			vert.setAnterior(null);
			verticesList.add(vert);
		}
		
		for (Aresta arresta : arrestas) {
			
			Aresta arestaNova = new Aresta(); 
			arresta.setValor(1);
			
			for (Vertice vert : verticesList) {
				if(vert.getNome().equals(arresta.getVerticeSaida().getNome())){
					arestaNova.setVerticeSaida(vert);
				}else if(vert.getNome().equals(arresta.getVerticeChegada().getNome())){
					arestaNova.setVerticeChegada(vert);
				}
			}
			
			arestaNova.setValor(1);
			arrestasList.add(arestaNova);
		}
		
		if(tipoGrafo == 1){
			arrestasList = new ArrayList<Aresta>();
			for (Aresta arresta : arrestasList) {
				Aresta arrestaNova = new Aresta();
				
				for (Vertice vert : verticesList) {
					if(vert.getNome().equals(arresta.getVerticeSaida())){
						arrestaNova.setVerticeSaida(vert);
					}else if(vert.getNome().equals(arresta.getVerticeChegada())){
						arrestaNova.setVerticeChegada(vert);
					}
				}
				
				arrestaNova.setValor(1);
				arrestasList.add(arrestaNova);
			}
		}
		
		int cont = 0;
		for (Vertice vertice : verticesList) {
			
			for (Vertice vert : verticesList) {
				if(vert.getNome().equals(vertice.getNome())){
					vert.setValor(0);
				}else{
					vert.setValor(99999);
				}
				vert.setAnterior(null);
			}
			
			for (int i = 0; i < verticesList.size(); i++) {
				for (Aresta arresta : arrestasList) {
					
					int val = arresta.getVerticeSaida().getValor() + arresta.getValor();
					
					if(arresta.getVerticeChegada().getValor() > val){				
						arresta.getVerticeChegada().setValor(val);
						arresta.getVerticeChegada().setAnterior(arresta.getVerticeSaida());
					}
				}
			}
			
			for (int i = 0; i < verticesList.size(); i++) {
				Vertice vert  = verticesList.get(i);
				matrizDistancia[cont][i] = vert.getValor();
				
			}
			cont = cont + 1;
		}
		
		for (int i = 0; i < matrizDistancia.length; i++) {
			Vertice vert = verticesList.get(i);
			for (int j = 0; j < matrizDistancia.length; j++) {
				
				if(matrizDistancia[i][j] > vert.getChegada()){
					vert.setChegada(matrizDistancia[i][j]);
				}
				
				if(matrizDistancia[i][j] > vert.getSaida()){
					vert.setSaida(matrizDistancia[i][j]);
				}
				
				System.out.println(" -> "+vert.getChegada());
			}
		}
		
		listarExentricidades();
		
		int raio = 99999;
		for(Vertice vertice : vertices) {
			if(vertice.getChegada() < raio){
				raio = vertice.getChegada();
			}
		}
		
		System.out.println("Raio: "+ raio);
		
		System.out.println("CENTROS");
		List<Vertice> centros = new ArrayList<Vertice>();
		for(Vertice vertice: vertices) {
			if(vertice.getChegada() == raio)
				centros.add(vertice);
		}
		
		for(Vertice verticeCentro : centros) {
			System.out.println(verticeCentro.getNome());
		}
		
	}
	
	private void listarExentricidades() {
		
		int[][] matriz;
		if(tipoGrafo == 2) {
			
			int[][] matrizTransposta = new int[matrizDistancia[0].length][matrizDistancia.length];
	        for (int i = 0; i < matrizTransposta.length; i++){
	            for (int j = 0; j < matrizTransposta[0].length; j++){
	            	matrizTransposta[j][i] = matrizTransposta[i][j];
				}
			}
	
			
			matriz = new int[matrizDistancia[0].length][matrizTransposta[0].length];
			for (int i = 0; i < matrizDistancia[0].length; i++) {
				for (int j = 0; j < matrizDistancia[0].length; j++) {
					matriz[i][j] = matrizDistancia[i][j] + matrizTransposta[i][j];
				}			
			}
		} else {
			matriz = matrizDistancia;
		}
		
		for (int i = 0; i < matriz.length; i++) {
			Vertice vertice = vertices.get(i);
			for (int j = 0; j < matriz.length; j++) {
				if(matriz[i][j] > vertice.getChegada())
					vertice.setChegada(matriz[i][j]);
				if(matriz[j][i] > vertice.getSaida())
					vertice.setSaida(matriz[j][i]);
			}
		}
	}
	
	public ArrayList<Vertice> getVertices() {
		return vertices;
	}

	public void setVertices(ArrayList<Vertice> vertices) {
		this.vertices = vertices;
	}

	public boolean isValorado() {
		return isValorado;
	}

	public void setValorado(boolean isValorado) {
		this.isValorado = isValorado;
	}

	public Integer getTipoGrafo() {
		return tipoGrafo;
	}

	public void setTipoGrafo(Integer tipoGrafo) {
		this.tipoGrafo = tipoGrafo;
	}
	
	public ArrayList<Aresta> getArrestas() {
		return arrestas;
	}

	public void setArrestas(ArrayList<Aresta> arrestas) {
		this.arrestas = arrestas;
	}
}
