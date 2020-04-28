package _200427_Stream_TextStats;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class AufgabeTextStatistics {

	public static void main(String[] args) {
		
		/*
		 * A1.
		 * 
		 * Definieren Sie und Testen Sie die Klasse 'TextStatisticsImpl', 
		 * die das Interface 'TextStatistics' implementiert.
		 */
		
		String[] input = {
			"a b",
			"a $ b",
			"Heute ist Montag",
			""
			//...
		};
		
		for(String text : input) {
			System.out.println("** Text: '" + text + "'");
			TextStatistics stats = new TextStatisticsImpl(text);
			printStatistics(stats);
			//...
		}
		
		/*
		 * A2
		 * 
		 * Verwenden Sie alle überladenen Varianten der Stream-Methode `reduce`
		 * um mit jeder Variante die `TextStatistics` für ein Stream von Texten 
		 * (Strings) zu erhalten. So z.B. könnten die Tests aussehen:
		 * 
		 */
		BinaryOperator<TextStatistics> acc1 = (stats1, stats2) -> {
			return new TextStatisticsCombined(stats1, stats2);
		};
		
		System.out.println("*** A2.1");
		TextStatistics stats1 = Arrays.stream(input)
					// .map( (Function<String, TextStatistics>) (s -> new TextStatisticsImpl(s)) )
					.<TextStatistics>map( s -> new TextStatisticsImpl(s) )
					.reduce(acc1)
					.get();
		// Ergebnisse präsentieren...
		printStatistics(stats1);
		

		System.out.println("*** A2.2");
		TextStatistics stats2 = Arrays.stream(input)
					.<TextStatistics>map( s -> new TextStatisticsImpl(s) )
					.reduce(new TextStatisticsImpl(""), acc1);
		// Ergebnisse präsentieren...
		printStatistics(stats2);
		
		
		System.out.println("*** A2.3");
		TextStatistics idt = new TextStatisticsImpl("");
		BiFunction<TextStatistics, String, TextStatistics> acc = (statsA, text) -> {
			TextStatistics statsB = new TextStatisticsImpl(text);
			return new TextStatisticsCombined(statsA, statsB);
		};
		BinaryOperator<TextStatistics> cmb = TextStatisticsCombined::new;
		
		TextStatistics stats3 = Arrays.stream(input).reduce(idt, acc, cmb);
		// Ergebnisse präsentieren...
		printStatistics(stats3);
		
		System.out.println("Kontrolle getCountChars: " + 
				Arrays.stream(input).map(String::length).reduce(0, (len1, len2) -> len1+len2));
	} // end of main
	
	
	static void printStatistics(TextStatistics stats) {
		System.out.println("getCountChars: " + stats.getCountChars());
		System.out.println("getCountWords: " + stats.getCountWords());
		System.out.println("getCountSpecialChars: " + stats.getCountSpecialChars());
		System.out.println("getCountLetters: " + stats.getCountLetters());
		stats.getLongestWord()
				.ifPresentOrElse(w -> System.out.println("getLongestWord: '" + w + "'"),
						() -> System.out.println("Kein Wort gefunden"));
		
	}
}
