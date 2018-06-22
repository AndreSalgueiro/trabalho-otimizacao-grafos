package ListaAdjacencia;

public class ListaAdjacencia {   
	protected void lerGrafo(Grafo G){
		int u,v;
	   	
		for(int j = 0; j < G.arestas.length(); j++) {	
			//ler u e v
			if(Character.isDigit(G.arestas.charAt(j))) { 			
				u = Character.getNumericValue(G.arestas.charAt(j)); 			
				j = j+2; 				
				v = Character.getNumericValue(G.arestas.charAt(j)); 
				
				insere(G, u-1, v);
				insere(G,v-1, u);
			}
		}
	}
	  
	protected void insere(Grafo G, int indice, int vizinho){
		NoAresta novo = new NoAresta();
		novo.vizinho = vizinho;
		novo.prox = G.L[indice];
		G.L[indice] = novo;
	}
	
	protected String formataSaidaLista(Grafo G) {
		String saida=""; // Cria e inicializa uma String
		int vertice = 0;

		for(int i = 0; i < G.L.length; i++){//intera pelo array de vizinhos
			boolean existeVizinho = true;
			NoAresta NoAtual = G.L[i];
			vertice = i+1;
			saida = saida + vertice + " --> ";
		
			while(existeVizinho) {
				saida = saida + NoAtual.vizinho + " --> ";

				if(NoAtual.prox == null) {
					existeVizinho = false;
					saida = saida + NoAtual.prox + "\n"; 
				}
			NoAtual = NoAtual.prox;
			}
		}
		return saida; //retorna a String formatada
	}
	   	
}
