package _200427_TextStats;

import java.util.Optional;

public interface TextStatistics {

	/**
	 * @return Liefert die Gesamtanzahl der Zeichen
	 */
	int getCountChars();
	
	/**
	 * 
	 * @return Liefert die Anzahl der Sonderzeichen (Zeichen die weder Ziffern noch Buchstaben sind)
	 */
	int getCountSpecialChars();
	
	
	/**
	 * 
	 * @return Liefert die Anzahl der Buchstaben
	 */
	int getCountLetters();
	
	/**
	 * 
	 * @return Liefert die Anzahl der Wörter. Wörter können aus beliebigen Zeichen 
	 * (auch Sonderzeichen) bestehen und werden von Leerzeichen von einander getrennt.
	 * 
	 *  Tipp: "dieser Text hat 5 Wörter".split(" ")
	 */
	int getCountWords();
	
	
	/**
	 * 
	 * @return Liefert das längste Wort in einem Optional. 
	 * Für leere zu untersuchenden Texte liefert Empty Optional
	 */
	Optional<String> getLongestWord();
	
	//...
	
}
