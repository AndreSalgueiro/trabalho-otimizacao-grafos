package ListaAdjacencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int u, v; 
		Scanner sc = new Scanner(System.in);
		try {
			FileReader arquivo = new FileReader("Grafos_Matriz_Lista_Adjacencia.txt");
			BufferedReader lerArquivo = new BufferedReader(arquivo);
			
			Grafo grafo = new Grafo(lerArquivo);
			ListaAdjacencia lista = new  ListaAdjacencia();
			
			long timeInicio = System.nanoTime();
			
			lista.lerGrafo(grafo);//monta a lista adjacencia
			
			long timeFinal = System.nanoTime();
			long elapsTime = timeFinal - timeInicio;
			System.out.println("O metodo executou em\n " +elapsTime);
			
			//imprime a lista adjacencia
			System.out.println("\nLista Adjacência \n" + lista.formataSaidaLista(grafo));
			System.out.println("Instruções\n");
			System.out.println("Digite o primeiro valor e tecle enter e digite o segundo valor e tecle enter\n");
			
			System.out.println("Digite a aresta a ser removida");
			u = sc.nextInt();
			v = sc.nextInt();
			lista.removeAresta(grafo, u, v);
			System.out.println("Lista Adjacência \n" + lista.formataSaidaLista(grafo));
			
			System.out.println("Digite a aresta a ser adicionada");
			u = sc.nextInt();
			v = sc.nextInt();
			lista.insere(grafo, u, v);
			lista.insere(grafo, v, u);
			System.out.println("Lista Adjacência \n" + lista.formataSaidaLista(grafo));
			
			System.out.println("Digite o vertice a ser adicionado");
			u = sc.nextInt();

			Grafo grafoNovoVertice = new Grafo();
			grafoNovoVertice.L = new NoAresta[grafo.n+1];
			grafoNovoVertice.L = lista.insereVertice(grafo, u);
			System.out.println("Lista Adjacência \n" + lista.formataSaidaLista(grafoNovoVertice));
			
			System.out.println("Digite o vertice para que seja mostrados seus vizinhos");
			u = sc.nextInt();
			lista.vizinhos(grafo, u);
			
			System.out.println("Digite o vertice a ser removido");
			u = sc.nextInt();
			lista.removeVertice(grafoNovoVertice, u);
			System.out.println("Lista Adjacência \n" + lista.formataSaidaLista(grafoNovoVertice));
			
			arquivo.close();
			lerArquivo.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
}