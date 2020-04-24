package _200424_MiniTask_Stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class Stream_anyAllMatch {

	public static void main(String[] args) {
		String[] woche = {
				"Montag",
				"Dienstag",
				"Mittwoch",
				"Donnerstag",
				"Freitag",
				"Samstag",
				"Sonntag"
		};
		/*
		 * Überprüfen sie bitte mit einer Pipeline
		 * 
		 * - ob es im Array 'woche' Strings gibt, die länger als 8 sind
		 * - ob alle Strings ein kleines 't' enthalten
		 * - ob kein String mit 'A' startet
		 * 
		 */
		
		Stream<String> laengerA = Stream.of(woche)
				.filter(x -> x.length() > 8);
		
		long anz = laengerA.count();
		System.out.println("In Woche gibt es " + anz + " String(s) der/die mehr als 8 Zeichen haben.");
		
		boolean gibtMitMehrAlsAcht = Stream.of(woche)
				.anyMatch(s -> s.length() > 8);
		System.out.println("In Woche gibt es Strings die mehr als 8 Zeichen haben: "+ gibtMitMehrAlsAcht);
		
		boolean mit_t = Stream.of(woche).allMatch(s -> s.contains("t"));
		System.out.println("In Woche enthalten alle Strings ein 't': "+ mit_t);
		
		boolean startNotWithA = Stream.of(woche).allMatch(s -> s.charAt(0) != 'A');
		System.out.println("In Woche beginnt kein String mit 'A': "+ startNotWithA);

		
		
	}
}
