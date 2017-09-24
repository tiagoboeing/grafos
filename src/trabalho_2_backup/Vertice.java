package trabalho_2_backup;

public class Vertice {
	
	private String nome;
	private int verticeSaida;
	private int verticeChegada;
	private Vertice verticeAnterior;
	private Vertice verticeProximo;
	private int valorVertice;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVerticeSaida() {
		return verticeSaida;
	}

	public void setVerticeSaida(int verticeSaida) {
		this.verticeSaida = verticeSaida;
	}

	public int getVerticeChegada() {
		return verticeChegada;
	}

	public void setVerticeChegada(int verticeChegada) {
		this.verticeChegada = verticeChegada;
	}

	public Vertice getVerticeAnterior() {
		return verticeAnterior;
	}

	public void setVerticeAnterior(Vertice verticeAnterior) {
		this.verticeAnterior = verticeAnterior;
	}

	public Vertice getVerticeProximo() {
		return verticeProximo;
	}

	public void setVerticeProximo(Vertice verticeProximo) {
		this.verticeProximo = verticeProximo;
	}

	public int getValorVertice() {
		return valorVertice;
	}

	public void setValorVertice(int valorVertice) {
		this.valorVertice = valorVertice;
	}	
		
	
	
}