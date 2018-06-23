package MatrizAdjacencia;
import java.io.BufferedReader;
import java.io.IOException;

public class Grafo {
	BufferedReader lerArquivo;
	String arestas;
	String linnhaArquivo;
	String linnhaArquivo2;
	int n; //qnt de vertices do grafo
	int m; // qnt de arestas do grafo
	int[][] M;
	public Grafo(BufferedReader lerArquivo) {
		this.lerArquivo = lerArquivo;
		obterDimensaoMatriz(this.lerArquivo);
		M = new int[n][n];
	}
	
	private void obterDimensaoMatriz(BufferedReader lerArquivo) {
		int qntArestas = 0;
		int qntVertices = 0;
		
		try {
			this.linnhaArquivo = lerArquivo.readLine();//lendo a primeira linha do arquivo
			//Contando a quantidade de vertices no arquivo
			for(int i = 0; i < linnhaArquivo.length(); i++) {
				if(Character.isDigit(linnhaArquivo.charAt(i))) {//se for digito entao e o vertice logo incrementa o contador de vertices
					qntVertices++;
				}
			}
			n = qntVertices;
			System.out.println(linnhaArquivo);
			
			String linnhaArquivo2 = lerArquivo.readLine(); //lendo a proxima linha do arquivo 
			System.out.println(linnhaArquivo2 + "\n");
			
			//Contando a quantidade de arestas no arquivo
			for(int i = 0; i < linnhaArquivo2.length(); i++) {
				if(Character.isDigit(linnhaArquivo2.charAt(i))) {//se for digito entao e a aresta, logo incrementa a contador de arestas
					qntArestas++;
				}
			}
			m = qntArestas/2;//divide a quantidade de digitos numericos no arquivo para pegar quantidade de arestas do grafo
			arestas = linnhaArquivo2; //setando a variavel aresta que é usado na classe MatrizAdjacencia

		}
		catch(IOException ex) {
			ex.getStackTrace();
		}
	}
	
	
	public String formataSaidaDaMatriz(){

		String saida=""; // Cria e inicializa uma String	
		for(int linha=0;linha<M.length;linha++){ //for para percorrer as linhas da matriz
			for(int coluna=0;coluna<M[0].length;coluna++){ //percorrer as colunas
                                //guardando na String cada elemento separado por um espaço
				saida= saida +M[linha][coluna] + " ";
			}
			saida = saida + "\n"; // Guarda uma quebra de linha na String
		}
		return saida; //retorna a String 
}



	public void adicionarNovaAresta(int x, int y)
	{	

		String novaAresta = ",{" + x + "," + y + "}";//concatena a nova aresta
		arestas += novaAresta;
		
		if(n < x || n < y)//evita de criar uma dimensao zerada na matriz atoa
		{
			if(x > y)
			{
				n += x - n;
			}
			else
			{
				n += y - n;
			}
		}
		M = new int[n][n];//inicia a nova matriz
		
		MatrizAdjacencia matriz = new  MatrizAdjacencia();
		matriz.lerGrafo(this);//monta a matriz adjacencia
		
		
	}
	
	public void removerAresta(int x, int y)

	{	
		String removerAresta = ",{" + x + "," + y + "}";
		arestas = arestas.replace(removerAresta, "");
		removerAresta = "{" + x + "," + y + "}";
		arestas = arestas.replace(removerAresta, "");
		
		M = new int[n][n];
		
		MatrizAdjacencia matriz = new  MatrizAdjacencia();
		matriz.lerGrafo(this);//monta a matriz adjacencia
	}

	public void retornarNosVizinhos(int x) {
		
		
		for(int linha=1;linha<(n+1);linha++){ //for para percorrer as linhas da matriz
			
			if(M[linha-1][x-1] == 1) {
				
				System.out.println("Nos vizinhos = " + linha);
			}

		}
	}

	public void adicionarVertice(int x) {
		

		String novoVertice = "," + x;//concatena o novo vertice
		linnhaArquivo += novoVertice;
		
		System.out.println(linnhaArquivo);
		M = new int[n+1][n+1];
		
		MatrizAdjacencia matriz = new  MatrizAdjacencia();
		matriz.lerGrafo(this);//monta a matriz adjacencia
	}
	
	public void removerVertice(int x) {
		

		for(int linha=0;linha<M.length;linha++){ //for para percorrer as linhas da matriz
			
			M[linha][x-1] = 0;
		}
		
		for(int coluna=0;coluna<M[0].length;coluna++){ //percorrer as colunas da matriz

			M[x-1][coluna] = 0;
				
		}
	}
	
}
