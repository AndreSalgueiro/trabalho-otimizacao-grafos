package BuscaGrafos;

import java.util.ArrayList;

public class Pilha {
	private ArrayList<Object> pilha = new ArrayList<Object>();
	
	
	public void empilha(Object item) {
		pilha.add(item);		
	}
	public Object desempilha() {
		Object retorno = null;
		
		if(pilha.size() > 0) {
		retorno = pilha.get(pilha.size()-1);
		pilha.remove(pilha.size()-1);
		}
		return retorno;
	}
	
	public int tamanho() {
		
		return pilha.size();
	}

}

