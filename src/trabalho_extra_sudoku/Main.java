/*
 * COLORAÇÃO DE GRAFOS NA RESOLUÇÃO DO SUDOKU
 * 
 * 1. Selecione o vértice do grau máximo V.
 * 2. Encontre o conjunto de vértices não adjacentes para V.
 * 3. A partir deste conjunto, selecione o vértice Y dos vértices máximos comuns com V.
 * 4. Contrato Y em V para ser colorido com a mesma cor.
 * 5. Remova Y do conjunto e repita as etapas 3-5 até que a lista esteja vazia.
 * 6. Retire o vértice V do gráfico
 * 7. Repita as etapas 1-6 até que o gráfico resultante tenha todos os nós contratados adjacentes um ao outro.
 * 
 */

package trabalho_extra_sudoku;

public class Main {
	
	int[8][8] sudoku[][] = {
	
	sudoku[1, 2] = 8
	sudoku[1, 3] = 1
	sudoku[1, 4] = 7
	sudoku[1, 5] = 9,
	sudoku[1, 7] = 3,
	sudoku[1, 9] = 4
	
	};

    puzzle[2, 5] = 4;
    puzzle[2, 8] = 1;
    puzzle[2, 9] = 6;


    puzzle[3, 3] = 6;
    puzzle[3, 4] = 1;
    puzzle[3, 6] = 3;
    puzzle[3, 8] = 5;


    puzzle[4, 6] = 8;
    puzzle[4, 7] = 6;
    puzzle[4, 8] = 4;


    puzzle[5, 3] = 8;
    puzzle[5, 4] = 9;
    puzzle[5, 6] = 4;
    puzzle[5, 7] = 1;


    puzzle[6, 2] = 4;
    puzzle[6, 3] = 9;
    puzzle[6, 4] = 2;


    puzzle[7, 2] = 9;
    puzzle[7, 4] = 6;
    puzzle[7, 6] = 5;
    puzzle[7, 7] = 2;

    puzzle[8, 1] = 8;
    puzzle[8, 2] = 7;
    puzzle[8, 5] = 2;


    puzzle[9, 1] = 2;
    puzzle[9, 3] = 5;
    puzzle[9, 5] = 1;
    puzzle[9, 6] = 7;
    puzzle[9, 7] = 4;
    puzzle[9, 8] = 9;

}
