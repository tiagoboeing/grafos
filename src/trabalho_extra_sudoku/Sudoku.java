package trabalho_extra_sudoku;

import javax.swing.*;


public class Sudoku {
	
//	sudoku é 9 x 9 = 81
    public static final int NUM_VERTICES = 81;
    
//    grau máximo
    public static final int K = 9;
    

    public static void main(String[] args) {
    	
        Grafo g = new Grafo(NUM_VERTICES);
        
        // inicializa todos os vértices com 0
        for (Vertice v : g.getVertices()) {
            v.setNumber(0);
        }
        
        // show gui
        final SudokuView view = new SudokuView(g);
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                view.setupGui();
            }
        });
        
        // input numbers in g from user
        
        // colour the graph g
        
        // update state to user; successful colouring, or no solution.
    
    }
}
