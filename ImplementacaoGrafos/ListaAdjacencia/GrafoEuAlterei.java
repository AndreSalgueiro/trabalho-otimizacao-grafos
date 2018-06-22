package ListaAdjacencia;

import java.io.BufferedReader;

public class Grafo {
	BufferedReader lerArquivo;
	int n, m;
	NoAresta[] L;
	String arestas;

	public Grafo(BufferedReader lerArquivo){
		this.lerArquivo = lerArquivo;
		obterDimensaoLista(lerArquivo);
		L = new NoAresta[n];
   }
	public void obterDimensaoLista(BufferedReader lerArquivo){
		int qntVertices = 0, qntArestas = 0;
		
		try {
			String linha = lerArquivo.readLine();//ler primeira linha do arquivo que sao os vertices
			
			System.out.println(linha + "\n");//imprimindo os vertices do grafo
			
			//Obtendo qntd de vertices
			for(int i = 0; i < linha.length(); i++) { 				
				if(Character.isDigit(linha.charAt(i))) {//se for digito entao e o vertice logo incrementa o contador de vertices 	
					qntVertices++;	  
				}
			}
			
			n = qntVertices; 
			linha = lerArquivo.readLine();//lendo segunda linha do arquivo que sao as arestas
			
			System.out.println(linha + "\n");//imprimindo as arestas do grafo
			
		  	//Obtendo qntd de arestas  
			for(int i = 0; i < linha.length(); i++) { 				
				if(Character.isDigit(linha.charAt(i))) { 	
					qntArestas++;  	  
				}
			}
			
			m = qntArestas/2;
			arestas = linha; //setando a variavel aresta que e usada na classe ListaAdjacencia 
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
	  	  
