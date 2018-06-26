package BuscaGrafos;

import java.util.List;

public class BuscaEmGrafo {
	public BuscaEmGrafo() {
		
	}
	
	public void busca(Grafo grafo, int r) {
		int v = 0;
		int w = 0;
		//Aresta aux = new Aresta();
		
		grafo.getVertices().get(r-1).setVisitado(true);
		/*for(int i = 0; i < grafo.getArestas().size(); i++){
			if(grafo.getArestas().get(i).getNumAresta().indexOf(r) != -1) {
				
			}
		}*/
		for(int vw = 0; vw < grafo.getArestas().size(); vw++){
			//if(grafo.getArestas().get(vw).getNumAresta().indexOf(r) != -1) {
				v = grafo.getArestas().get(vw).obterVertice_V_daAresta();
				w = grafo.getArestas().get(vw).obterVertice_W_daAresta();
				
				if(grafo.getVertices().get(v-1).getVisitado() && !grafo.getArestas().get(vw).getExplorada()) {
					grafo.getArestas().get(vw).setExplorada(true);
					
					if(!grafo.getVertices().get(w-1).getVisitado()){
						grafo.getVertices().get(w-1).setVisitado(true);
						grafo.getArestas().get(vw).setDescoberta(true);
					}
				}
			//}
		}
	}
	
	public void buscaCompleta(Grafo grafo) {
		for(int r = 0; r < grafo.getVertices().size(); r++) {
			if(!grafo.getVertices().get(r).getVisitado()) {
				busca(grafo, r+1);
			}
			
		}
	}
	
	public boolean ehConexo(Grafo grafo) {
		return true;
	}
}
