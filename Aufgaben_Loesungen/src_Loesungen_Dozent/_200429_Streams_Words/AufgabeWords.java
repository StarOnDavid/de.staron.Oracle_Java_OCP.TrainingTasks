package _200429_Streams_Words;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import _200429_Project_Words_funkt_Streams.Words;

public class AufgabeWords {

	public static void main(String[] args) {
		
		List<String> words = Words.englishWords();
		
		System.out.println("*** A1");
		
		long count = words.stream().filter(s->s.length() > 5).count();
		System.out.println("Wörter länger als 5: " + count);
		
		System.out.println("*** A2");
		
		Optional<String> maybeMin = words.stream().filter(s -> s.charAt(0)=='m').min(Comparator.naturalOrder());
		System.out.println("Kleinster String auf 'm': " + maybeMin.get());
		
		System.out.println("*** A3");
		
		words.stream().skip(20).limit(10).forEach(System.out::println);

		System.out.println("*** A4");
		
		boolean result = words.stream().anyMatch( s -> s.contains("ooo") );
		System.out.println("Ein String mit 'ooo' gefunden: " + result);
		
		
		System.out.println("*** A5");
		LinkedList<String> abaWords = words.stream()
				.filter(s -> s.contains("aba"))
				.collect( Collectors.toCollection(LinkedList::new) );
		
		System.out.printf("Wörter mit aba (%d): %s %n", abaWords.size(), abaWords);
		
		System.out.println("*** A6");
		
		List<String> passwords = Words.passwords();
		
		//evtl. ist anyMatch-Lösung schneller
		Optional<String> maybePassword = passwords.stream()
											.filter(s -> s.equals("qwerty")).findFirst();
		
		maybePassword.ifPresent(s -> System.out.println("Passwort gefunden: " + s));
		
		System.out.println("*** A7");
		
		Function<String, Integer> classifier = String::length;
		Map<Integer, List<String>> groups = words.stream().collect( Collectors.groupingBy(classifier) );
		
		System.out.println("Englische Wörter nach längen gruppiert: ");
		for(Map.Entry<Integer, List<String>> group : groups.entrySet()) {
			System.out.println("Länge " + group.getKey() + ", Anzahl: " + group.getValue().size());
		}
		
		System.out.println("Das Wort mit Länge 22: " + groups.get(22));
		System.out.println("Die Wörter mit Länge 2: " + groups.get(2));
		
		System.out.println("*** A8.1");

		Collector<String, ?, Long> downstream = Collectors.counting();
		Collector<String, ?, Map<Integer, Long>> c1 = Collectors.groupingBy(s -> s.length(), downstream); 
		Map<Integer, Long> counters = words.stream().collect(c1);
		
		for(Map.Entry<Integer, Long> group : counters.entrySet()) {
			System.out.println("Länge: " + group.getKey() + ", Anzahl: " + group.getValue());
		}
		
		System.out.println("*** A8.2");
		
		ToIntFunction<String> mapper = s -> 1;
		Collector<String, ?, Integer> downstream2 = Collectors.summingInt(mapper);
		Collector<String, ?, Map<Integer, Integer>> c2 = Collectors.groupingBy(s -> s.length(), downstream2); 
		
		Map<Integer, Integer> counters2 = words.stream().collect(c2);
		
		for(Map.Entry<Integer, Integer> group : counters2.entrySet()) {
			System.out.println("Länge: " + group.getKey() + ", Anzahl: " + group.getValue());
		}
	}

}
