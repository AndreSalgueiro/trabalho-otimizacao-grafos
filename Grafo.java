//As alteracoes que fiz estao todas comentadas, a minha intencao com o metodo adicionarNovaAresta era acrescentar os valores
// 6 e 7 por exemplo como uma nova aresta. Mas quando eu acrescento eles a String e executo o codigo ele da erro de MatrixIndexOutBonds.
//Se eu alterar a primeira linha e acrescentar o 6 e 7 a mão o erro nao ocorre.
//Alem disso mudei o nome da String referente a segunda linha para linnaArquivo2



package MatrizAdjacencia;
import java.io.BufferedReader;
import java.io.IOException;

public class Grafo {
	BufferedReader lerArquivo;
	String arestas;
	String linnhaArquivo;
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
			String linnhaArquivo = lerArquivo.readLine();//lendo a primeira linha do arquivo
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
			arestas = linnhaArquivo2; //setando a variavel aresta que Ã© usado na classe MatrizAdjacencia

			//String novaAresta = ",{6,7}";
			//arestas = arestas.concat(novaAresta);
			//String novosVertices = ",6,7";
			//linnhaArquivo = linnhaArquivo.concat(novosVertices);
		}
		catch(IOException ex) {
			ex.getStackTrace();
		}
	}
	
	
	public String formataSaidaDaMatriz(){

		String saida=""; // Cria e inicializa uma String	
		for(int linha=0;linha<M.length;linha++){ //for para percorrer as linhas da matriz
			for(int coluna=0;coluna<M[0].length;coluna++){ //percorrer as colunas
                                //guardando na String cada elemento separado por um espaÃ§o
				saida= saida +M[linha][coluna] + " ";
			}
			saida = saida + "\n"; // Guarda uma quebra de linha na String
		}
		return saida; //retorna a String 
}


	//void adicionarNovaAresta() {
		
		//String novaAresta = ",{6,7}";
		//arestas = arestas.concat(novaAresta);
		//String novosVertices = ",6,7";
		//linnhaArquivo = linnhaArquivo.concat(novosVertices);
	
		//n = n+2;
		//m = m+1;
	
		//}
}
