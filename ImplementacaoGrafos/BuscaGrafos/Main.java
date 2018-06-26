package BuscaGrafos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class Main {
	public static void main(String[] args)throws Exception {
		FileReader arquivo = new FileReader("Grafo_Busca2.txt");
		BufferedReader lerArq = new BufferedReader(arquivo);
		Grafo grafo = new Grafo(lerArq);
		BuscaEmGrafo buscar = new BuscaEmGrafo();
		
		buscar.busca(grafo, 1);
		System.out.println("Busca\n");
		for(Aresta arestas : grafo.getArestas()) {
			System.out.println("Aresta - "+arestas.getNumAresta()+" | Descoberta - "+arestas.getDescoberta()+" | Explorada - " +arestas.getExplorada()+"\n");
		}
		
		buscar.buscaCompleta(grafo);
		System.out.println("\nBusca Completa\n");
		for(Aresta arestas : grafo.getArestas()) {
			System.out.println("Aresta - "+arestas.getNumAresta()+" | Descoberta - "+arestas.getDescoberta()+" | Explorada - " +arestas.getExplorada()+"\n");
		}
	}
}
