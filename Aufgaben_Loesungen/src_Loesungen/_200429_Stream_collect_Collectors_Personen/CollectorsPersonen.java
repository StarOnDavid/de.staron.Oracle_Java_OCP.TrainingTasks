package _200429_Stream_collect_Collectors_Personen;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectorsPersonen {
	private static Person[] persons = {
				new Person("Tom", "Bauarbeiter(in)"),	
				new Person("Jerry", "Lehrer(in)"),	
				new Person("Peter", "Metzger(in)"),	
				new Person("Paul", "Bauarbeiter(in)"),	
				new Person("Mary", "Lehrer(in)"),	
			};

	public static void main(String[] args) {
//		a1();
//		a2();
//		a3();
//		a4();
		a5();
	}

	private static void a5() {
		Predicate<Person> predicate = p -> p.getJob() == "Bauarbeiter(in)";
		Collector<Person, ?, Map<Boolean, List<Person>>> collector = Collectors.partitioningBy(predicate);
		Map<Boolean, List<Person>> bauarbeiter = Arrays.stream(persons).collect(collector);
		
		System.out.println("Ist Bauarbeiter: " + bauarbeiter.get(true));
		System.out.println("Ist Bauarbeiter kein: " + bauarbeiter.get(false));
	}

	private static void a4() {
		Function<Person, String> classifier = p -> p.getJob();
		
		Collector<Person, ?, Map<String, List<Person>>> collector = Collectors.groupingBy(classifier);
		
		Map<String, List<Person>> groups = Arrays.stream(persons).collect(collector);
		
		for(Map.Entry<String, List<Person>> group : groups.entrySet()) {
			System.out.println(group);
		}
	}

	private static void a3() {
		
		Function<Person, String> mapper = p -> p.getJob();
		
		Collector<String, ?, HashSet<String>> collector = Collectors.toCollection(HashSet::new);
		
		Set<String> jobs = Arrays.stream(persons)
								.map(mapper)
								.collect(collector);
		
		for (String job : jobs) {
			System.out.println(job);
		}
		
	}

	private static void a2() {
		/*
		 * die Function beschreibt das umwandeln des Inhalt für den Map-Key
		 */
		Function<Person, String> classifier = p -> p.getJob(); 
		
		/*
		 * downstream-Collector beschreibt das Sammeln der Elemente einer Gruppe
		 */
		Collector<Person, ?, TreeSet<Person>> downstream = Collectors.toCollection(TreeSet::new);
		
		/*
		 * groupingBy-Collector 
		 * übernimmt die Logik des downstream-Collectors beim Sammeln Elemente einer Gruppe
		 */
		Collector<Person, ?, Map<String, TreeSet<Person>>> collector = 
			Collectors.groupingBy(classifier, downstream);
		
		Map<String, TreeSet<Person>> groups = Arrays.stream(persons).collect(collector);

		for(Map.Entry<String, TreeSet<Person>> group : groups.entrySet()) {
			System.out.println(group);
		}
		
	}

	private static void a1() {
		
		Collector<Person, ?, TreeSet<Person>> collector = Collectors.toCollection(TreeSet::new);		
		TreeSet<Person> persSet = Arrays.stream(persons).collect(collector);
		
		for (Person person : persSet) {
			System.out.println(person);
		}
	}
}
