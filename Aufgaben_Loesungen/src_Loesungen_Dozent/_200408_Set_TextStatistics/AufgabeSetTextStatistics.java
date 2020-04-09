package _200408_Set_TextStatistics;


import java.util.Collection;

public class AufgabeSetTextStatistics {

	public static void main(String[] args) {
		
		TextStatistics stat = TextStatistics.of("Heute ist Montag!");

		Collection<Character> chars = stat.getUniqueChars();
		
		System.out.println(chars);
	}

}
