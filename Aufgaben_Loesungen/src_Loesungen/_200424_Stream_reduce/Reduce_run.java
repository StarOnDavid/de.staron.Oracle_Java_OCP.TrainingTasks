package _200424_Stream_reduce;

import java.util.Arrays;

public class Reduce_run {
	private static String[] items = { "aa", "bbb", "cccc", "ddddd" };
	
	public static void main(String[] args) {
//		a1();
		a2();
	}

	private static void a2() {
		Arrays.stream(items)
			// Habe reduce mit drei Parameter bis jetzt nicht ganz verstanden
			// .reduce(0, (a, b) -> a.length() + b.length())
		;
		
	}

	private static void a1() {
		int lengthOfAll = Arrays.stream(items)
												.map(x -> x.length())
												.reduce(0, (a, b) -> a + b);
		
		System.out.println("'Items' enthällt insgesammt " + lengthOfAll + " 'Chars'.");
		
	}
}
