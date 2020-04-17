package _200417_Generics_Generische_Methoden;

import java.util.function.Supplier;

class IntPositive {

	private static <T extends RuntimeException> void checkAndThrow(boolean check, Supplier<T> s) throws T {	
		if(!check) {
			throw s.get();
		}
	}

	void setValue(int value) {
		checkAndThrow(value>0, IllegalArgumentException::new);
	}	
	
	void writeValue(int value) {
//		checkAndThrow(value>0, java.io.IOException::new); // Compilerfehler !!! 
	}
}

public class Generische_Methoden_A2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
