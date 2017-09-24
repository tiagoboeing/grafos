package testes;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.*;

import grafos.Processador;
import grafos.estrutura.Aresta;
import grafos.estrutura.Grafo;
import grafos.estrutura.Representacoes;

public class TesteGrafo {
	
	@Test
	public void testeCentroGrafo1(){
		Grafo grafo = new Grafo();
		grafo.getVertices().add("A");
		grafo.getVertices().add("B");
		grafo.getVertices().add("C");
		grafo.getVertices().add("D");
		grafo.getVertices().add("E");
		grafo.getVertices().add("F");
		grafo.getArestas().add(new Aresta("A", "B"));
		grafo.getArestas().add(new Aresta("A", "C"));
		grafo.getArestas().add(new Aresta("A", "E"));
		grafo.getArestas().add(new Aresta("B", "D"));
		grafo.getArestas().add(new Aresta("B", "E"));
		grafo.getArestas().add(new Aresta("C", "D"));
		grafo.getArestas().add(new Aresta("D", "E"));
		grafo.getArestas().add(new Aresta("E", "F"));
		
		Representacoes representacoes = Processador.processaGrafo(grafo);
		ArrayList<String> centros = new ArrayList<>();
		centros.add("A");
		centros.add("B");
		centros.add("D");
		centros.add("E");
		
		Collections.sort(centros);
		Collections.sort(representacoes.getCentroGrafo());
		Assert.assertEquals(centros, representacoes.getCentroGrafo());
	}
	
	@Test
	public void testeCentroGrafo2(){
		Grafo grafo = new Grafo();
		grafo.getVertices().add("A");
		grafo.getVertices().add("F");
		grafo.getVertices().add("C");
		grafo.getVertices().add("E");
		grafo.getVertices().add("D");
		grafo.getVertices().add("B");
		grafo.getArestas().add(new Aresta("A", "D"));
		grafo.getArestas().add(new Aresta("E", "B"));
		grafo.getArestas().add(new Aresta("B", "F"));
		grafo.getArestas().add(new Aresta("E", "C"));
		grafo.getArestas().add(new Aresta("C", "F"));
		grafo.getArestas().add(new Aresta("C", "D"));
		grafo.getArestas().add(new Aresta("D", "E"));
		
		Representacoes representacoes = Processador.processaGrafo(grafo);
		ArrayList<String> centros = new ArrayList<>();
		centros.add("C");
		centros.add("D");
		centros.add("E");
		
		Collections.sort(centros);
		Collections.sort(representacoes.getCentroGrafo());
		Assert.assertEquals(centros, representacoes.getCentroGrafo());
	}
	
	@Test
	public void testeCentroGrafo3(){
		Grafo grafo = new Grafo();
		grafo.getVertices().add("A");
		grafo.getVertices().add("F");
		grafo.getVertices().add("C");
		grafo.getVertices().add("E");
		grafo.getVertices().add("D");
		grafo.getVertices().add("B");
		grafo.getArestas().add(new Aresta("A", "B"));
		grafo.getArestas().add(new Aresta("A", "C"));
		grafo.getArestas().add(new Aresta("A", "E"));
		grafo.getArestas().add(new Aresta("A", "F"));
		grafo.getArestas().add(new Aresta("B", "E"));
		grafo.getArestas().add(new Aresta("B", "F"));
		grafo.getArestas().add(new Aresta("B", "D"));
		grafo.getArestas().add(new Aresta("D", "F"));
		grafo.getArestas().add(new Aresta("C", "D"));
		grafo.getArestas().add(new Aresta("C", "E"));
		grafo.getArestas().add(new Aresta("E", "F"));
		
		Representacoes representacoes = Processador.processaGrafo(grafo);
		ArrayList<String> centros = new ArrayList<>();
		centros.add("A");
		centros.add("B");
		centros.add("C");
		centros.add("D");
		centros.add("E");
		centros.add("F");
		
		Collections.sort(centros);
		Collections.sort(representacoes.getCentroGrafo());
		Assert.assertEquals(centros, representacoes.getCentroGrafo());
	}
}
