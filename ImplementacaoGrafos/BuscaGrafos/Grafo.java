package BuscaGrafos;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class Grafo {
	private List<Vertice> vertices;
	private List<Aresta> arestas;

	public Grafo(BufferedReader lerArq)throws Exception {
		this.vertices = new ArrayList<Vertice>();
		this.arestas = new ArrayList<Aresta>();
		obterLinhasArq(lerArq);
	}
	
	public void obterLinhasArq(BufferedReader lerArq)throws Exception {
		//List aux = new ArrayList();
		String linha;
		List temp = new ArrayList();
		while((linha = lerArq.readLine()) != null) {
			//linhasArq.add(linha);
			String aux = "";
			String aux2 = "";
			//int temp = 0;
			
			for(int i = 0; i < linha.length(); i++) {
				if(Character.isDigit(linha.charAt(i))) {
					//Esse if extrai os vertices do arquivo lido
					if(!temp.contains(Character.getNumericValue(linha.charAt(i)))) {
						Vertice vertices = new Vertice();
						
						vertices.setNumVertice(Character.getNumericValue(linha.charAt(i)));
						this.vertices.add(vertices);
						temp.add(Character.getNumericValue(linha.charAt(i)));
					}
					//extraindo as arestas do grafo do arquivo lido
					aux = Character.toString(linha.charAt(i));
					aux2 = aux2 + aux;
					aux2 +=","; 
				}
			}
			//setando as arestas do grafo
			StringBuffer aux3 = new StringBuffer(aux2);
			Aresta aresta = new Aresta();
			aux3.deleteCharAt(3);
			aresta.setNumAresta(aux3.toString());
			this.arestas.add(aresta);
			
		}
	}
	
	public List<Vertice> getVertices() {
		return vertices;
	}
	
	public void setVertices(List<Vertice> v) {
		this.vertices = v;
	}
	
	public List<Aresta> getArestas() {
		return arestas;
	}
	
	public void setArestas(List<Aresta> vw) {
		this.arestas = vw;
	}
}
