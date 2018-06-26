package BuscaGrafos;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
	public static void main(String[] args)throws Exception {
		FileReader arquivo = new FileReader("Grafo_Busca.txt");
		BufferedReader lerArq = new BufferedReader(arquivo);
		String teste = lerArq.readLine();
	}
}
