/*
 * COLORAÇÃO DE GRAFOS NA RESOLUÇÃO DO SUDOKU
 * 
 * ETAPA 1
 * 1. Encontre o grau de cada vértice. (Grau: é o número de bordas ligadas a ele)
 * 2. Pega os vértices em ordem decrescente de acordo com o grau.
 * 3. Percorra a lista, colore cada vértice não conectado a vértices coloridos com a mesma cor.
 * 4. Remova os vértices coloridos da lista e repita o processo até todos os vértices serem coloridos.
 * 
 * ETAPA 2
 * 1. Selecionar o vértice do grau máximo V.
 * 2. Encontrar o conjunto de vértices não adjacentes para V.
 * 3. A partir deste conjunto, selecionar o vértice Y dos vértices máximos comuns com V.
 * 4. Y em V para ser colorido com a mesma cor.
 * 5. Remova Y do conjunto e repita as etapas 3-5 até que a lista esteja vazia.
 * 6. Retirar o vértice V do grafo
 * 7. Repita as etapas 1-6 até que o grafo resultante tenha todos os nós contratados adjacentes um ao outro.
 * 
 */


package trabalho_extra_sudoku;


public class Sudoku {
	
//	sudoku é 9 x 9 = 81
    public static final int NUM_VERTICES = 81;
    
//    grau máximo
    public static final int K = 9;
    

    public static void main(String[] args) {
    	
        Grafo g = new Grafo(NUM_VERTICES);
        
        
        // cadastra grafo do jogo sudoku
    	/*int[][] sudoku = new int[81][81];
		
		sudoku[1][2] = 8;
		sudoku[1][3] = 1;
		sudoku[1][4] = 7;
		sudoku[1][5] = 9;
		sudoku[1][7] = 3;
		sudoku[1][9] = 4;

		sudoku[2][5] = 4;
		sudoku[2][8] = 1;
		sudoku[2][9] = 6;

		sudoku[3][3] = 6;
		sudoku[3][4] = 1;
		sudoku[3][6] = 3;
		sudoku[3][ 8] = 5;

		sudoku[4][6] = 8;
		sudoku[4][7] = 6;
		sudoku[4][8] = 4;

		sudoku[5][3] = 8;
		sudoku[5][4] = 9;
		sudoku[5][6] = 4;
		sudoku[5][7] = 1;

		sudoku[6][2] = 4;
		sudoku[6][3] = 9;
		sudoku[6][4] = 2;

		sudoku[7][2] = 9;
		sudoku[7][4] = 6;
		sudoku[7][6] = 5;
		sudoku[7][7] = 2;

		sudoku[8][1] = 8;
		sudoku[8][2] = 7;
		sudoku[8][5] = 2;

		sudoku[9][1] = 2;
		sudoku[9][3] = 5;
		sudoku[9][5] = 1;
		sudoku[9][6] = 7;
		sudoku[9][7] = 4;
		sudoku[9][8] = 9;*/
        
        
        // inicializa todos os vértices com 0
        for (Vertice v : g.getVertices()) {
            v.setNumber(0);
        }
        
 
    
    }
}
