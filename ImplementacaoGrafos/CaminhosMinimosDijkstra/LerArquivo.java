package CaminhosMinimosDijkstra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.swing.JTextField;

@SuppressWarnings("unused")
public class LerArquivo {

	public List<Vertice> lerGrafo(String nomeArquivo) {

		Grafo g = new Grafo();
		Vertice v;
		File f = new File(nomeArquivo);
		String vertices[];
		String linha;
		ArrayList<String[]> s1 = new ArrayList<String[]>();

		try {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(f));

			Map<String, Vertice> mapa = new HashMap<String, Vertice>();
			//Carrega do arquivo os vertices com seus respectivos pesos e arestas
			while ((linha = br.readLine()) != null) {

				if (linha.contains(",")) {
					s1.add(linha.split("/"));
					vertices = s1.get(0)[0].split(",");

					v = (Vertice) mapa.get(vertices[0]);
					if (v == null)
						v = new Vertice();

					List<Vertice> vizinhosAtual = new ArrayList<Vertice>();
					List<Aresta> arestasAtual = new ArrayList<Aresta>();
					v.setDescricao(vertices[0]);
					mapa.put(vertices[0], v);

					if (linha.contains("/")) {

						String pesoArestas[] = s1.get(0)[1].split(",");

						for (int i = 1; i < vertices.length; i++) {
							Vertice vit;
							vit = mapa.get(vertices[i]);
							if (vit == null)
								vit = new Vertice();
							vit.setDescricao(vertices[i]);
							vizinhosAtual.add(vit);
							mapa.put(vertices[i], vit);

							Aresta ait = new Aresta(v, vit);
							ait.setPeso(Integer.parseInt(pesoArestas[i - 1]));
							arestasAtual.add(ait);

						}
						v.setVizinhos(vizinhosAtual);
						v.setArestas(arestasAtual);

					}

				}

				// Vertices finais
				else {

					v = (Vertice) mapa.get(linha);
					if (v == null)
						v = new Vertice();
					v.setDescricao(linha);
					mapa.put(linha, v);

				}

				g.adicionarVertice(v);
				s1.clear();

			}

			
		} catch (FileNotFoundException e) {
			System.out.println("Nao encontrou o arquivo");
			e.printStackTrace();
		}
		// catch do readLine
		catch (IOException e) {
			e.printStackTrace();
		}
		//Retornando os vertices
		return g.getVertices();
	}

	

}