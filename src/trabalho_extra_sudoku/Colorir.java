package trabalho_extra_sudoku;

import java.util.*;


public class Colorir implements ColoracaoGrafo {

    private Grafo g;
    private HashSet<Vertice> inicial, simplificar, pilhar, selectStack;
    private int[] grau;
    
    public Colorir() {
        inicial = new HashSet<Vertice>();
        simplificar = new HashSet<Vertice>();
        pilhar = new HashSet<Vertice>();
        selectStack = new HashSet<Vertice>();
    }
    /**
     * Atribui um número a cada nó do grafo, representando a coloração de grafo
     */
    public void colorir(Grafo g) {
    	
        this.g = g;
        init();
        pilhaTrabalho();
        
        do {
            if (!simplificar.isEmpty()) simplificar();
            else if (!pilhar.isEmpty()) selectSpill();
        } while (!simplificar.isEmpty() && !pilhar.isEmpty());
       
    }
    
    private void init() {
    	
        for (Vertice v : g.getVertices()) inicial.add(v);
        grau = new int[g.size()];
        for (int i = 0; i < g.size(); i++) {
            grau[i] = g.getVertex(i).vertexDegree();
        }
        
    }
    
    private void pilhaTrabalho() {
    	
        for (Vertice v : g.getVertices()) {
        	
            if (inicial.remove(v)) {
            	
                if (v.vertexDegree() >= Sudoku.K) {
                    pilhar.add(v);
                } else {
                	simplificar.add(v);
                }
                
            }
            
        }
        
    }
    
    private void simplificar() {
    	
        Vertice v = get(simplificar);
        simplificar.remove(v);
        selectStack.add(v);
        for (ListaAdjacencia node : v.getAdjList()) {
            Vertice u = g.getVertex(node.getverticeNumero());
            decrementDegree(u);
        }
        
    }
    
    
    private Vertice get(HashSet<Vertice> set) {
        Iterator<Vertice> iter = set.iterator();
        return iter.next();
    }
    
    
    private void decrementDegree(Vertice v) {
        int d = grau[v.getNumber()];
        grau[v.getNumber()] = d - 1;
        if (d == Sudoku.K) {
            pilhar.remove(v);
            simplificar.add(v);
        }
    }
    
    private void selectSpill() {
        Vertice v = get(pilhar);
        pilhar.remove(v);
        simplificar.add(v);
    }
}
