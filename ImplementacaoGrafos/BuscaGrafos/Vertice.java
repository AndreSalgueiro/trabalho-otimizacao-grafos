package BuscaGrafos;

public class Vertice {
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

}
