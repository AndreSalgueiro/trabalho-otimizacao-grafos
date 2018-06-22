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
				
				insere(G, u, v);
				insere(G,v, u);
			}
		}
	}
	  
	protected void insere(Grafo G, int indice, int vizinho){
		NoAresta novo = new NoAresta();
		novo.vizinho = vizinho;
		novo.prox = G.L[indice-1].prox;
		G.L[indice-1].prox = novo;
		
	}
	
	protected void removeAresta(Grafo G, int u, int v) {
		NoAresta ant = new NoAresta();
		NoAresta x = new NoAresta();
		
		ant = G.L[u-1];
		//System.out.println("ant = " + ant.vizinho);
		x = ant.prox;
		//System.out.println("x = " + x.vizinho);
		//System.out.println("123");
		
		while(x.vizinho!= v) { // anda pela lista[u] at� encontrar v
		ant = ant.prox;
		x = x.prox;
		}
		
		ant.prox = x.prox;
		x.prox = null;
		
		ant = G.L[v-1];
		x = ant.prox;
		
		while(x.vizinho!=u) { // anda pela lista[v] at� encontrar u
		ant = ant.prox;
		x = x.prox;
		}
		ant.prox = x.prox;
		x.prox = null;
	}
	
	
	
	protected void removeVertice(Grafo G, int vertice) {
		NoAresta aux;
		int i;
		int j = G.n-1;
		while(G.L[vertice-1].prox!=null) {
			aux = G.L[vertice-1].prox;
			i = aux.vizinho;
			removeAresta(G, vertice, i);
			}
		G.L[vertice-1].vizinho = 0; 
	}
	
	public NoAresta[] insereVertice(Grafo G, int u)
	{
		int i = G.L.length+1;
		NoAresta aux = new NoAresta();
		NoAresta[] novoArray = new NoAresta[i];
		
		aux.vizinho = u;
		System.arraycopy(G.L, 0, novoArray, 0, G.L.length);
		novoArray[i-1] = aux;
		return novoArray;
	}
	
	public void vizinhos(Grafo G, int u)
	{
		NoAresta aux = new NoAresta();
		aux = G.L.clone()[u-1];
		
		while(aux!=null)
		{
		System.out.print(aux.vizinho + " --> ");
		aux = aux.prox;
		}
		System.out.println("null");
	}
	
	protected String formataSaidaLista(Grafo G) {
		String saida=""; // Cria e inicializa uma String
		int vertice = 0;

		for(int i = 0; i < G.L.length; i++){//intera pelo array de vizinhos
			boolean existeVizinho = true;
			NoAresta NoAtual = G.L[i];
			vertice = i+1;
			//saida = saida + NoAtual.vizinho + " --> ";
		
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