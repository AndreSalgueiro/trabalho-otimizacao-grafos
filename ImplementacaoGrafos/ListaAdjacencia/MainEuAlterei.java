package ListaAdjacencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		
		try {
			FileReader arquivo = new FileReader("Grafos.txt");
			BufferedReader lerArquivo = new BufferedReader(arquivo);
			
			Grafo grafo = new Grafo(lerArquivo);
			ListaAdjacencia lista = new  ListaAdjacencia();
			
			lista.lerGrafo(grafo);//monta a lista adjacencia
			
			//fechando o arquivo
			arquivo.close();
			lerArquivo.close();
			
			//imprime a lista adjacencia
			System.out.println("Lista Adjacência \n" + lista.formataSaidaLista(grafo));
			
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
}

