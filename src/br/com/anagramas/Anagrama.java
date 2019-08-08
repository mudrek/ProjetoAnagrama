package br.com.anagramas;

import java.util.ArrayList;
import java.util.List;

public class Anagrama {

	public static void main(String[] args) {
		AnagramModel modelo = new AnagramModel();
		
		List<String> palavras = new ArrayList<String>();
		palavras.add("opts");
		palavras.add("post");
		palavras.add("poss");
		palavras.add("tsop");
		modelo.setWords(palavras.iterator());
		
		String palavra = "pots";
		modelo.process(palavra);
		
		System.out.println("Anagramas encontrados: ");
		List<Anaword> palavrasEncontradas = modelo.findedWords;
		for(Anaword temp : palavrasEncontradas) {
			System.out.println(temp.myWord);
		}
	}

}
