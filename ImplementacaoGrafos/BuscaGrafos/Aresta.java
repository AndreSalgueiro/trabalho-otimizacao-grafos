package BuscaGrafos;

public class Aresta {
	private boolean explorada, descoberta;
	private String numAresta;
	public Aresta(){
		this.explorada = false;
		this.descoberta = false;
		this.numAresta = "";
	}
	
	public boolean getExplorada() {
		return explorada;
	}
	
	public void setExplorada(boolean explorada) {
		this.explorada = explorada;
	}
	
	public boolean getDescoberta() {
		return descoberta;
	}
	
	public void setDescoberta(boolean descoberta) {
		this.descoberta = descoberta;
	}
	
	public String getNumAresta() {
		return numAresta;
	}
	
	public void setNumAresta(String numAresta) {
		this.numAresta = numAresta;
	}
	public int obterVertice_V_daAresta() {
		int v = 0;
		v = Character.getNumericValue(this.numAresta.charAt(0)); 
		return v;
	}
	
	public int obterVertice_W_daAresta() {
		int w = 0;
		w = Character.getNumericValue(this.numAresta.charAt(2));
		return w;
	}
}
