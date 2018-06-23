package MatrizAdjacencia;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		try {
		int u = 0, v =0;
		Scanner sc = new Scanner(System.in);
		FileReader arquivo = new FileReader("Grafos.txt");
		BufferedReader lerArquivo = new BufferedReader(arquivo);
		
		Grafo grafo = new Grafo(lerArquivo);
		MatrizAdjacencia matriz = new  MatrizAdjacencia();
		
		matriz.lerGrafo(grafo);//monta a matriz adjacencia
		
		System.out.println("Matriz Adjacência \n" + grafo.formataSaidaDaMatriz());
		
		System.out.println("Digite a aresta a ser removida");
		u = sc.nextInt();
		v = sc.nextInt();
		
		grafo.removerAresta(u,v); 
		System.out.println("Matriz Adjacência \n" + grafo.formataSaidaDaMatriz());
		
		System.out.println("Digite a aresta a ser adicionada");
		u = sc.nextInt();
		v = sc.nextInt();
		
		grafo.adicionarNovaAresta(u,v); 
		System.out.println("Matriz Adjacência \n" + grafo.formataSaidaDaMatriz());
		
		System.out.println("Digite o vertice a ser adicionado");
		u = sc.nextInt();
		
		grafo.adicionarVertice(u); 
		System.out.println("Matriz Adjacência \n" + grafo.formataSaidaDaMatriz());
		
		System.out.println("Digite o vertice para que seja mostrados seus vizinhos");
		u = sc.nextInt();
		
		grafo.retornarNosVizinhos(u); 
		System.out.println("Matriz Adjacência \n" + grafo.formataSaidaDaMatriz());
		
		System.out.println("Digite o vertice a ser removido");
		u = sc.nextInt();
		
		grafo.removerVertice(u);
		System.out.println("Matriz Adjacência \n" + grafo.formataSaidaDaMatriz());
		
		//fechando o arquivo
		arquivo.close();
		lerArquivo.close();
		
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
}
