package BuscaGrafos;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
	private List<Vertice> vertices;
	private List<Aresta> arestas;

	public Grafo() {
		this.vertices = new ArrayList<Vertice>();
		this.arestas = new ArrayList<Aresta>();
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
