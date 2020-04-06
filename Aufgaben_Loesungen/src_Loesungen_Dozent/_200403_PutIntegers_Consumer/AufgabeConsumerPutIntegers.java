package _200403_PutIntegers_Consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class AufgabeConsumerPutIntegers {

	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();
		putIntegers( i -> sb.append(i).append(" ") );
		System.out.println(sb); 	// Zeile A

		//Function<Integer, Object> c1 = i -> sb.append(i).append(" ");
		// Consumer<Integer> c1 = i -> sb.append(i).append(" ");
		
		List<Integer> list = new ArrayList<>();
		putIntegers( i -> list.add(i) );
		System.out.println(list); // Zeile B

		//Function<Integer, Object> c2 = i -> list.add(i);
		// Consumer<Integer> c2 = i -> list.add(i);
		
		putIntegers( System.out::print ); 	// Zeile C, optionale Aufgabe, 
											// die Zeile C kann entfernt werden
	}

	static void putIntegers(Consumer<Integer> c) {
		for (int i = 1; i < 5; i++) {
			c.accept(i);
		}
	}
	
}
