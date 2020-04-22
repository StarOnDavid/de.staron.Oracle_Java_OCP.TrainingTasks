package _200422_Stream_bilden;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

class Test {
    static Integer nextInt() {
        return new Random().nextInt();
    }
}

public class Stream_bilden {
	private List<Integer> list1 = Arrays.asList( 1, 2, 3 );
	private List<Integer> list2 = Arrays.asList( 55, 77 );
	private String[] a1 = { "a", "b" };
	private String[] a2 = { "c", "d" };
	
	@SuppressWarnings("unused")
	private void a1_for() {		
		List<List<Integer>> list3 = Arrays.asList(list1, list2);
		for(List<Integer> e : list3) {
		    System.out.println("size = " + e.size() + ". elements = " + e);
		}
	}

	@SuppressWarnings("unused")
	private void a1_pipe() {
		Stream<Object> str = Stream.of(list1, list2).map(e -> (String) "size = " + e.size() + ". elements = " + e);
		str.forEach(System.out::println);
	}
	
	@SuppressWarnings("unused")
	private void a2_for(int numOf) {
		for (int i = 1; i < numOf+1; i++) {
            System.out.println( Test.nextInt() );
        }
	}
	
	@SuppressWarnings("unused")
	private void a2_pipe(int numOf) {
		Stream<Integer> str = Stream.generate(Test::nextInt).limit(numOf);
		str.forEach(System.out::println);;
	}
	
	@SuppressWarnings("unused")
	private void a3_for(int numOf) {
		for (int i = numOf; i >= 1; i--) {
		    System.out.println( i );
		}
	}
	
	@SuppressWarnings("unused")
	private void a3_pipe(int numOf) {
		Stream<Integer> str = Stream.iterate(numOf, n -> n-1).limit(numOf);
		str.forEach(System.out::println);
	}
	
	@SuppressWarnings("unused")
	private void a4_for() {
		String[][] a3 = { a1, a2 };
	    for (String[] arr : a3) {
	        for (String s : arr) {
	            System.out.println(s);
	        }
	    }
	}
	
	@SuppressWarnings("unused")
	private void a4_pipe() {
		Stream<String> str1 = Stream.of(a1);
		Stream<String> str2 = Stream.of(a2);
		Stream<String> str3 = Stream.concat(str1, str2);
		str3.forEach(System.out::println);
	}
	
	@SuppressWarnings("unused")
	private void a5_for() {
		Collection<Path> coll = new ArrayList<>();
		coll.add(Paths.get("/a"));
		coll.add(Paths.get("/a/b"));
		coll.add(Paths.get("/a/b/c"));
		coll.add(Paths.get("/a/b/c/d"));
		for(Path p : coll) {
			System.out.println(p);
		}
	}
	
	@SuppressWarnings("unused")
	private void a5_pipe() {
		Stream.Builder<Path> builder =  Stream.builder();
		Stream<Path> str = builder.add(Paths.get("/a"))
									.add(Paths.get("/a/b"))
									.add(Paths.get("/a/b/c"))
									.add(Paths.get("/a/b/c/d"))
									.build();
		str.forEach(System.out::println);
	}
}
