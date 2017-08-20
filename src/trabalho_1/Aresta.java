package trabalho_1;

public class Aresta {
	
	private Integer valor;
	private Vertice verticeSaida;
	private Vertice verticeChegada;
	
	public Integer getValor() {
		return valor;
	}
	public Vertice getVerticeSaida() {
		return verticeSaida;
	}
	public Vertice getVerticeChegada() {
		return verticeChegada;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	public void setVerticeSaida(Vertice verticeSaida) {
		this.verticeSaida = verticeSaida;
	}
	public void setVerticeChegada(Vertice verticeChegada) {
		this.verticeChegada = verticeChegada;
	}
}
