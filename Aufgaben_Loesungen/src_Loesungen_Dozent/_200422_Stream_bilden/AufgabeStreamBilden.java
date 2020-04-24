package _200422_Stream_bilden;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class AufgabeStreamBilden {

	static Integer nextInt() {
        return new Random().nextInt();
    }
	
	public static void main(String[] args) {
//		a1();
//		a2();
//		a3();
		a4();
	}

	static void a4() {
		System.out.println("*** A4");

		String[] a1 = { "a", "b" };
        String[] a2 = { "c", "d" };
        
        System.out.println("* ohne Streams");
        // A
        String[][] a3 = { a1, a2 };
        for (String[] arr : a3) {
            for (String s : arr) {
                System.out.println(s);
            }
        }
        // B
        
        System.out.println("* mit Streams V1:");
        
        Stream.of(a1, a2).forEach( array -> {
        	for(String s : array) {
        		System.out.println(s);
        	}
        } );
        
        System.out.println("* mit Streams V2:");
        
        Stream.concat( Stream.of(a1), Stream.of(a2) ).forEach(System.out::println);
        
	}
	
	static void a3() {
		System.out.println("*** A3");

		int start = 5;
		
		System.out.println("* ohne Streams");
		for (int i = start; i >= 1; i--) {
		    System.out.println( i );
		}
		
		System.out.println("* mit Streams");
		Stream.iterate(start, x -> x-1)
				.limit(start)
				.forEach(System.out::println);
	}
	
	static void a2() {
		System.out.println("*** A2");

		int max = 4;
		
		System.out.println("* ohne Streams");
		
		for (int i = 1; i < max; i++) {
            System.out.println( nextInt() );
        }
		
		System.out.println("* mit Streams");
		
//		Stream.generate(() -> nextInt()).limit(max-1).forEach(System.out::println); // OK
		
		Stream.generate( AufgabeStreamBilden::nextInt )
				.limit(max-1)
				.forEach(System.out::println);
	}	
	
	static void a1() {
		System.out.println("*** A1");
		
		List<Integer> list1 = Arrays.asList( 1, 2, 3 );
		List<Integer> list2 = Arrays.asList( 55, 77 );
		
		
		System.out.println("* ohne Streams");
		
		// A
		List<List<Integer>> list3 = Arrays.asList(list1, list2);
		for(List<Integer> e : list3) {
		    System.out.println("size = " + e.size() + ". elements = " + e);
		}
		// B
		
		System.out.println("* mit Streams");
				
		Stream.of(list1, list2)
				.forEach( e -> System.out.println("size = " + e.size() + ". elements = " + e) );
	}
}
