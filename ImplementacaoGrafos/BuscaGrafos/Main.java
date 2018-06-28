package BuscaGrafos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class Main {
	public static void main(String[] args)throws Exception {
		
		FileReader arquivo = new FileReader("Grafo_Ciclo.txt");
		BufferedReader lerArq = new BufferedReader(arquivo);
		Grafo grafo = new Grafo(lerArq);
		BuscaEmGrafo buscar = new BuscaEmGrafo();
		
		//****************************************************************************************************************************************************

//		long timeInicio = System.nanoTime();
//		
//		buscar.busca(grafo);
//		
//		long timeFinal = System.nanoTime();
//		long elapsTime = timeFinal - timeInicio;
//		System.out.println("O metodo executou em\n " +elapsTime);
//		
//		System.out.println("Quantidade de arestas do grafo\n"+grafo.getArestas().size());
//		for(Aresta arestas : grafo.getArestas()) {
//			System.out.println("\nAresta - "+arestas.getNumAresta()+" | Descoberta - "+arestas.getDescoberta()+" | Explorada - " +arestas.getExplorada()+"\n");
//		}
//		System.out.println("\nQuantidade de vertices do grafo\n"+grafo.getVertices().size());
//		for(Vertice vertices: grafo.getVertices() ) {
//			System.out.println("\nVertices - "+vertices.getNumVertice()+" | Visitado - "+vertices.getVisitado()+"\n");
//		}
//		
		
		//****************************************************************************************************************************************************
		
		
//		long timeInicio = System.nanoTime();
//		
//		buscar.buscaCompleta(grafo);
//		
//		long timeFinal = System.nanoTime();
//		long elapsTime = timeFinal - timeInicio;
//		 System.out.println("O metodo executou em\n " +elapsTime);
//		 
//		for(Aresta arestas : grafo.getArestas()) {
//			System.out.println("\nAresta - "+arestas.getNumAresta()+" | Descoberta - "+arestas.getDescoberta()+" | Explorada - " +arestas.getExplorada()+"\n");
//		}
//		for(Vertice vertices: grafo.getVertices() ) {
//			System.out.println("\nVertices - "+vertices.getNumVertice()+" | Visitado - "+vertices.getVisitado()+"\n");
//		}
		
		//****************************************************************************************************************************************************
		
//		long timeInicio = System.nanoTime();
//		
//		if(buscar.ehConexo(grafo)) {//Usa busca
//			System.out.println("\nO grafo é conexo\n");
//		}else {
//			System.out.println("\nO grafo não é conexo");
//		}
//		
//		long timeFinal = System.nanoTime();
//		long elapsTime = timeFinal - timeInicio;
//		System.out.println("O metodo executou em\n " +elapsTime);
//		
//		for(Aresta arestas : grafo.getArestas()) {
//			System.out.println("\nAresta - "+arestas.getNumAresta()+" | Descoberta - "+arestas.getDescoberta()+" | Explorada - " +arestas.getExplorada()+"\n");
//		}
//		for(Vertice vertices: grafo.getVertices() ) {
//			System.out.println("\nVertices - "+vertices.getNumVertice()+" | Visitado - "+vertices.getVisitado()+"\n");
//		}
		
		//****************************************************************************************************************************************************
		
//		long timeInicio = System.nanoTime();
//		
//		if(buscar.temCiclo(grafo)) {//Usa busca completa
//			
//			System.out.println("\nO grafo tem ciclo");
//		}else {
//			System.out.println("\nO grafo não tem ciclo");
//		}	
//		
//		long timeFinal = System.nanoTime();
//		long elapsTime = timeFinal - timeInicio;
//		System.out.println("O metodo executou em\n " +elapsTime);
		
		//****************************************************************************************************************************************************
		
//		long timeInicio = System.nanoTime();
//		
//		if(buscar.ehFloresta(grafo)) {//se não tem ciclo e busca completa
//			
//			
//			System.out.println("\nO grafo é floresta");
//		}else {
//			System.out.println("\nO grafo não é floresta");
//		}
//		
//		long timeFinal = System.nanoTime();
//		long elapsTime = timeFinal - timeInicio;
//		System.out.println("O metodo executou em\n " +elapsTime);
		
		
		//****************************************************************************************************************************************************
		
//		long timeInicio = System.nanoTime();
//		
//		if(buscar.ehArvore(grafo)) {//Utiliza busca
//			System.out.println("\nO grafo é árvore");
//			
//		}else {
//			System.out.println("\nO grafo não é árvore");
//		}
//		
//		long timeFinal = System.nanoTime();
//		long elapsTime = timeFinal - timeInicio;
//		System.out.println("O metodo executou em\n " +elapsTime);
		
		//****************************************************************************************************************************************************
		
//		long timeInicio = System.nanoTime();
//		
//		if(buscar.ehArvoreAlternativa(grafo)) {//verifica se é conexo e não tem ciclo usa busca completa
//			System.out.println("\nO grafo é árvore alternativa");
//		}else {
//			System.out.println("\nO grafo não é árvore alternativa");
//		}
//		
//		long timeFinal = System.nanoTime();
//		long elapsTime = timeFinal - timeInicio;
//		System.out.println("O metodo executou em\n " +elapsTime);
		
		//****************************************************************************************************************************************************
		
		long timeInicio = System.nanoTime();
		
		Grafo grafoImprimir = buscar.obterFlorestaGeradora(grafo); //Usa Busca Completa
		
		long timeFinal = System.nanoTime();
		long elapsTime = timeFinal - timeInicio;
		System.out.println("O metodo executou em\n " +elapsTime);
		for(int i = 0; i < grafoImprimir.getArestas().size(); i++) {
			
			System.out.println("\nArestas da foresta geradora\n\n"+grafoImprimir.getArestas().get(i));
		}
		
		//****************************************************************************************************************************************************
		
		arquivo.close();
		lerArq.close();
	}
}
