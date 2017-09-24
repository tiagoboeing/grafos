package Larroyd;

public class Vertice {
	private String nome;
	private int saida;
	private int chegada;
	private Vertice anterior;
	private Vertice proximo;
	private int valor;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSaida() {
		return saida;
	}

	public void setSaida(int saida) {
		this.saida = saida;
	}

	public int getChegada() {
		return chegada;
	}

	public void setChegada(int chegada) {
		this.chegada = chegada;
	}

	public Vertice getAnterior() {
		return anterior;
	}

	public void setAnterior(Vertice anterior) {
		this.anterior = anterior;
	}

	public Vertice getProximo() {
		return proximo;
	}

	public void setProximo(Vertice proximo) {
		this.proximo = proximo;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	
}