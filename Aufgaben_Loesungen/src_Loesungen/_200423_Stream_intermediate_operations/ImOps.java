package _200423_Stream_intermediate_operations;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ImOps {
	
	protected static void a1for(List<Integer> l){
		for(Integer x : ((List<Integer>) l)) {
			if(x==15 || x==19) {
				System.out.println("Treffer: " + x);
			}
		}
	}
	
	protected static Stream<Object> a1Pipe(List<Integer> l) {
		Stream<Object> str = l.stream()
								.filter(x -> x==15 || x==19)
								.map(x -> "Treffer: " + x);
		return str;
	}
	
	protected static void a2for(List<Integer> l){
		for (Integer x : l) {
			System.out.println( x%2==0 ? "gerade" : "ungerade" );
		}
	}
	
	protected static Stream<Object> a2Pipe(List<Integer> l) {
		Stream<Object> str = l.stream()
								.map(x -> x%2==0 ? "gerade" : "ungerade" );
		return str;
	}
	
	protected static void a3for(List<String> l){
		for(String name : l) {
			Tier t = new Tier(name);
			System.out.println(t);
		}
	}
	
	protected static Stream<Object> a3Pipe(List<String> l) {
		Stream<Object> str = l.stream()
								.map(n -> new Tier(n));
		return str;
	}
	
	protected static Stream<Double> a4Pipe(int numOf) {
		return Stream.generate(() -> (-20) + (int)(Math.random() * ((20 - (-20)) + 1)))
									.filter(x -> x > -10 || x < -15)
									.map(x -> x.doubleValue())
									.limit(numOf);
	}
	
	protected static Stream<Tier> a5Pipe() {
		List<Tier> tiere = Arrays.asList(	new Tier("Rex"),
				new Tier("Tom"),
				new Tier("Jerry"),
				new Tier("Tom"),
				new Tier("Jerry"));
		
		return tiere.stream().distinct();
	}
	
	protected static Stream<String> a6Pipe() {
		List<String> mailsErsthelfer = Arrays.asList("tom@mycompany.com", "jerry@mycompany.com");
		List<String> mailsIT = Arrays.asList("tom@mycompany.com", "mary@mycompany.com");
		List<String> mailsQM = Arrays.asList("peter@mycompany.com", "jerry@mycompany.com");
		
		return Stream.<List<String>>of( mailsErsthelfer, mailsIT, mailsQM ) // Stream<Integer[]>
						.flatMap( List::stream )
						.map(s -> s.substring(0, s.indexOf("@")))
						.distinct();	
	}
}
