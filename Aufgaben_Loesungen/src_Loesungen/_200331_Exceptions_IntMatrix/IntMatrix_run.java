package _200331_Exceptions_IntMatrix;

import _200331_Exceptions_IntMatrix.IntMatrix.IntMatrixIndexOutOfBoundsException;
import _200331_Exceptions_IntMatrix.IntMatrix.IntMatrixNotAddOrSubableException;
import _200331_Exceptions_IntMatrix.IntMatrix.IntMatrixNotMultipliableException;
import _200331_Exceptions_IntMatrix.IntMatrix.IntMatrixRandomInitException;
import _200331_Exceptions_IntMatrix.IntMatrix.IntMatrixSizeException;

public class IntMatrix_run {

	public static void main (String... args) {
		IntMatrix m1 = new IntMatrix(2, 3);
		
		IntMatrix m2 = new IntMatrix(5, 3, 100);
		
		System.out.println("IntMatrix m1 is 'empty':");
		System.out.println(m1);
		
		System.out.println("\nIntMatrix m2 init with 100:");
		System.out.println(m2);
		
		IntMatrix m3 = IntMatrix.getRandomMatrix(2, 3, 5);
		
		System.out.println("\nIntMatrix m3 init random:");
		System.out.println(m3);
		
		System.out.println("\nIntMatrix m3 added with m3:");
		System.out.println(m3.add(m3));
		
		System.out.println("\nIntMatrix m3 subtracted with m3:");
		System.out.println(m3.sub(m3));
		
		System.out.println("\nIntMatrix m3 transposed:");
		System.out.println(m3.transposed());
		
		System.out.println("\nIntMatrix m3 multiplied with m3 transposed:");
		System.out.println(m3.multiply(m3.transposed()));
		
		System.out.println("\nIntMatrix m3 transposed multiplied with m3:");
		System.out.println(m3.transposed().multiply(m3));
		
		IntMatrix m4 = new IntMatrix(5, 3, 200);
		IntMatrix m5 = IntMatrix.getRandomMatrix(5, 3, 200);
		IntMatrix m6 = new IntMatrix(5, 3, 100);
		System.out.println("\nIntMatrix 'm2' sameSize as IntMatrix 'm4': " + m2.sameSize(m4));
		System.out.println("IntMatrix 'm2' sameSize as IntMatrix 'm5': " + m2.sameSize(m5));
		System.out.println("IntMatrix 'm2' sameSize as IntMatrix 'm6': " + m2.sameSize(m6));
		System.out.println("IntMatrix 'm2' sameSize as IntMatrix 'm1': " + m2.sameSize(m1));
		
		System.out.println("\nIntMatrix 'm2' equals IntMatrix 'm4': " + m2.equals(m4));
		System.out.println("IntMatrix 'm2' equals IntMatrix 'm5': " + m2.equals(m5));
		System.out.println("IntMatrix 'm2' equals IntMatrix 'm6': " + m2.equals(m6));
		
		try {
		IntMatrix m7 = new IntMatrix(5, 0, 100);
		} catch (IntMatrixSizeException e){
			System.out.println("\nm7 - Exception: " + extractExceptionName(e.getClass().toString()) + " : " + e.getMessage());
		}
		
		try {
			IntMatrix m8 = IntMatrix.getRandomMatrix(4, 6, 0);
		} catch (IntMatrixRandomInitException e){
			System.out.println("\nm8 - Exception: " + extractExceptionName(e.getClass().toString()) + " : " + e.getMessage());
		}
		
		/*
		 * FRAGE:
		 * Bei der ArrayOutOfBoundsException wird die 'length' des Array angegeben vom Array dessen Aufruf die Exception auslöst.
		 * Wie kommt diese Exception Klasse an die länge des Array?
		 * 
		 * Antwort: 
		 * der Index-Operator ist eine Art 'Funktion', die den Code beinhaltet, in dem der Operand (das Array) überprüft wird: 
		 * die Länge des Arrays wird ermittelt und mit dem zweiten Operanden (index) verglichen. Falls index zu gross ist, wirft der 
		 * Index-Operator die ArrayIndexOutOfBoundExc. Somit muss die Exception-Klasse kein Zugriff auf das Array haben.
		 */
		
		try {
			m5.get(5, 3);
		} catch (IntMatrixIndexOutOfBoundsException e){
			System.out.println("\nm5.get(5, 3) - Exception: " + extractExceptionName(e.getClass().toString()) + " : " + e.getMessage());
		}
		
		try {	
			m1.add(m2);
		} catch (IntMatrixNotAddOrSubableException e){
			System.out.println("\nm1.add(m2) - Exception: " + extractExceptionName(e.getClass().toString()) + " : " + e.getMessage());
		}
		
		try {	
			m1.sub(m2);
		} catch (IntMatrixNotAddOrSubableException e){
			System.out.println("\nm1.sub(m2) - Exception: " + extractExceptionName(e.getClass().toString()) + " : " + e.getMessage());
		}
		
		try {	
			m2.multiply(m3);
		} catch (IntMatrixNotMultipliableException e){
			System.out.println("\nm2.multipliedWith(m3) - Exception: " + extractExceptionName(e.getClass().toString()) + " : " + e.getMessage());
		}
		
		
			
	}
	
	private static String extractExceptionName(String s) {
		return s.substring(s.indexOf("$")+1);
	}
}
