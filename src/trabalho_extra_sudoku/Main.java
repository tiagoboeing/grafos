/*
 * 1. Encontre o grau de cada vértice. (Grau: é o número de arestas ligadas a ele)
 * 2. Peça os vértices em ordem decrescente de acordo com o grau.
 * 3. Percorra a lista, colore cada vértice não conectado a vértices coloridos com a mesma cor.
 * 4. Remova os vértices coloridos da lista e repita o processo até todos os vértices serem coloridos.
*/

package trabalho_extra_sudoku;

public class Main {

	int colorNumber = 1; //number of used colors
	int numberOfColoredNodes = 0;
	
	while (numberOfColoredNodes < graph.Count){
		
	 int max = -1;
	 int index = -1;

	 for (int i = 0; i < graph.Count; i++){
		 
	  if (!Colored(graph.Nodes[i], nodeSet)){
		  
	   int d = SaturatedDegree(graph.Nodes[i], nodeSet);
	   if (d > max)
	   {
	    max = d;
	    index = i;
	   }
	   else if (d == max)
	   {
	    if (Degree(graph.Nodes[i]) > Degree(graph.Nodes[index]))
	    {
	     index = i;
	    }
	   }
	  }
	 }
	 AssignColor(graph.Nodes[index], nodeSet,ref colorNumber);
	 numberOfColoredNodes++;
	}
	
	

}
