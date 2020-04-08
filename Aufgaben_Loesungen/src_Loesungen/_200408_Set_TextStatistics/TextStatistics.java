package _200408_Set_TextStatistics;

import java.util.Collection;
import java.util.HashSet;

public class TextStatistics {
	String text;

	public static TextStatistics of(String text) {
		TextStatistics obj = new TextStatistics();
		obj.text = text;
		return obj;
	}
	
	public HashSet<Character> getUniqueChars() {
		HashSet<Character> uniqueChars = new HashSet<>();
		for(int i = 0; i < text.length(); i++) {
			uniqueChars.add(text.charAt(i));
		}
		return uniqueChars;
	}
	
	// only for Testing;
	public static void main(String[] args) {
		TextStatistics stat = TextStatistics.of("Heute ist Montag!");
		Collection<Character> chars = stat.getUniqueChars();
		System.out.println(chars);
	}
}
