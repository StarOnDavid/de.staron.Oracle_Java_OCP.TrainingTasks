package _200429_Project_Words_funkt_Streams;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordsStreams {
	private static List<String> enWords = Words.englishWords();
	private static List<String> passwords = Words.passwords();
	
	public static void main(String[] args) {
//		a1(enWords, "Wördter länger als 5 Buchstaben aus der Liste 'enWords': ");
//		a1(passwords, "Wördter länger als 5 Buchstaben aus der Liste 'passwords': ");
		
//		a2(enWords);
//		a2(passwords);
		
//		a3(enWords);
//		a3(passwords);
		
//		a4(enWords);
//		a4(passwords);
		
//		a5(enWords);
//		a5(passwords);
		
//		a6(passwords, "snakeshit");
		
//		a7(enWords);
//		a7(passwords);
		
		a8(enWords);
	}

	private static void a8(List<String> list) {
		Function<String, Integer> classifier = s -> s.length(); 
		
		/*
		 * downstream-Collector beschreibt das Sammeln der Elemente einer Gruppe
		 */
		Collector<String, ?, Long> downstream = Collectors.counting();
		
		/*
		 * groupingBy-Collector aus der Version 2
		 *  übernimmt die Logik des downstream-Collectors beim Sammeln Elemente einer Gruppe
		 */
		Collector<String, ?, Map<Integer, Long>> collector = 
			Collectors.groupingBy(classifier, downstream);
		
		Map<Integer, Long> groups = list.stream()
									.collect(collector);

		for(Map.Entry<Integer, Long> group : groups.entrySet()) {
			System.out.println(group);
		}
		
	}

	private static void a7(List<String> list) {
		
		Function<String, Integer> classifier = s -> s.length();
		Collector<String, ?, Map<Integer, List<String>>> collector = Collectors.groupingBy(classifier);
		
		Map<Integer, List<String>> grpLength = list.stream().collect(collector);
		
		for (Map.Entry<Integer, List<String>> entry : grpLength.entrySet()) {
			System.out.println(entry);
		}
	}

	private static void a6(List<String> list, String pwd) {
		boolean gibtEs = list.stream().anyMatch(s -> s == pwd);
		
		System.out.println("'passwords' enthält '" + pwd + "': " + gibtEs);
		
	}

	private static void a5(List<String> list) {
		
		LinkedList<String> list_aba = list.stream()
									.filter(s -> s.contains("aba"))
									.collect( Collectors.toCollection(LinkedList::new) );
		System.out.println(list_aba);
	}

	private static void a4(List<String> list) {
		boolean gibtEs = list.stream().anyMatch(s -> s.contains("ooo"));
		
		System.out.println("Es gibt einen String der 'ooo' enthält: " + gibtEs);
	}

	private static void a3(List<String> list) {
		Stream.iterate(1, x -> x + 1)
		.skip(20)
		.limit(10)
		.forEach(x -> System.out.println(list.get(x)));
	}

	private static void a2(List<String> list) {
		BinaryOperator<String> accumulator = (a, b) -> {
														int comp = a.compareTo(b);
														return comp < 0 ? a : b;
														};
		
		Optional<String> smallestWith_m = list.stream()
									.filter(w -> w.charAt(0) == 'm')
									.reduce(accumulator);
		System.out.println("Der lexikografisch kleinsten String der mit 'm' beginnt: " + smallestWith_m.get());
	}

	private static void a1(List<String> list, String message) {
		long count = list.stream()
						.filter(w -> w.length() > 5)
						.count();
		System.out.println(message + count);
	}

}
