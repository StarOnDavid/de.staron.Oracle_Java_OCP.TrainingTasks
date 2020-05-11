package _200430_Stream_collect_Collectors_Autos;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class CarCollectors {
	private static List<Car> cars = Arrays.asList(
									new Car("VW", "Golf"),
									new Car("VW", "Polo"),
									new Car("Opel", "Corsa"),
									new Car("Opel", "Astra")
								); 

	public static void main(String[] args) {
//		a1();
//		a2();
//		a3();
//		a4();
		a5();

	}

	private static void a5() {
		
		Collector<Car, ?, Map<Boolean, List<Car>>> collector = 
				Collectors.partitioningBy(
						c -> c.getModel().contains("o"),
						Collectors.toList()
				);
		
		Map<Boolean, List<Car>> map = cars.stream().collect(collector);
		System.out.println(map);
		
	}

	private static void a4() {
		
//		Function<Car, String> classifier = Car::getBrand;
//		
//		Function<Car, String> mapper = Car::getModel;
//		
//		Collector<String, ?, Set<String>> downstreamList = Collectors.toCollection(TreeSet::new);
//		
//		Collector<Car, ?, Set<String>> downstream = Collectors.mapping(mapper , downstreamList);
//		
//		Supplier<Map<String, Set<String>>> mapFactory = TreeMap::new;
//		
//		Collector<Car, ?, Map<String, Set<String>>> collector = Collectors.groupingBy(classifier, mapFactory , downstream);
		
		/*
		 * Oder knapp zusammen gefasst:
		 */
		Collector<Car, ?, Map<String, Set<String>>> collector =
				Collectors.groupingBy(
						Car::getBrand, 
						TreeMap::new, 
						Collectors.mapping(
								Car::getModel, 
								Collectors.toCollection(TreeSet::new)
						)
				);

		Map<String, Set<String>> map = cars.stream().collect(collector);
		System.out.println(map); 
		// Ausgabe: {Opel=[Opel/Corsa, Opel/Astra], VW=[VW/Golf, VW/Polo]}
	}

	private static void a3() {
		// Möglich in einer Zeile -> schlecht lesbar
		Map<String, List<String>> map = cars.stream().collect(Collectors.groupingBy(Car::getBrand, Collectors.mapping(Car::getModel, Collectors.toList()) ));
		
		/*
		 * Hier das ganze zerlegt in Collector(en) und Function(s):
		 */
//		Function<Car, String> classifier = Car::getBrand;
//		
//		Function<Car, String> mapper = Car::getModel;
//		
//		Collector<String, ?, List<String>> downstreamList = Collectors.toList();
//		
//		Collector<Car, ?, List<String>> downstream = Collectors.mapping(mapper , downstreamList);
//		
//		Collector<Car, ?, Map<String, List<String>>> collector = Collectors.groupingBy(classifier, downstream );
//		
//		Map<String, List<String>> map = cars.stream().collect(collector);
		
		System.out.println(map); 
		// mögliche Ausgabe: {VW=[Golf, Polo], Opel=[Corsa, Astra]}
	}

	private static void a2() {
		
		Function<Car, String> classifier = c -> c.getBrand();
		Collector<Car, ?, Map<String, List<Car>>> collector = Collectors.groupingBy(classifier );
		
		Map<String, List<Car>> map = cars.stream().collect(collector);
		System.out.println(map); 
		// mögliche Ausgabe: {VW=[VW/Golf, VW/Polo], Opel=[Opel/Corsa, Opel/Astra]}
	}

	private static void a1() {
		Collector<String, ?, Set<String>> downstream = Collectors.toSet();
		
		Function<Car, String> mapper = c -> c.getBrand();
		Collector<Car, ?, Set<String>> collector 
				= Collectors.mapping(mapper, downstream);
		
		Set<String> set = cars.stream().collect(collector);
		System.out.println(set); // mögliche Ausgabe: [VW, Opel]
	}

}
