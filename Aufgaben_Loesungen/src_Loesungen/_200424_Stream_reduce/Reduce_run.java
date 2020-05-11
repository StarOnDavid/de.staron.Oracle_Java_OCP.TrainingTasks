package _200424_Stream_reduce;

import java.util.Arrays;

@SuppressWarnings("unused")
public class Reduce_run {
	private static String[] items = { "aa", "bbb", "cccc", "ddddd" };
	
	public static void main(String[] args) {
//		a1();
		a2();
	}

	private static void a2() {
		Integer ident = 0;
		Integer sumLength = Arrays.stream(items)
				.parallel()
				.reduce(ident, (a, b) -> a += b.length(), (x,y) -> x+y );
		System.out.println("'Items' enthällt insgesammt " + sumLength + " 'Chars'.");
	}

	private static void a1() {
		int lengthOfAll = Arrays.stream(items)
												.map(x -> x.length())
												.reduce(0, (a, b) -> a + b);
		
		System.out.println("'Items' enthällt insgesammt " + lengthOfAll + " 'Chars'.");
		
	}
}
