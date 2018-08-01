package CaminhosMinimosDijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dijkstra {

	// Essa Lista guarda os vertices com menor caminho encontrado
	List<Vertice> menorCaminho = new ArrayList<Vertice>();

	// Variavel que recebe os vertices do menor caminho
	Vertice verticeCaminho = new Vertice();

	// Variavel que guarda o vertice que esta sendo visitado
	Vertice atual = new Vertice();

	// Variavel que marca o vizinho do vertice que esta sendo visitado
	Vertice vizinho = new Vertice();

	// Essa Lista guarda os vertices que ainda nao foram visitados
	List<Vertice> naoVisitados = new ArrayList<Vertice>();

	// Algoritmo de Dijkstra
	public List<Vertice> encontrarMenorCaminhoDijkstra(Grafo grafo, Vertice v1,
			Vertice v2) {

		int valorMenorCaminho = 0;
		
		// Adiciona a origem na lista do menor caminho
		menorCaminho.add(v1);

		// Seta as distancias iniciais, a origem tem distancia zero e todos os outros 9999(infinita)
		for (int i = 0; i < grafo.getVertices().size(); i++) {

			if (grafo.getVertices().get(i).getDescricao()
					.equals(v1.getDescricao())) {

				grafo.getVertices().get(i).setDistancia(0);

			} else {

				grafo.getVertices().get(i).setDistancia(9999);

			}
			// Carrega a lista vertices nao visitados
			this.naoVisitados.add(grafo.getVertices().get(i));
		}

		// O algoritmo roda ate que todos os vertices sejam visitados
		while (!this.naoVisitados.isEmpty()) {

			//obtem o vertice com a menor distancia que ainda não foi visitado
			atual = this.naoVisitados.get(0);
			for(int i = 1 ; i< naoVisitados.size(); i++) {
				
				if(!(atual.getDistancia() < naoVisitados.get(i).getDistancia())) {
					atual = this.naoVisitados.get(i);//u ← argmin { d[v] : v ∈ V(G) | não T[v] } 
				}
			}
			/*
			 * Para cada vizinho (cada aresta), calcula-se a sua possivel
			 * distancia, somando a distancia do vertice atual com a da aresta
			 * correspondente. Se essa distancia for menor que a distancia do
			 * vizinho, esta eh atualizada.
			 */
			for (int i = 0; i < atual.getArestas().size(); i++) {

				vizinho = atual.getArestas().get(i).getDestino();
				
				if (!vizinho.verificarVisita()) {//se não foi visitado

					// Comparando a distancia do vizinho com a possivel
					// distancia
					if (vizinho.getDistancia() > (atual.getDistancia() + atual //d[v] > d[vu]+d[u]
							.getArestas().get(i).getPeso())) {

						vizinho.setDistancia(atual.getDistancia()//d[v] <- d[vu] + d[u] 
								+ atual.getArestas().get(i).getPeso()); 
						vizinho.setPai(atual); //P[v] <- u
					}
				}

			}
			
			// Marca o vertice atual como visitado e o retira da lista de nao
			// visitados
			atual.visitar(); //T[u] ← V 
			this.naoVisitados.remove(atual);
			
		}
		
		/*
		 * Se o vizinho eh o vertice procurado, e foi feita uma
		 * mudanca na distancia, a lista com o menor caminho
		 * anterior eh apagada, pois existe um caminho menor
		 * vertices pais, ateh o vertice origem.
		 */
		
		if (atual == v2) {
			menorCaminho.clear();
			verticeCaminho = atual;
			
			//Soma os pesos das arestas que pertencem ao menor caminho possivel
			valorMenorCaminho = valorMenorCaminho + atual.getDistancia();
			
			menorCaminho.add(atual);
			while (verticeCaminho.getPai() != null) {

				menorCaminho.add(verticeCaminho.getPai());
				verticeCaminho = verticeCaminho.getPai();
				
			}
			// Ordena a lista do menor caminho, para que ele
			// seja exibido da origem ao destino.
			Collections.sort(menorCaminho);

		}
		System.out.println("\nEsse e o valor do menor caminho feito pelo algoritmo:"
				+ valorMenorCaminho+"\n");
		
		return menorCaminho;
	}

}