package Cocao;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal {
	
	private static int NAOORIENTADO = 0;
	private static int ORIENTADO = 1;
	private static int INFINITO = 999999999; 
	private int tipoGrafo;
	
	int[][] matrizDistancia;
	
	private List<String> vertices = new ArrayList<>();
	
	private List<Vertice> verticesList = new ArrayList<>();
	private List<Aresta> arestasList = new ArrayList<>();
	
	private List<String> arestas = new ArrayList<>();

	public static void main(String[] args) {

		Principal p = new Principal();
		
		try {
		
			p.solicitaTipoGrafo();
			p.solicitaVertices();
			p.solicitaArestas();
			
			boolean orientado = p.tipoGrafo == ORIENTADO?true:false;
			
			System.out.println("\n## Lista de Adjacência ##");
			p.criaListaAdjacencia(orientado);

			System.out.println("\n## Matriz de Adjacência ##");
			p.criaMatrizAdjacencia(orientado);
			
			System.out.println("\n## Matriz de Incidência ##");
			p.criaMatrizIncidencia(orientado);
			
			System.out.println("\n## Lista de Arestas ##");
			p.criaListaAresta();
			
	/*		p.vertices.add("a"); // 0
			p.vertices.add("b"); // 1
			p.vertices.add("c"); // 2
			p.vertices.add("d"); // 3
			p.vertices.add("e"); // 4
			p.vertices.add("f"); // 5
			p.vertices.add("g"); // 6
			
			p.arestas.add("a,b");
			p.arestas.add("a,d");
			p.arestas.add("b,c");
			p.arestas.add("c,d");
			p.arestas.add("c,e");
			p.arestas.add("e,f");
			p.arestas.add("e,d");
			p.arestas.add("d,g");*/
			
//			p.vertices.add("x1"); // 0
//			p.vertices.add("x2"); // 1
//			p.vertices.add("x3"); // 2
//			p.vertices.add("x4"); // 3
//			p.vertices.add("x5"); // 4
//			p.vertices.add("x6"); // 5
//			
//			p.arestas.add("x1,x2");
//			p.arestas.add("x2,x3");
//			p.arestas.add("x3,x4");
//			p.arestas.add("x4,x5");
//			p.arestas.add("x5,x6");
//			p.arestas.add("x6,x1");
//			p.arestas.add("x5,x2");
//			p.arestas.add("x2,x5");
			
			
			p.criaMatrizDistancia();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void solicitaTipoGrafo() throws Exception {
		
		String tipo = "";
		
		while(!tipo.equals("0") && !tipo.equals("1")) {			
			tipo = JOptionPane.showInputDialog("Informe o tipo do grafo.\n\n0 - Não orientado\n1 - Orientado");
		}
		this.tipoGrafo = Integer.parseInt(tipo);
	}
	
	public void solicitaVertices() throws Exception {
		
		String entrada = "";
		int i = 1;

		do {
			entrada = JOptionPane.showInputDialog("Informe o "+ i +"º vértice. Para finalizar, digite FIM");
			
			if(!entrada.toUpperCase().equals("FIM"))
				vertices.add(entrada);
			
			i++;
		}while(!entrada.toUpperCase().equals("FIM")); 
		
	}
	
	public void solicitaArestas() throws Exception {
		
		String entrada = "";
		int i = 1;
		
		do {
			
			entrada = JOptionPane.showInputDialog("Informe a "+ i +"ª aresta. Separar os vértices por vírgula (,). Para finalizar, digite FIM");
			
			if(!entrada.toUpperCase().equals("FIM")) {
				
				String[] entradas = entrada.split(",");
				
				int index0 = vertices.indexOf(entradas[0]);
				int index1 = vertices.indexOf(entradas[1]);
				
				if(index0 > -1 && index1 > -1) {
					arestas.add(entrada);
				}
			}
			
			i++;
		}while(!entrada.toUpperCase().equals("FIM"));
		
	}
	
	public void criaListaAdjacencia(boolean orientado) throws Exception {
		
		System.out.println();
		for(String v : vertices) {
			
			System.out.print("("+ v +")");
			for(String a : arestas) {
				
				String[] arestas = a.split(",");
				
				if(arestas[0].contains(v)) {
					System.out.print(" -> "+ arestas[1]);
				} else if(!orientado && arestas[1].contains(v)) {
					System.out.print(" -> "+ arestas[0]);
				} 
				
			}
			
			System.out.print(" ");
			System.out.println("\n");
			
		}
		
	}
	
	public void criaMatrizAdjacencia(boolean orientado) throws Exception {
		
		System.out.print("    ");
		for(String v : vertices) {
			System.out.print(String.format("%1$-" + 4 + "s", v));
		}
		
		System.out.print("\n");
		
		for (int i = 1; i <= vertices.size(); i++) {
			
			String vI = vertices.get(i-1);
			System.out.print(String.format("%1$-" + 4 + "s", vI));
			
			for (int j = 1; j <= vertices.size(); j++) {
				
				String vJ = vertices.get(j-1);
					
				if(existeAresta(vI, vJ, orientado)) 
					System.out.print(String.format("%1$-" + 4 + "s", "1"));
				else
					System.out.print(String.format("%1$-" + 4 + "s", "0"));
				
			}	
			
			System.out.print("\n");
			
		}
		
	}
	
	public void criaMatrizIncidencia(boolean orientado) throws Exception {
		
		System.out.print("    ");
		for(String a : arestas) {
			System.out.print(String.format("%1$-" + 4 + "s", a));
		}
		
		System.out.print("\n");
		
		for (int i = 1; i <= vertices.size(); i++) {
			
			String vertice = vertices.get(i-1);
			System.out.print(String.format("%1$-" + 4 + "s", vertice));
			
			for (int j = 1; j <= arestas.size(); j++) {
				
				String a = arestas.get(j-1);
				
				String[] arestaArr = a.split(",");
				
				if(orientado && arestaArr[0].equals(vertice)) 
					System.out.print(String.format("%1$-" + 4 + "s", "-1"));
				else if((!orientado && (arestaArr[0].equals(vertice) || arestaArr[1].equals(vertice))) 
						|| (orientado && arestaArr[1].equals(vertice)))
					System.out.print(String.format("%1$-" + 4 + "s", "1"));
				else
					System.out.print(String.format("%1$-" + 4 + "s", "0"));
				
			}	
			
			System.out.print("\n");
			
		}
		
	}
	
	public void criaMatrizDistancia() {
		
		System.out.println("#### Matriz Distância ####");
		
		
		for(String v:vertices) {
			Vertice vertice = new Vertice();
			vertice.nome = v;
			vertice.anterior = null;
			verticesList.add(vertice);
		}
		
		matrizDistancia = new int[verticesList.size()][verticesList.size()];
		
		for(String a : arestas) {
			
			String[] arestaArr = a.split(",");
			Aresta aresta = new Aresta();
			
			for(Vertice v : verticesList) {
				if(v.nome.equals(arestaArr[0])) 
					aresta.origem = v;
				else if(v.nome.equals(arestaArr[1]))
					aresta.destino = v;
			}
			aresta.peso = 1;
			arestasList.add(aresta);
			
		}
		
		if(tipoGrafo==NAOORIENTADO) {
			
			for(String a : arestas) {
				
				String[] arestaArr = a.split(",");
				Aresta aresta = new Aresta();
				
				for(Vertice v : verticesList) {
					if(v.nome.equals(arestaArr[0])) 
						aresta.destino = v;
					else if(v.nome.equals(arestaArr[1]))
						aresta.origem = v;
				}
				aresta.peso = 1;
				arestasList.add(aresta);
				
			}
			
		}
		
		int k = 0;
		for(Vertice vertice : verticesList) {
			
			vertice.excentricidadeSaida = 0;
			vertice.excentricidadeRetorno = 0;
			
			for(Vertice v : verticesList) {
				
				v.anterior = null;
				
				if(v.nome.equals(vertice.nome))
					v.distancia = 0;
				else
					v.distancia = INFINITO;
			}
			
			for (int i = 0; i < vertices.size(); i++) {
				for(Aresta aresta : arestasList) {
					Vertice o = aresta.origem;
					Vertice d = aresta.destino;
					if(d.distancia > o.distancia + aresta.peso) {
						d.distancia = o.distancia + aresta.peso;
						d.anterior = o;
					}
				}
			}
			for (int i = 0; i < verticesList.size(); i++) {
				Vertice v = verticesList.get(i);
				matrizDistancia[k][i] = v.distancia;
			}
			k++;
			
		}
		
		for (int i = 0; i < matrizDistancia.length; i++) {
			Vertice v = verticesList.get(i);
			for (int j = 0; j < matrizDistancia.length; j++) {
				System.out.print(matrizDistancia[i][j]);
				if(matrizDistancia[i][j] > v.excentricidadeRetorno)
					v.excentricidadeRetorno = matrizDistancia[i][j];
				if(matrizDistancia[j][i] > v.excentricidadeSaida)
					v.excentricidadeSaida = matrizDistancia[j][i];
			}
			System.out.print(" -> "+ v.excentricidadeRetorno);
			System.out.println();
			
		}
		
		geraExcentricidades();
		int raio = calculaRaio();
		System.out.println("Raio => "+ raio);
		
		System.out.println("\n## CENTROS ##");
		List<Vertice> centros = calculaCentros(raio);
		for(Vertice c : centros) {
			System.out.println(c.nome);
		}
		
	}
	
	private void geraExcentricidades() {
		
		int[][] matriz;
		
		if(tipoGrafo==ORIENTADO) {
			matriz = somaMatriz(matrizDistancia, matrizTransposta(matrizDistancia));
		} else {
			matriz = matrizDistancia;
		}
		
		for (int i = 0; i < matriz.length; i++) {
			Vertice v = verticesList.get(i);
			for (int j = 0; j < matriz.length; j++) {
				if(matriz[i][j] > v.excentricidadeRetorno)
					v.excentricidadeRetorno = matriz[i][j];
				if(matriz[j][i] > v.excentricidadeSaida)
					v.excentricidadeSaida = matriz[j][i];
			}
		}
	}
	
	private int calculaRaio() {
		
		int raio = INFINITO;
		for(Vertice v : verticesList) {
			if(v.excentricidadeRetorno < raio)
				raio = v.excentricidadeRetorno;
		}
		return raio;
		
	}
	
	private List<Vertice> calculaCentros(int raio) {
		
		List<Vertice> centros = new ArrayList<>();
		for(Vertice v : verticesList) {
			if(v.excentricidadeRetorno == raio)
				centros.add(v);
		}
		return centros;
		
	}
	
	public int[][] somaMatriz(int[][] m1, int[][] m2) {
		
		int[][] resultado = new int[m1[0].length][m1[0].length];
		for (int i = 0; i < m1[0].length; i++) {
			for (int j = 0; j < m1[0].length; j++) {
				resultado[i][j] = m1[i][j] + m2[i][j];
			}			
		}
		
		return resultado;
		
	}
	
	public int[][] matrizTransposta(int [][] m){
		int[][] temp = new int[m[0].length][m.length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                temp[j][i] = m[i][j];
        return temp;
    }
	
	public void criaListaAresta() throws Exception {
		
		String inicio = "";
		String fim = "";
		
		for(String aresta : arestas) {
			
			String[] arestas = aresta.split(",");
			
			inicio += String.format("%1$-" + 4 + "s", arestas[0]);
			fim += String.format("%1$-" + 4 + "s", arestas[1]);
			
		}
		 
		System.out.println("v  :    "+ inicio);
		System.out.println("e  :    "+ fim);
		
	}
	
	public boolean existeAresta(String i, String j, boolean orientado) {
		
		for(String aresta : arestas) {
			
			String[] arestas = aresta.split(",");
			
			if(orientado
					&& (arestas[0].contains(i) && arestas[1].contains(j))) {
				return true;
			} else if(!orientado 
					&& (arestas[0].contains(i) && arestas[1].contains(j) || arestas[1].contains(i) && arestas[0].contains(j))){
				return true;
			} 
			
		}
		
		return false;
		
	}
	
}
