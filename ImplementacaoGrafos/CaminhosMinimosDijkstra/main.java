package CaminhosMinimosDijkstra;

import java.util.ArrayList;
import java.util.List;

public class main {

public static void main(String args[]) {
		//Passa v1 e v8 para encontrar o menor caminho no metodo encontrarMenorCaminhoDijkstra
		Grafo teste = new Grafo();
		LerArquivo lerArquivo = new LerArquivo();
		
		String v1 = "v1";
		String v2 = "v8";
		
		System.out.println("Menor caminho entre os vertices " + v1 + " e " + v2 );
		
		teste.setVertices(lerArquivo.lerGrafo("grafoCaminhoMin.txt"));
		
		Vertice i1 = new Vertice();
		Vertice i2 = new Vertice();
		
		i1 = teste.encontrarVertice(v1);
		i2 = teste.encontrarVertice(v2);

		List<Vertice> resultado = new ArrayList<Vertice>();
		Dijkstra algoritmo = new Dijkstra();
		
		resultado = algoritmo.encontrarMenorCaminhoDijkstra(teste, i1, i2);

		System.out.println("Esse e o menor caminho feito pelo algoritmo:"
				+ resultado);
	}

}
