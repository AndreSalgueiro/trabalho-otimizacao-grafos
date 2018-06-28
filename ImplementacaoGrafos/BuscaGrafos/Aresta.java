package BuscaGrafos;

public class Aresta {
	private boolean explorada, descoberta;
	private String numAresta;
	public Aresta(){
		this.explorada = false;
		this.descoberta = false;
		this.numAresta = "";
	}
	public int obterVertice_V_daAresta() {
		int v = 0;
		String aux ="";
		String aux2 = "";
		for(int i = 0; i < numAresta.length(); i++) {
			if(",".equals(Character.toString(numAresta.charAt(i)))) {
				break;
			}
			
			aux = Character.toString(numAresta.charAt(i));
			aux2 = aux2 + aux;
		}
		 v = Integer.parseInt(aux2);
		return v;
	}
	
	public int obterVertice_W_daAresta() {
		int w = 0;
		String temp ="";
		String temp2 ="";
		
		for(int i = numAresta.indexOf(','); i < numAresta.length(); i++) {
			if(",".equals(Character.toString(numAresta.charAt(i)))) {
				i++;
			}
			temp = Character.toString(numAresta.charAt(i));
			temp2 = temp2 + temp;
		}
		w = Integer.parseInt(temp2);
		return w;
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
}
