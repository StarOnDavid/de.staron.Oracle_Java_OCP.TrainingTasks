package _200417_Generics_Generische_Methoden;

import java.util.Collection;
import java.util.List;

public class Generische_Methoden_A3 {
	
	@SuppressWarnings("unchecked")
	public static <N extends Number> N sum(Collection<N> zahlen) {
		Double sum = 0.0;
		
		for(N zahl : zahlen) {	   
		   sum += zahl.doubleValue();
		}
		
		return (N) sum; // das ist so bestimmt nicht die richtige Lösung! 
	}

	public static void main(String[] args) {
		List<Integer> listInt = List.of(1,32,60,7);
		
		System.out.println(sum(listInt));

	}

}
