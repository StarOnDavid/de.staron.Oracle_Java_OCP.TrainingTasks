package _200420_MiniTask_MethodenReferenz;

import java.util.Formatter;
import java.util.Locale;
import java.util.function.BiConsumer;

class PrintFormatted {
	public static void trimAndPad(String s, Integer padTo) {
		System.out.println(String.format("%"+ padTo + "s", s.trim()));
	}
}

public class MethodenReference {

	public static void main(String[] args) {
		
		BiConsumer<String,Integer> bc = PrintFormatted::trimAndPad;
		
		bc.accept("                   Hallo, MetRef!", 20);
		
	}

}
