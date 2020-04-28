package _200427_TextStats;

import java.util.Arrays;
import java.util.Optional;

public class TextStatisticsImpl implements TextStatistics{
	String text;
	
	public TextStatisticsImpl(String text) {
		this.text = text;
	}

	/**
	 * @return Liefert die Gesamtanzahl der Zeichen
	 */
	@Override
	public int getCountChars() {
		return text.length();
	}
	
	/**
	 * 
	 * @return Liefert die Anzahl der Sonderzeichen (Zeichen die weder Ziffern noch Buchstaben sind)
	 */
	@Override
	public int getCountSpecialChars() {														// Besser lesbar wöre 
		return (int) this.text.chars().filter(c -> !(c > 64 && c < 91)) // Großbuchstaben 	// c -> Character.isLetter(c)
									.filter(c -> !(c > 96 && c < 123)) 	// Kleinbuchstaben
									.filter(c -> !(c > 47 && c < 58))	// Zahlen			// c -> Character.isDigit(c)
									.count();
	}
	
	
	/**
	 * 
	 * @return Liefert die Anzahl der Buchstaben
	 */
	@Override
	public int getCountLetters() {
		return (int) this.text.chars().filter(c -> (c > 64 && c < 91) || (c > 96 && c < 123)).count();
		// besser lesbar:
		//			 this.text.chars().filter(c -> Character.isLetter(c)).count();
	}
	
	/**
	 * 
	 * @return Liefert die Anzahl der Wörter. Wörter können aus beliebigen Zeichen 
	 * (auch Sonderzeichen) bestehen und werden von Leerzeichen von einander getrennt.
	 * 
	 *  Tipp: "dieser Text hat 5 Wörter".split(" ")
	 */
	@Override
	public int getCountWords() {
		return this.text.split(" ").length;
	}
	
	/**
	 * 
	 * @return Liefert das längste Wort in einem Optional. 
	 * Für leere zu untersuchenden Texte liefert Empty Optional
	 */
	public Optional<String> getLongestWord() {
		Optional<String> result = Arrays.stream(this.text.split(" ")).max((a, b) -> Integer.compare(a.length(), b.length()));
		if(result.isPresent() && result.get().length() == 0) {
			return Optional.empty();
		}
		return result;
	}

}
