package grafos.estrutura;

import java.util.ArrayList;

public class Aresta {
	
	private String pontoA;
	private String pontoB;

	public Aresta(String pontoA, String pontoB) {
		super();
		this.pontoA = pontoA;
		this.pontoB = pontoB;
	}
	
	@Override
	public String toString() {
		return "Aresta [pontoA=" + pontoA + ", pontoB=" + pontoB + "]";
	}

	public String getPontoA() {
		return pontoA;
	}
	public void setPontoA(String pontoA) {
		this.pontoA = pontoA;
	}
	public String getPontoB() {
		return pontoB;
	}
	public void setPontoB(String pontoB) {
		this.pontoB = pontoB;
	}

}
