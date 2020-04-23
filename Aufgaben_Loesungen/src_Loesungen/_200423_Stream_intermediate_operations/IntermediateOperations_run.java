package _200423_Stream_intermediate_operations;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class IntermediateOperations_run {
	
	public static void main(String[] args) {
		runTasks();
		

	}
	
	private static void runTasks() {
		// A1
				List<Integer> listA1 = Arrays.asList(13, 15, 17, 19, 21);
				printAufgabe("1 - mittels for-loop",
						l -> { ImOps.a1for(listA1); });
				
				printAufgabe("1 - mittels Stream:", ImOps.a1Pipe(listA1),
						s -> s.forEach(System.out::println));
				
				// A2
				List<Integer> listA2 = Arrays.asList(1, 4, 7, 3, -8 );
				printAufgabe("2 - mittels for-loop",  
						l -> { ImOps.a2for(listA2); });
				
				printAufgabe("2 - mittels Stream:", ImOps.a2Pipe(listA2),
						s -> s.forEach(System.out::println));
				
				//A3
				List<String> listA3 = Arrays.asList("Tom", "Jerry", "Rex");
				printAufgabe("3 - mittels for-loop", 
						l -> { ImOps.a3for(listA3); });
				
				printAufgabe("3 - mittels Stream:", ImOps.a3Pipe(listA3),
						s -> s.forEach(System.out::println));
				
				//A4
				printAufgabe("4 - mittels Stream:", ImOps.a4Pipe(5),
						s -> s.forEach(System.out::println));
				
				//A5
				printAufgabe("5 - mittels Stream:", ImOps.a5Pipe(),
						s -> s.forEach(System.out::println));
				
				//A6
				printAufgabe("5 - mittels Stream:", ImOps.a6Pipe(),
						s -> s.forEach(System.out::println));
				
				
	}
	
	private static <T> void printAufgabe(String msg, Stream<T> s, Consumer<Stream<T>> co) {
		System.out.println("*** Aufgabe " + msg);
		co.accept(s);
		System.out.println();
	}
	
	private static void printAufgabe(String msg, Consumer<List<Integer>> co) {
		System.out.println("*** " + msg);
		co.accept(null);
		System.out.println();
	}

}
