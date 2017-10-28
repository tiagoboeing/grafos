/*
 * 1. Encontre o grau de cada v�rtice. (Grau: � o n�mero de arestas ligadas a ele)
 * 2. Pe�a os v�rtices em ordem decrescente de acordo com o grau.
 * 3. Percorra a lista, colore cada v�rtice n�o conectado a v�rtices coloridos com a mesma cor.
 * 4. Remova os v�rtices coloridos da lista e repita o processo at� todos os v�rtices serem coloridos.
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
