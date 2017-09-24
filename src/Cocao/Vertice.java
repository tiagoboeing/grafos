package Cocao;


public class Vertice {
	public String nome;
	public Vertice anterior;
	public Vertice proximo;
	public int distancia;
	
	public int excentricidadeSaida;
	public int excentricidadeRetorno;
	
	@Override
	public boolean equals(Object obj) {
		Vertice vertice = (Vertice) obj;
		return nome.equals(vertice.nome); 
	}
	
	@Override
	public String toString() {
		return nome;
	}
	
}
