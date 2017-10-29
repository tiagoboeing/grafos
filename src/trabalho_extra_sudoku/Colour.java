package trabalho_extra_sudoku;

import java.util.*;

/** 
 * Algorithm to be based on George and Appel graph colouring
 * algorithm.
 *
 * @author cmcl
 * @version 1.0
 * 
 */
public class Colour implements ColoracaoGrafo {

    private Grafo g;
    private HashSet<Vertice> inicial, simplify, spill, selectStack;
    private int[] degree;
    
    public Colour() {
        inicial = new HashSet<Vertice>();
        simplify = new HashSet<Vertice>();
        spill = new HashSet<Vertice>();
        selectStack = new HashSet<Vertice>();
    }
    /**
     * Assigns a number to each node in the graph, representing
     * the colouring of the graph.
     */
    public void colorir(Grafo g) {
        this.g = g;
        init();
        makeWorklists();
        do {
            if (!simplify.isEmpty()) simplify();
            else if (!spill.isEmpty()) selectSpill();
        } while (!simplify.isEmpty() && !spill.isEmpty());
        // simplify
        // coalesce
        // freeze?
        // spill
    }
    
    private void init() {
        for (Vertice v : g.getVertices()) inicial.add(v);
        degree = new int[g.size()];
        for (int i = 0; i < g.size(); i++) {
            degree[i] = g.getVertex(i).vertexDegree();
        }
    }
    
    private void makeWorklists() {
        for (Vertice v : g.getVertices()) {
            if (inicial.remove(v)) {
                if (v.vertexDegree() >= Sudoku.K) {
                    spill.add(v);
                } else simplify.add(v);
            }
        }
    }
    
    private void simplify() {
        Vertice v = get(simplify);
        simplify.remove(v);
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
        int d = degree[v.getNumber()];
        degree[v.getNumber()] = d - 1;
        if (d == Sudoku.K) {
            spill.remove(v);
            simplify.add(v);
        }
    }
    
    private void selectSpill() {
        Vertice v = get(spill);
        spill.remove(v);
        simplify.add(v);
    }
}
