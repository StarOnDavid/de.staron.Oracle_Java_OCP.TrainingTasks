package _200429_Stream_Col_Personen;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Person implements Comparable<Person> {
	
	private String name;
	private String beruf;
	
	public Person(String name, String beruf) {
		this.name = name;
		this.beruf = beruf;
	}

	public String getBeruf() {
		return beruf;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return name + " ist " + beruf;
	}
	
	@Override
	public int compareTo(Person p2) {
		int erg = name.compareTo(p2.name);
		
		if(erg==0) {
			erg = beruf.compareTo(p2.beruf);
		}
		
		return erg;
	}
}

public class AufgabeCollectPersonen {

	public static void main(String[] args) {

		Person[] personen = {
				new Person("Tom", "Bauarbeiter(in)"),	
				new Person("Jerry", "Lehrer(in)"),	
				new Person("Peter", "Metzger(in)"),	
				new Person("Paul", "Bauarbeiter(in)"),	
				new Person("Mary", "Lehrer(in)"),	

//				new Person("Tom", "Schüler(in)"),	
			};

		a1(personen);
		a2(personen);
		a3(personen);
		a4(personen);
		a5(personen);
	}

	static void a5(Person[] personen) {
		System.out.println("*** A5");

		Map<Boolean, List<Person>> parts = 
				Arrays.stream(personen).collect(Collectors
						.partitioningBy(p -> p.getBeruf().equals("Bauarbeiter(in)")));
		
		System.out.println("true: " + parts.get(true));
		System.out.println("false: " + parts.get(false));
	}
	
	static void a4(Person[] personen) {
		System.out.println("*** A4");
		
		Map<String, List<Person>> groups = Arrays.stream(personen)
				.collect(Collectors.groupingBy(Person::getBeruf));
		
		BiConsumer<String, List<Person>> biConsumer = (beruf, listPerson) -> {
			System.out.println("* Beruf: " + beruf);
			System.out.println("** Personen: " + listPerson);
		};
		groups.forEach( biConsumer );
	}
		
	static void a3(Person[] personen) {
		System.out.println("*** A3");

		Collector<Person, ?, Set<String>> c1 = Collectors.mapping(Person::getBeruf, 
				Collectors.toSet());
		Collection<String> berufe = Arrays.stream(personen).collect(c1);
		
		System.out.println(berufe);
	}
	
	static void a2(Person[] personen) {
		System.out.println("*** A2");
		
		
		/*
		 * static <T, K, U>
         * 		Collector<T, ?, Map<K,U>> toMap(Function<? super T, ? extends K> keyMapper,
                           Function<? super T, ? extends U> valueMapper)
		 */
		
		Function<Person, String> keyMapper = Person::getName;
		Function<Person, Person> valueMapper = p -> p;
	    Collector<Person, ?, Map<String, Person>> c1 = Collectors.toMap(keyMapper, valueMapper);
	    
	    Map<String, Person> map = Arrays.stream(personen).collect(c1);
	    for(String name : map.keySet()) {
	    	System.out.println(name + ": " + map.get(name));
	    }
	}
	
	static void a1(Person[] personen) {
		System.out.println("*** A1");
		
		Collection<Person> set = Arrays.stream(personen)
				.collect(Collectors.toCollection(TreeSet::new));
		
		for (Person person : set) {
			System.out.println(person);
		}
		
	}
}
