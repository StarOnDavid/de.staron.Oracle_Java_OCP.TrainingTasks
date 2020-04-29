package _200429_Stream_collect_Collectors_Personen;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class B22_Collectors_partitioningBy {
	
	static boolean isVokalGruppe(String s) {
		char ch = s.toLowerCase().charAt(0);
		
		switch (ch) {
			case 'o':
			case 'u':
			case 'i':
			case 'e':
			case 'a':
			case 'ä':
			case 'ö':
			case 'ü':
				return true;
		}
		
		return false;
	}

	public static void main(String[] args) {

		String[] array = { "oben", "vorne", "unten", "hinten" };

		System.out.println("** wdh. mit groupingBy: ");
		Function<String, Boolean> classifier = s -> isVokalGruppe(s);
		Collector<String, ?, Map<Boolean, List<String>>> c1 = Collectors.groupingBy(classifier);
		
		Map<Boolean, List<String>> gruppen = Arrays.stream(array).collect(c1);

		System.out.println("Vokalen-Gruppe: " + gruppen.get(true));
		System.out.println("Konsonanten-Gruppe: " + gruppen.get(false));
		
		System.out.println("** mit partitioningBy, Version 1: ");
		
		Predicate<String> predicate = s -> isVokalGruppe(s);
		Collector<String, ?, Map<Boolean, List<String>>> c2 = Collectors.partitioningBy(predicate);
		Map<Boolean, List<String>> partitions = Arrays.stream(array).collect(c2);
		
		System.out.println("Vokalen-Partition: " + partitions.get(true));
		System.out.println("Konsonanten-Partition: " + partitions.get(false));
		
		System.out.println("** mit partitioningBy, Version 2: ");
		
		Collector<String, ?, TreeSet<String>> downstream = Collectors.toCollection(TreeSet::new);
		
		Collector<String, ?, Map<Boolean, TreeSet<String>>> c3 
				= Collectors.partitioningBy(predicate, downstream);
		
		Map<Boolean, TreeSet<String>> partitions2 = Arrays.stream(array).collect(c3);
		System.out.println("Vokalen-Partition: " + partitions2.get(true));
		System.out.println("Konsonanten-Partition: " + partitions2.get(false));
		
	}

}
