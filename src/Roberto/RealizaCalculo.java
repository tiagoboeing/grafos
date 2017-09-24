/*
 *      DATA: 21/08/2015
 *   AUTORES: ROBERTO BENTO, CAMILA MARTINS
 * DESCRICAO: CLASSE QUE REALIZA A CONSULTA DE RECONHECIMENTO DOS GRAFOS UTILIZANDO AS SEGUINTE FORMAS:
 * 		- LISTA DE ADJACÊNCIA
 * 		- MATRIZ DE ADJACÊNCIA
 * 		- MATRIZ DE INCIDÊNCIA
 * 		- LISTA DE ARESTAS
*/

package Roberto;

import java.util.ArrayList;

public class RealizaCalculo {

	
	Integer verticeMaiorTotal=99;
	
	// RECEBE OS VALORES ADVINDOS DA TELA PRINCIPAL
	public RealizaCalculo(String Svertices,
			String Sarestas) {
	
		
		// INICIALIZA AS VARIÁVEIS NECESSÁRIAS PARA A CONSULTA
		ArrayList<String> vertices = new ArrayList<String>();
		ArrayList<String> arestas = new ArrayList<String>();
		ArrayList<ArrayList<String>> listaAdjacencia = new ArrayList<ArrayList<String>>();		
		Sarestas = ","+Sarestas;
		
		// AJUSTA AS VERTICES PARA ADICIONAR NA LISTA
		String[] aux= Svertices.split(",");
		System.out.println("Vértices:");
		for (int i = 0; i < aux.length; i++) {
			vertices.add(aux[i]);
			System.out.println(aux[i]);
		}
		// AJUSTA AS ARESTAS PARA ADICIONAR NA LISTA
		aux = Sarestas.split("\\)");
		System.out.println("Arestas");
		for (int i = 0; i < aux.length; i++) {
			arestas.add(aux[i].substring(2,3)+""+aux[i].substring(4,5));
			System.out.println(aux[i].substring(2,3)+""+aux[i].substring(4,5));		
		}
		
		//RETORNA PARA A VARIÁVEL A LISTA DE ADJACÊNCIA
		listaAdjacencia = calculaListaAresta(vertices, arestas);
		
		//ATRIBUI AO CAMPO O RESULTADO DA CONSULTA
		Tela2.lbResultado1.setText(MostraResultado(CalculaCentroGrafo(MontaMatrizDistancia(vertices, listaAdjacencia), vertices), vertices));
		
	}

	// FUNCAO QUE CALCULA A LISTA DE ARESTAS E JÁ RETORNA O TEXTO IDENTADO		
	public ArrayList<ArrayList<String>> calculaListaAresta(ArrayList<String> vertices,ArrayList<String> arestas){			
			ArrayList<ArrayList<String>> lista = new ArrayList<ArrayList<String>>();
			for (int i = 0; i < vertices.size(); i++) {
				lista.add(new ArrayList<String>());
				for (int j = 0; j < arestas.size(); j++) {					
						if(vertices.get(i).equalsIgnoreCase(arestas.get(j).substring(0,1))){							
							lista.get(i).add(arestas.get(j).substring(1,2));
						}
						if(vertices.get(i).equalsIgnoreCase(arestas.get(j).substring(0,1))){
							lista.get(i).add(arestas.get(j).substring(1,2));
						}else if(vertices.get(i).equalsIgnoreCase(arestas.get(j).substring(1,2))){
								lista.get(i).add(arestas.get(j).substring(0,1));					
						}
					}
				
			}								
			return lista;
		}
	//RECEBE A MATRIZ DE DISTÂNCIA E CALCULA O CENTRO O GRAFO
	public ArrayList<Integer> CalculaCentroGrafo(Integer[][] matrizDistancia, ArrayList<String> vertices){
		Integer verticeMaiorLinha=0;
		ArrayList<Integer> verticesCentrais = new ArrayList<Integer>();
		
		for (int i = 0; i < matrizDistancia.length; i++) {
			verticeMaiorLinha=0;
			for (int j = 0; j < matrizDistancia.length; j++) {
				if(matrizDistancia[i][j] > verticeMaiorLinha){
					verticeMaiorLinha = matrizDistancia[i][j];
				}
			}			
			if(verticeMaiorLinha < verticeMaiorTotal){
				System.out.println("To limpando o array e add "+i);
				verticesCentrais.clear();
				verticesCentrais.add(i);
				verticeMaiorTotal=verticeMaiorLinha;
			}else if (verticeMaiorLinha == verticeMaiorTotal){
				System.out.println("To adicionando "+i);
				verticesCentrais.add(i);
			}			
		}
		return verticesCentrais;
	}
	
