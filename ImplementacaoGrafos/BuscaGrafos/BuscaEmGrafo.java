package BuscaGrafos;

import java.util.List;
import java.util.Vector;
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
				return false;
				
			}
		}
		return true;
	}
	
	public boolean temCiclo(Grafo grafo) {
		buscaCompleta(grafo);
			for(int vw = 0; vw < grafo.getArestas().size(); vw++) {
				if(!grafo.getArestas().get(vw).getExplorada()) {
					return true;
				}
			}
		return false;
	}
	
	public boolean ehFloresta(Grafo grafo) {
		return(!temCiclo(grafo));
	}
	
	public boolean ehArvore(Grafo grafo) {
		busca(grafo, 1);
			for(int r = 0; r < grafo.getVertices().size(); r++) {
				if(!grafo.getVertices().get(r).getVisitado()) {
					return false;
				}
			}	
			for(int vw = 0; vw < grafo.getArestas().size(); vw++) {
				if(!grafo.getArestas().get(vw).getDescoberta()) {
					return false;
				}
			}
			return true;
	}
	public boolean ehArvoreAlternativa(Grafo grafo) {
		
		return (ehConexo(grafo) && !temCiclo(grafo));
	}
	
	public Grafo obterFlorestaGeradora(Grafo grafo) throws Exception {
		Grafo grafoT = new Grafo(grafo);
		buscaCompleta(grafo);
			for(int vw = 0; vw < grafo.getArestas().size(); vw++) {
				if(grafo.getArestas().get(vw).getDescoberta()) {
						grafoT.getArestas().add(grafo.getArestas().get(vw));
				}
				
			}		
				return grafoT;
	}
	
	public void buscaProfundidade(Grafo grafo, int r) {
		Pilha pilha = new Pilha();
				
		grafo.getVertices().get(r).setVisitado(true);
		pilha.empilha(new Vector(r,grafo.primeiroViz(r)));
		
		while (pilha.tamanho() > 0) {
			Vector aresta = (Vector)pilha.desempilha();
			int w = (int)aresta.get(1);
			int v = (int)aresta.get(0);
			int vw = grafo.encontraVW(v, w);
			
			if(w > 0) {
				pilha.empilha(new Vector(v,grafo.proximoViz(v,w)));

				if(grafo.getVertices().get(w).getVisitado()) {
					if(!grafo.getArestas().get(vw).getExplorada()) {
						grafo.getArestas().get(vw).setExplorada(true);
					
					}
				}	
				else {
					grafo.getArestas().get(vw).setExplorada(true);
					grafo.getArestas().get(vw).setDescoberta(true);
					grafo.getVertices().get(w).setVisitado(true);
					pilha.empilha(new Vector(w,grafo.primeiroViz(w)));
			}
			
			}
		}
	}
	//Versao Recursiva
	//Nao esta 100%
//	public void buscaProfundidadeRecursiva(Grafo grafo, int r) {
//		grafo.getVertices().get(r).setVisitado(true);
//		
//			//Na verdade esse for deveria usar o w como indice e nao o v
//			for(int w = 0; w < grafo.getVertices().size(); w++) {
//				if(grafo.getVertices().get(w).getVisitado()) {
//					if(!grafo.getArestas().get(vw).Explorada()) {
//						grafo.getArestas().get(vw).setExplorada(true);
//					}
//				}
//				else {
//					grafo.getArestas().get(vw).setExplorada(true);
//					grafo.getArestas().get(vw).setDescoberta(true);
//					buscaProfundidade(grafo,w);
//				}
//				
//			}
//	}
}
