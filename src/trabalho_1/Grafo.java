package trabalho_1;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Grafo {
	
	private ArrayList<Vertice> listaVertices = new ArrayList<Vertice>();
	private ArrayList<Aresta> arestas = new ArrayList<Aresta>();
	private boolean isValorado;
	private Integer tipoGrafo;

	
	// método para informar vértices
	public void informarVertices(){
		
		String sair = "";
		
		// enquanto o usuário continuar informando vertices
		do{
			
			String nomesVertices = "";
			
			for (Vertice vertice : listaVertices) {
				nomesVertices += " \n " + vertice.getNome();
			}
			
			//exibe lista de vertices cadastrados
			String ver = JOptionPane.showInputDialog("Lista de Vertices:" + nomesVertices + "\n Digite o vertice:");
			
			//cadastra novo vértice
			Vertice v = new Vertice();
			v.setNome(ver);
			
			//joga pra arraylist
			listaVertices.add(v);
			
			//pergunta se o usuário deseja cadastrar mais vértices
			sair = JOptionPane.showInputDialog("Sair?\n" + "Digite SIM = p/sair \n" + "Aperte ENTER para cadastrar mais");
			
		} while(sair.equals(""));
		
	}
	
	
	// ARESTAS
	public void informarArrestas(){
		
		String sair = "";
		
		// pega vertices já cadastrados
		String nomesVertices = "";
		
		for (Vertice vertice : listaVertices) {
			nomesVertices += " \n " + vertice.getNome();
		}
		
		// faz cadastro das arestas agora
		String arestasNomes = "";
		
		do{
			
			// faz cadastro
			String arrasta = JOptionPane.showInputDialog("Lista de vértices:" + nomesVertices 
					+ "\n Lista de arestas: \n" + arestasNomes + " \n Informe as arestas separadas por , \n Ex.: 1,2");
			
			// pega valores individualmente, quebrando por ,
			String[] vertice = arrasta.split(",");
			
			// cria dois vértices, CHEGADA e SAÍDA
			Vertice vertice1 = new Vertice();
			Vertice vertice2 = new Vertice();
			
			// varre lista de vértices e passa valores
			for (Vertice vertce : listaVertices) {
				if(vertce.getNome().equalsIgnoreCase(vertice[0])){
					vertice1 = vertce;
				}
				if(vertce.getNome().equalsIgnoreCase(vertice[1])){
					vertice2 =  vertce;
				}
			}
			
			// define aresta de chegada e saída
			Aresta aresta = new Aresta();
			aresta.setVerticeChegada(vertice2);
			aresta.setVerticeSaida(vertice1);
			
			// joga para o arraylist
			arestas.add(aresta);
			
			arestasNomes = "";
			
			// varre arralist de arestas
			for (Aresta art : arestas) {
				arestasNomes += "("+art.getVerticeSaida().getNome()+","+art.getVerticeChegada().getNome()+")";
			}
			
			// pergunta se usuário deseja cadastrar mais
			sair = JOptionPane.showInputDialog("Lista de Vertices: " + nomesVertices + "\n"+ 
					"Lista De Arrestas: \n" + arestasNomes + " \n "+
					"Digite - SIM para sair"+" \n "+
					"Aperte ENTER para cadastrar mais arestas");
			
		} while(sair.equals(""));
		
	}
	
	
	// lista arestas
	public void listarArestas(){
		
		System.out.println("");
		System.out.println("Lista de Arestas");
		
		String chegada = "";
		String saida = "";
		
		// varre lista de arestas
		for (Aresta aresta : arestas) {
			saida += aresta.getVerticeSaida().getNome()+" ";
			chegada += aresta.getVerticeChegada().getNome()+" ";
		}
		
		// mostra arestas de chegada e saída nos dois conjuntos - V e E
		System.out.println("v  : "+ saida);
		System.out.println("e  :    "+ chegada);
	}
	
	
	
	// lista matriz de adjacência
	public void listaAdjacencia(){
		
		System.out.println("\nLista de adjacência");
		
		// varre arraylist de vértices
		for(Vertice vert : listaVertices) {
			
			System.out.print("|"+ vert.getNome() +"|");
			
			// varre arestas
			for(Aresta arest : arestas) {
				
				// se vertice de saida for igual ao vertice atual da lista mostra o de chegada
				if(arest.getVerticeSaida().getNome().equals(vert.getNome())){
					
					System.out.print(" -> |"+ arest.getVerticeChegada().getNome()+"|");
					
				// se não mostra o vertice de saída apenas - tipo de grafo deve ser (1) = não orientado
				}else if(this.getTipoGrafo() == 1 && arest.getVerticeChegada().getNome().equals(vert.getNome())){
					
					System.out.print(" -> |"+ arest.getVerticeSaida().getNome()+"|");
					
				}
				
			}
			System.out.println("|/|");
		}
	}
	
	// matriz de adjacência é uma matriz |V| x |V|
	// a entrada na linha i e coluna j será 1 se e somente se a aresta (i, j) estiver no grafo. 
	public void matrizAdjacencia(){
		
		System.out.println("\nMatriz de adjacência");
		System.out.print("  ");
		
		// varre vértices
		for(Vertice vert : listaVertices) {
			System.out.print(vert.getNome()+" ");
		}
		
		System.out.print("\n");
		
		
		// cria matriz
		for (int i = 1; i <= listaVertices.size(); i++) {
			
			Vertice vert = listaVertices.get(i-1);
			
			System.out.print(vert.getNome());
			
			
			for (int j = 1; j <= listaVertices.size(); j++) {
				
				Vertice vertice = listaVertices.get(j-1);
				boolean estaNoGrafo = false;
				
				// se o gráfico for do tipo 2 = ORIENTADO
				if(tipoGrafo == 2){
					
					// varre lista arestas em busca de que a aresta (i, j) esteja no grafo
					for (Aresta aresta : arestas) {
						
						if(aresta.getVerticeSaida().getNome().equals(vert.getNome()) &&  
								aresta.getVerticeChegada().getNome().equals(vertice.getNome())){
						
							// se a aresta estiver no grafo, seta o boolean
							estaNoGrafo = true;
						}
						
					}	
					
				// SE NÃO FOR ORIENTADO	
				}else{
					
					// se o grafo não for orientado mas mesmo assim a aresta estiver no grafo
					for (Aresta aresta : arestas) {
						
						if(aresta.getVerticeSaida().getNome().equals(vert.getNome()) &&  
								aresta.getVerticeChegada().getNome().equals(vertice.getNome()) || 
								aresta.getVerticeChegada().getNome().equals(vert.getNome()) &&  
								aresta.getVerticeSaida().getNome().equals(vertice.getNome())){
							
							// se a aresta estiver no grafo, seta o boolean
							estaNoGrafo = true;
						}
						
					}
					
				}
				
				// se está no grafo a saída será 1, SE NÃO será 0
				if(estaNoGrafo){ 
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
		
		// mostra os dois vértices agrupados
		for(Aresta aresta : arestas) {
			System.out.print(aresta.getVerticeSaida().getNome() + "," + aresta.getVerticeChegada().getNome() + "  ");
		}
		
		System.out.print("\n");
		
		// varre os vértices
		for (int i = 1; i <= listaVertices.size(); i++) {
			
			Vertice vert = listaVertices.get(i-1);
			System.out.print(vert.getNome());
			
			for (int j = 1; j <= arestas.size(); j++) {
				
				Aresta aresta = arestas.get(j-1);
				int esta = 0;
				
					// se for um grafo ORIENTADO
					if(tipoGrafo == 2 && aresta.getVerticeSaida().getNome().equals(vert.getNome())){
						
						esta = -1;
					
					// se for um grafo NÃO ORIENTADO
					}else if(tipoGrafo == 1 && (aresta.getVerticeSaida().getNome().equals(vert.getNome()) || aresta.getVerticeChegada().getNome().equals(vert.getNome())) || tipoGrafo == 2 && aresta.getVerticeChegada().getNome().equals(vert.getNome())){
						
						esta = 1;
						
					// em qualquer outro cenário será 0
					}else{
						
						esta = 0;
						
					}
					
				System.out.print(" " + esta + "   ");
			}	
			
			System.out.print("\n");	
		}
	}
	
	public ArrayList<Vertice> getVertices() {
		return listaVertices;
	}

	public void setVertices(ArrayList<Vertice> vertice) {
		this.listaVertices = vertice;
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
		return arestas;
	}

	public void setArrestas(ArrayList<Aresta> arestas) {
		this.arestas = arestas;
	}
}
