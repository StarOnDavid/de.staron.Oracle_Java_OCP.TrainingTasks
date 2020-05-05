package _200430_collect_Collectors_Auto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AufgabeCollectCollectorsAutos {

	public static void main(String[] args) {
		List<Auto> autos = Arrays.asList(
				new Auto("VW", "Golf"),
				new Auto("VW", "Polo"),
				new Auto("Opel", "Corsa"),
				new Auto("Opel", "Astra")
			);

		a1(autos);
		a2(autos);
		a3(autos);
		a4(autos);
		a5(autos);
	}
	
	static void a5(List<Auto> autos) {
		System.out.println("*** A5");
		
		Map<Boolean, List<Auto>> parts = autos.stream()
				.collect(Collectors.partitioningBy( a -> a.getModell().contains("o") ));
		
		System.out.println("parts: " + parts);
	}
	
	static void a4(List<Auto> autos) {
		System.out.println("*** A4");
		
		Map<String, List<Auto>> map = autos.stream()
				.collect( Collectors.groupingBy(Auto::getHersteller, TreeMap::new,
						Collectors.toList()) );
		System.out.println(map); 
		// Ausgabe: {Opel=[Opel/Corsa, Opel/Astra], VW=[VW/Golf, VW/Polo]}
	}
		
	static void a3(List<Auto> autos) {
		System.out.println("*** A3");

		Function<Auto, String> classifier = Auto::getHersteller;
		
		Function<Auto, String> mapperAutos = Auto::getModell;
		
		Collector<String, ?, List<String>> downstreamStrings = Collectors.toList();
		
		Collector<Auto, ?, List<String>> downstream = Collectors.mapping(mapperAutos, downstreamStrings);
		
		Collector<Auto, ?, Map<String, List<String>>> collector = Collectors.groupingBy(classifier, downstream);
		
		Map<String, List<String>> map = autos.stream().collect(collector);
		System.out.println(map); 
		// mögliche Ausgabe: {VW=[Golf, Polo], Opel=[Corsa, Astra]}
		
		/*
		 * Exam-Notation
		 */
		Map<String, List<String>> map2 = autos.stream()
				.collect(Collectors.groupingBy(Auto::getHersteller,
						Collectors.mapping(Auto::getModell, Collectors.toList())));
	}
	
	static void a2(List<Auto> autos) {
		System.out.println("*** A2");

		Function<Auto, String> classifier = Auto::getHersteller;
		
		Collector<Auto, ?, Map<String, List<Auto>>> collector = Collectors.groupingBy(classifier);
		
		Map<String, List<Auto>> map = autos.stream().collect(collector);
		System.out.println(map); 
		// mögliche Ausgabe: {VW=[VW/Golf, VW/Polo], Opel=[Opel/Corsa, Opel/Astra]}
	}
	
	static void a1(List<Auto> autos) {
		System.out.println("*** A1");
		
		Collector<String, ?, Set<String>> downstream = Collectors.toSet();
		
		Function<Auto, String> mapper = Auto::getHersteller;
		
		Collector<Auto, ?, Set<String>> collector 
				= Collectors.mapping(mapper, downstream);
		
		Set<String> set = autos.stream().collect(collector);
		System.out.println(set); // mögliche Ausgabe: [VW, Opel]
	}

}
