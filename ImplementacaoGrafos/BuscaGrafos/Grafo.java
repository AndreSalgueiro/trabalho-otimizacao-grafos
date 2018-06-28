package BuscaGrafos;

import java.io.BufferedReader;
import java.io.File;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Collections;
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
		String linha;
		List temp = new ArrayList();
		
		while((linha = lerArq.readLine()) != null) {
			String aux = "";
			String aux2 = "";
			String aux4 = "";
			boolean depoisVirgula = false;
			
			for(int i = 0; i < linha.length(); i++) {
				if(!"v".equals(Character.toString(linha.charAt(i)))) {
					if(!" ".equals(Character.toString(linha.charAt(i)))) {
						aux = Character.toString(linha.charAt(i));
							aux2 = aux2 + aux;//usado para salvar as arestas do grafo
							aux4 = aux4 + aux; // usado para salvar os vertices do grafo
					}
					if((" ".equals(Character.toString(linha.charAt(i)))) || (i == linha.length() -1)) {
						depoisVirgula = true;
						}
					while(depoisVirgula) {
						int numVertice = Integer.parseInt(aux4);
						//Setando os vertices do grafo
						if(!temp.contains(numVertice)) {//para não pegar vetices repitidos
							Vertice vertices = new Vertice();
							vertices.setNumVertice(numVertice);
							this.vertices.add(vertices);//colona o objeto vertice na posicao do numero do vertice no array list
							temp.add(numVertice);
						}
						aux2 +=",";//adiciona uma virgula para separar as duas arestas
						aux4 = "";
						depoisVirgula = false;
					}
				}
			}
			//setando as arestas do grafo
			StringBuffer aux3 = new StringBuffer(aux2);
			Aresta aresta = new Aresta();
			aux3.deleteCharAt(aux3.length()-1);//exclui a ultima virgula que foi adicionada
			aresta.setNumAresta(aux3.toString());
			this.arestas.add(aresta);
		}
		//Ordena o vetor de vertices
		Collections.sort(vertices);
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
