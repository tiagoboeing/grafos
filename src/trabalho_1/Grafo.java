package trabalho_1;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Grafo {
	
	private ArrayList<Vertice> listaVertices = new ArrayList<Vertice>();
	private ArrayList<Aresta> arestas = new ArrayList<Aresta>();
	private Integer tipoGrafo;
	private Boolean isValorado;

	
	
	// pergunta se grafo � valorado ou n�o
	public Boolean grafoValorado(String valor){
		
		Boolean grafoValorado;

			switch (valor) {
			
			case "SIM":
				grafoValorado = true;
				break;
				
			case "N�O":
				grafoValorado = false;
				break;
				
			case "1":
				grafoValorado = true;
				break;
				
			case "0":
				grafoValorado = false;
				break;
				
			default:
				grafoValorado = false;
				
			}
			
			return grafoValorado;
	}
	
	
	// m�todo para informar v�rtices
	public void informarVertices(){
		
		String sair = "";
		
		// enquanto o usu�rio continuar informando vertices
		do{
			
			String nomesVertices = "";
			
			for (Vertice vertice : listaVertices) {
				nomesVertices += " \n " + vertice.getNome().toUpperCase();
			}
			
			//exibe lista de vertices cadastrados
			String ver = JOptionPane.showInputDialog("Lista de Vertices:" + nomesVertices + "\n Digite o vertice:");
			
			//cadastra novo v�rtice
			Vertice v = new Vertice();
			v.setNome(ver);
			
			//joga pra arraylist
			listaVertices.add(v);
			
			//pergunta se o usu�rio deseja cadastrar mais v�rtices
			sair = JOptionPane.showInputDialog("Sair?\n" + "Digite SIM = p/sair \n" + "Aperte ENTER para cadastrar mais");
			
		} while(sair.equals(""));
		
	}
	
	
	// ARESTAS
	public void informarArestas(Boolean isValorado){
		
		String sair = "";
		
		// pega vertices j� cadastrados
		String nomesVertices = "";
		
		for (Vertice vertice : listaVertices) {
			nomesVertices += " \n " + vertice.getNome();
		}
		
		// faz cadastro das arestas agora
		String arestasNomes = "";
		
		do{
			
			// faz cadastro
			String aresta1 = JOptionPane.showInputDialog("Lista de v�rtices:" + nomesVertices.toUpperCase() 
					+ "\n Lista de arestas: \n" + arestasNomes.toUpperCase() + " \n Informe as arestas separadas por , \n Ex.: 1,2");
			
			// pega valores individualmente, quebrando por ,
			String[] vertice = aresta1.split(",");
			
			// cria dois v�rtices, CHEGADA e SA�DA
			Vertice vertice1 = new Vertice();
			Vertice vertice2 = new Vertice();
			
			// varre lista de v�rtices e passa valores
			for (Vertice vertce : listaVertices) {
				if(vertce.getNome().equalsIgnoreCase(vertice[0])){
					vertice1 = vertce;
				}
				if(vertce.getNome().equalsIgnoreCase(vertice[1])){
					vertice2 =  vertce;
				}
			}
			
			// define aresta de chegada e sa�da
			Aresta aresta = new Aresta();
			aresta.setVerticeChegada(vertice2);
			aresta.setVerticeSaida(vertice1);
			
			// se o grafo for valorado pede o valor da aresta
			if(getIsValorado() == true){
				
				String valorAresta = JOptionPane.showInputDialog("Qual o valor da aresta " + aresta1 + "?");
				
				if(valorAresta.equals("")){
					valorAresta = "0";
				} 
				
				aresta.setValor(Double.parseDouble(valorAresta));
				
			}
			
			
			// joga para o arraylist
			arestas.add(aresta);
			
			arestasNomes = "";
			
			// varre arralist de arestas
			for (Aresta art : arestas) {
				
				if(getIsValorado() == false){
					arestasNomes += "("+art.getVerticeSaida().getNome()+","+art.getVerticeChegada().getNome()+")";
				} else {
					arestasNomes += "("+art.getVerticeSaida().getNome()+","+art.getVerticeChegada().getNome()+")" + " - Valor: " + art.getValor() +"\n";
				}
				
			}
			
			// pergunta se usu�rio deseja cadastrar mais
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
		String valorLista = "";
		
		// varre lista de arestas
		for (Aresta aresta : arestas) {
			saida += aresta.getVerticeSaida().getNome()+"   |   ";
			chegada += aresta.getVerticeChegada().getNome()+"   |   ";
			
			
//			checa se existem valores
			if(getIsValorado() == true){
				valorLista += aresta.getValor() + "  | ";
			} else {
				valorLista = "--- Grafo n�o valorado ---";
			}
			
		}
		
		// mostra arestas de chegada e sa�da nos dois conjuntos - V e E
		System.out.println("v  : "+ saida);
		System.out.println("e  : "+ chegada);
		System.out.println("   "+ valorLista);
		
		
	}
	
	
	
	// lista matriz de adjac�ncia
	public void listaAdjacencia(){
		
		System.out.println("\nLista de adjac�ncia");
		
		// varre arraylist de v�rtices
		for(Vertice vert : listaVertices) {
			
			System.out.print("|"+ vert.getNome() +"|");
			
			// varre arestas
			for(Aresta arest : arestas) {
				
				// se vertice de saida for igual ao vertice atual da lista mostra o de chegada
				if(arest.getVerticeSaida().getNome().equals(vert.getNome())){
					
					System.out.print(" -> |"+ arest.getVerticeChegada().getNome()+"|");
					
				// se n�o mostra o vertice de sa�da apenas - tipo de grafo deve ser (1) = n�o orientado
				}else if(this.getTipoGrafo() == 1 && arest.getVerticeChegada().getNome().equals(vert.getNome())){
					
					System.out.print(" -> |"+ arest.getVerticeSaida().getNome()+"|");
					
				}
				
			}
			System.out.println("|/|");
		}
	}
	
	// matriz de adjac�ncia � uma matriz |V| x |V|
	// a entrada na linha i e coluna j ser� 1 se e somente se a aresta (i, j) estiver no grafo. 
	public void matrizAdjacencia(){
		
		System.out.println("\nMatriz de adjac�ncia");
		System.out.print("  ");
		
		// varre v�rtices
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
				
				// se o gr�fico for do tipo 2 = ORIENTADO
				if(tipoGrafo == 2){
					
					// varre lista arestas em busca de que a aresta (i, j) esteja no grafo
					for (Aresta aresta : arestas) {
						
						if(aresta.getVerticeSaida().getNome().equals(vert.getNome()) &&  
								aresta.getVerticeChegada().getNome().equals(vertice.getNome())){
						
							// se a aresta estiver no grafo, seta o boolean
							estaNoGrafo = true;
						}
						
					}	
					
				// SE N�O FOR ORIENTADO	
				}else{
					
					// se o grafo n�o for orientado mas mesmo assim a aresta estiver no grafo
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
				
				// se est� no grafo a sa�da ser� 1, SE N�O ser� 0
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
		
		// mostra os dois v�rtices agrupados
		for(Aresta aresta : arestas) {
			System.out.print(aresta.getVerticeSaida().getNome() + "," + aresta.getVerticeChegada().getNome() + "  ");
		}
		
		System.out.print("\n");
		
		// varre os v�rtices
		for (int i = 1; i <= listaVertices.size(); i++) {
			
			Vertice vert = listaVertices.get(i-1);
			System.out.print(vert.getNome());
			
			for (int j = 1; j <= arestas.size(); j++) {
				
				Aresta aresta = arestas.get(j-1);
				int esta = 0;
				
					// se for um grafo ORIENTADO
					if(tipoGrafo == 2 && aresta.getVerticeSaida().getNome().equals(vert.getNome())){
						
						esta = -1;
					
					// se for um grafo N�O ORIENTADO
					}else if(tipoGrafo == 1 && (aresta.getVerticeSaida().getNome().equals(vert.getNome()) || aresta.getVerticeChegada().getNome().equals(vert.getNome())) || tipoGrafo == 2 && aresta.getVerticeChegada().getNome().equals(vert.getNome())){
						
						esta = 1;
						
					// em qualquer outro cen�rio ser� 0
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


	public Boolean getIsValorado() {
		return isValorado;
	}


	public void setIsValorado(Boolean isValorado) {
		this.isValorado = isValorado;
	}
}
