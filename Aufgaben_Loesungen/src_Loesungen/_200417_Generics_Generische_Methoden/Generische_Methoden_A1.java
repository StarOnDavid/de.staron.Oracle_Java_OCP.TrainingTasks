package _200417_Generics_Generische_Methoden;

import java.util.Date;

public class Generische_Methoden_A1 {
	
	private static <P extends Comparable<P>> P getMax(P a, P b) {
		int res = a.compareTo(b);
		return (res == 1 ? a : b);
	}

	public static void main(String[] args) {
		String s = getMax("abc", "def"); // getMax liefert "def"
		System.out.println("getMax(\"abc\", \"def\") liefert: " + s);
		
		Integer i = getMax(14, 12); // getMax liefert Integer mit 14
		System.out.println("getMax(14, 12) liefert " + i);

		Date d = getMax(new Date(), new Date(0)); // getMax liefert das spätere Datum
		System.out.println("getMax(new Date(), new Date(0)) liefert: " + d);

//		getMax("hallo", 22); // hier soll ein Compilerfehler entstehen
	}

}
