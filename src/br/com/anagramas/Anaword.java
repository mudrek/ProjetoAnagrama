package br.com.anagramas;

import java.util.*;

/**
 * An <tt>Anaword</tt> object prints like a string but compares like a
 * sorted-sequence of characters This makes it useful for finding anagrams since
 * for example "pace" and "cape" both compare as "acep" so are equal for
 * purposes of Anagram-ness
 *
 * @see Comparable
 * @author Owen Astrachan
 */

public class Anaword implements Comparable<Anaword> {

	protected String myWord;
	protected String mySortedWord;

	/**
	 * construct an empty "" Anaword
	 */
	public Anaword() {
		myWord = "";
		mySortedWord = "";
	}

	/**
	 * construct Anaword from s
	 * 
	 * @param s is the string that the anaword prints as
	 */

	public Anaword(String s) {
		myWord = s;
		normalize();
	}

	/**
	 * @return the string used to construct the Anaword
	 */

	public String toString() {
		return myWord;
	}

	/**
	 * @return the number of characters in the Anaword
	 */

	public int length() {
		return myWord.length();
	}

	/**
	 * @param lhs is Anaword compared to this <code>Anaword</code>
	 * @return -1/0/1 based on canonical/sorted comparison of Anaword objects
	 * @exception <code>NullPointerException</code> if argument is null
	 */

	public int compareTo(Anaword lhs) {
		return mySortedWord.compareTo(lhs.mySortedWord);
	}

	public boolean equals(Object lhs) {
		if (lhs == null)
			return false;
		if (getClass() != lhs.getClass())
			return false;
		Anaword analhs = (Anaword) lhs;
		return mySortedWord.equals(analhs.mySortedWord);
	}

	public int hashCode() {
		return mySortedWord.hashCode();
	}

	protected void normalize() {
		char[] temp = myWord.toCharArray();
		Arrays.sort(temp);
		mySortedWord = new String(temp);
	}
}
