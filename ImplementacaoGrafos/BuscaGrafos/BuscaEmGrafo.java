package BuscaGrafos;

import java.util.List;

public class BuscaEmGrafo {
	public BuscaEmGrafo() {
		
	}
	
	public void busca(Grafo grafo, int r) {
		int v = 0;
		int w = 0;
		
		grafo.getVertices().get(r).setVisitado(true);
		
		for(int vw = 0; vw < grafo.getArestas().size(); vw++){
			v = grafo.getArestas().get(vw).obterVertice_V_daAresta();
			w = grafo.getArestas().get(vw).obterVertice_W_daAresta();
			
			if(grafo.getVertices().get(v).getVisitado() && !grafo.getArestas().get(vw).getExplorada()) {
				grafo.getArestas().get(vw).setExplorada(true);
			}
			else if(!grafo.getVertices().get(w).getVisitado()){
				
				grafo.getVertices().get(w).setVisitado(true);
				grafo.getArestas().get(vw).setDescoberta(true);
			}
		}
	}
}
