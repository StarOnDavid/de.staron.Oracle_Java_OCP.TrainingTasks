package _200423_Stream_ntermediate_operations;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class AufgabeIntermediateOperations {

	static class Tier {
		private String name;

		public Tier(String name) {
			this.name = name;
		}
		public String toString() {
			return "Tier " + name;
		}
		
		@Override
		public boolean equals(Object obj) {
			return ((Tier)obj).name.equals(name); 
		}
		
		@Override
		public int hashCode() {
			return name.hashCode();
		}
	}
	
	public static void main(String[] args) {
//		a1();
//		a2();
//		a3();
//		a4();
//		a5();
		a6();
	}

	static void a6() {
		System.out.println("*** A6");
		
		List<String> mailsErsthelfer = Arrays.asList("tom@mycompany.com", "jerry@mycompany.com");
		List<String> mailsIT = Arrays.asList("tom@mycompany.com", "mary@mycompany.com");
		List<String> mailsQM = Arrays.asList("peter@mycompany.com", "jerry@mycompany.com");
		
		Stream.of(mailsErsthelfer, mailsIT, mailsQM)
			//.flatMap( list -> list.stream() )
			.flatMap( List::stream )
			.map( s -> s.substring(0, s.indexOf('@')) )
			.distinct()
			// .sorted()
			.forEach(System.out::println);
	}
		
	static void a5() {
		System.out.println("*** A5");
		
		Tier[] array = {
				new Tier("Rex"),
				new Tier("Tom"),
				new Tier("Jerry"),
				new Tier("Tom"),
				new Tier("Jerry"),
			};
		
		Arrays.stream(array)
				.distinct()
				.forEach(System.out::println);
	}
	
	static void a4() {
		System.out.println("*** A4");
		
//	 	- 30 Zufallswerte im Bereich [-20 ... 20] generiert (s. Stream.generate),
//	    - dann die negativen Werte aus dem Bereich [-15 ... -10] ausfiltert (weg wirft),
//	    - dann die durchgekommenen Werte in Double umwandelt
//	    - dann die Double-Werte ausgibt
		Random random = new Random();
		Stream.generate( () -> random.nextInt(41)-20 )
				.filter( x -> x < -15 || x > -10 )
				.map(Double::new)
				.limit(20)
				.forEach(System.out::println);
	}
		
	static void a3() {
		System.out.println("*** A3");
		
		List<String> list = Arrays.asList("Tom", "Jerry", "Rex");
		
		System.out.println("** ohne Streams");
		//A
		for(String name : list) {
			Tier t = new Tier(name);
			System.out.println(t);
		}
		//B
		
		System.out.println("** mit Streams");
		
		list.stream()
				//.map(name -> new Tier(name))
				.map(Tier::new) 
				.forEach(System.out::println);
	}
		
	static void a2() {
		System.out.println("*** A2");
		
		Integer[] array = { 1, 4, 7, 3, -8 };
		
		System.out.println("** ohne Streams");
		//A
		for (Integer x : array) {
			System.out.println( x%2==0 ? "gerade" : "ungerade" );
		}
		//B		
		
		System.out.println("** mit Streams");
		
		Arrays.stream(array)
				.map(x -> x%2==0 ? "gerade" : "ungerade")
				.forEach(System.out::println);
	}
		
	static void a1() {
		System.out.println("*** A1");
		
		List<Integer> list = Arrays.asList(13, 15, 17, 19, 21);
		
		System.out.println("** ohne Streams");
		// A
		for(Integer x : list) {
			if(x==15 || x==19) {
				System.out.println("Treffer: " + x);
			}
		}
		// B
		
		System.out.println("** mit Streams");
		list.stream()
				.filter( x -> x==15 || x==19 )
				.forEach( x -> System.out.println("Treffer: " + x) );
		
	}
}
