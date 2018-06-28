package BuscaGrafos;

import java.util.List;
import java.util.Collections;

public class Vertice implements Comparable<Vertice>{
	private boolean visitado;
	private int numVertice;
	
	public Vertice() {
		this.visitado = false;
		this.numVertice = 0;
	}
	
	public boolean getVisitado() {
		return visitado;
	}
	
	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}
	
	public int getNumVertice() {
		return numVertice;
	}

	public void setNumVertice(int numVertice) {
		this.numVertice = numVertice;
	}
	//Ordena o vetor de vertices
	@Override
	public int compareTo(Vertice vertice) {
		 if (this.getNumVertice() < vertice.getNumVertice()) {
	            return -1;
	        }
	        if (this.getNumVertice() > vertice.getNumVertice()) {
	            return 1;
	        }
	        return 0;
	}

}
