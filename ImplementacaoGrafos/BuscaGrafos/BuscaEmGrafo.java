package BuscaGrafos;

import java.util.List;

public class BuscaEmGrafo {
	
	public void busca(Grafo grafo) {
		int r = 1;
		busca(grafo, r);
	}
	
	public void busca(Grafo grafo, int r) {
		int v = 0;
		int w = 0;
		
		grafo.getVertices().get(r-1).setVisitado(true);
		//para vw pertencente E(G)
		for(int vw = 0; vw < grafo.getArestas().size(); vw++){
			v = grafo.getArestas().get(vw).obterVertice_V_daAresta();
			w = grafo.getArestas().get(vw).obterVertice_W_daAresta();
			//tal que Visitado[v] e não Explorada[vw]
			if(grafo.getVertices().get(v-1).getVisitado() && !grafo.getArestas().get(vw).getExplorada())  {
				//Explorada[vw] ← V
				grafo.getArestas().get(vw).setExplorada(true); 
				//se não Visitado[w]
				if(!grafo.getVertices().get(w-1).getVisitado()){
					//Visitado[w], Descoberta[vw] ← V, V
					grafo.getVertices().get(w-1).setVisitado(true);
					grafo.getArestas().get(vw).setDescoberta(true);
				}
			}
			//faz o inverso v passa a ser w e w passa a ser v
			else if(grafo.getVertices().get(w-1).getVisitado() && !grafo.getArestas().get(vw).getExplorada())  {
				grafo.getArestas().get(vw).setExplorada(true);
				
				if(!grafo.getVertices().get(v-1).getVisitado()){
					grafo.getVertices().get(v-1).setVisitado(true);
					grafo.getArestas().get(vw).setDescoberta(true);
				}
			}		
		}
			
	}
	
	public void buscaCompleta(Grafo grafo) {
		//para r ← 1 até G.n faça
		for(int r = 0; r < grafo.getVertices().size(); r++) {
			//se não Visitado[r] faca
			if(!grafo.getVertices().get(r).getVisitado()) {
				busca(grafo, r+1);
			}
		}
	}
	
	public boolean ehConexo(Grafo grafo) {
		busca(grafo);
		//para v ∈ V(G) faça
		for(int i = 0; i < grafo.getVertices().size(); i++) {
			//se não Visitado[v] então
			if(!grafo.getVertices().get(i).getVisitado()) {
				System.out.println("\nO grafo não é conexo");
				return false;
				
			}
		}
		System.out.println("\nO grafo é conexo");
		return true;
	}
	
}
