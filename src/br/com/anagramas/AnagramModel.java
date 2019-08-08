package br.com.anagramas;

import java.util.*;

/**
 * This class finds all anagrams of a word. The word comes from a
 * view/controller via the process method of this class. Anagrams are
 * communicated back to the view. See the <code>process</code> method fo
 * rdetails.
 * 
 * @author ola
 * 
 */
public class AnagramModel extends AbstractModel {
	public List<Anaword> myWords;
	public List<Anaword> findedWords;
	
	public AnagramModel() {
		myWords = new ArrayList<Anaword>();
		findedWords = new ArrayList<Anaword>();
	}

	public void initialize(Scanner s) {
		setWords(s);
	}

	public void setWords(Iterator<String> words) {
		myWords = new ArrayList<Anaword>();
		while (words.hasNext()) {
			myWords.add(new Anaword(words.next()));
		}
	}

	public void process(Object o) {
		System.out.println("processing " + o);
		String s = (String) o;
		List<Anaword> matches = new ArrayList<Anaword>();
		Anaword candidate = new Anaword(s);
		for (Anaword word : myWords) {
			if (word.equals(candidate)) {
				matches.add(word);
			}
		}

		notifyViews(matches);
		if (matches.size() == 0) {
			messageViews("no anagrams found");
			System.out.println("no anagrams found");
		} else {
			messageViews(matches.size() + " anagrams found");
			System.out.println(matches.size());
			findedWords = matches;
		}
	}

	public int size() {
		return myWords == null ? 0 : myWords.size();
	}
}