	//AJUSTA O RESULTADO DO CENTRO DO GRAFO PARA MOSTRAR NA TELA
	public String MostraResultado(ArrayList<Integer> verticesCentrais,ArrayList<String> vertices){
		String resultadoFinal=" NÚMERO DE VÉRTICES CENTRAIS: "+verticesCentrais.size()+"\n\n";
		resultadoFinal+="VALOR DO CENTRO DO GRAFO: "+verticeMaiorTotal+"\n\n";
		for (int i = 0; i < verticesCentrais.size(); i++) {
			resultadoFinal+=verticesCentrais.get(i)+" -> VÉRTICE "+retornaNomeVetor(verticesCentrais.get(i), vertices)+"\n";
		}				
		return resultadoFinal;
	}
	
	//CALCULA A MATRIZ DE DISTÂNCIA PARA CALCULAR O CENTRO DO GRAFO
	public Integer[][] MontaMatrizDistancia(ArrayList<String>vertices,ArrayList<ArrayList<String>> listaAdjacencia){
		
		Integer[][] matrizDistancia = new Integer[vertices.size()][vertices.size()];
		
		for (int i = 0; i < matrizDistancia.length; i++) {
			for (int j = 0; j < matrizDistancia.length; j++) {								
				matrizDistancia[i][j] = BuscaCaminhoDistancia(vertices, i, j, listaAdjacencia);				
			}			
		}		
		return matrizDistancia;
	}

	//RETORNA A POSICAO DE UM VETOR DO GRAFO
	public Integer retornaPosicaoVetor(String vertice, ArrayList<String> vertices){				
		for (int i = 0; i < vertices.size(); i++) {
			if(vertices.get(i).equalsIgnoreCase(vertice)){				
				return i; 
			}			
		}				
		return null;
	}
	//RETORNO O NOME DE UMA POSICAO DO VETOR
	public String retornaNomeVetor(Integer vertice, ArrayList<String> vertices){				
		for (int i = 0; i < vertices.size(); i++) {
			if(vertices.get(i).equalsIgnoreCase(vertices.get(vertice))){				
				return vertices.get(i); 
			}			
		}				
		return null;
	}
	//CALCULA A DISTÂNCIA DE DOIS PONTOS DO GRAFO
	public Integer BuscaCaminhoDistancia(ArrayList<String> vertices, Integer linha,Integer coluna,ArrayList<ArrayList<String>> listaAdjacencia){
		ArrayList<Integer> proxPonteiros = new ArrayList<Integer>();
		ArrayList<Integer> proxIniciais = new ArrayList<Integer>();
		proxIniciais.clear();
		proxPonteiros.clear();
		int contDistancia=0;
		
		if(vertices.get(linha).equalsIgnoreCase(vertices.get(coluna))){
			return 0;			
		}else{
			boolean achei=false;
			proxIniciais.add(linha);			
				while(!achei){
					contDistancia++;
					System.out.println("cont distancia -> "+contDistancia);
					for (int l = 0; l < proxIniciais.size(); l++) {													
						for (int k = 0; k < listaAdjacencia.get(proxIniciais.get(l)).size(); k++) {					
							if(listaAdjacencia.get(proxIniciais.get(l)).get(k).equalsIgnoreCase(vertices.get(coluna))){
								System.out.println("Achei é TRUE!");
								achei=true;
								return contDistancia;
							}else{
								proxPonteiros.add(retornaPosicaoVetor(listaAdjacencia.get(proxIniciais.get(l)).get(k), vertices));
							}
						}
					}
					proxIniciais.clear();
					proxIniciais = transfereDados(proxIniciais, proxPonteiros);
					proxPonteiros.clear();
				}
			}
		return null;
	}
	
	//TRANSFERE OS DADOS DE ANALISE DE UM VETOR PARA O OUTRO INDICANDO QUE O CAMINHO AUMENTOU EM 1
	public ArrayList<Integer> transfereDados(ArrayList<Integer> iniciais,ArrayList<Integer> ponteiros){
		for (int i = 0; i < ponteiros.size(); i++) {
			iniciais.add(ponteiros.get(i));
		}
		return iniciais;
	}
}
