package _200415_MiniTask_Map;

import java.util.*;

class Dozent2 implements Comparable<Dozent2> {
	private String name;

	public Dozent2(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if( !(obj instanceof Dozent2) ) {
			return false;
		}
		
		Dozent2 d2 = (Dozent2)obj;
		return name.equals(d2.name);
	}
	
	@Override
	public int compareTo(Dozent2 d2) {
		return name.compareTo(d2.name);
	}
}

public class KleineAufgabeMap {

	public static void main(String[] args) {
		
		// Dozent hat einen Namen (Klasse 'Dozent' nötig).
		// Einem Dozenten soll in einer Map eine Liste seine Kurse zugeordnet werden.
		// Ein Kurs in der Liste ist ein String (z.B. "Java", "C++", "Kochen"...)
		
		// Bilden Sie eine Map mit 2-3 Einträgen.
		// Jeder Dozent in der Map soll 2-3 Kurse zugeordnet bekommen.
		
		// Map<Dozent, List<String>> map = new HashMap<>();
		Map<Dozent2, List<String>> map = new TreeMap<>();

		List<String> kurse = new ArrayList<>();
		kurse.add("Java SE");
		kurse.add("Java EE");
		
		map.put(new Dozent2("Peter"), kurse);
		map.put(new Dozent2("Paul"), Arrays.asList("Kochen", "Tauchen"));
		map.put(new Dozent2("Mary"), List.of("C++", "C#", "C"));
		
		// Bitte die Einträge der Map danach untereinander ausgeben
		System.out.println("** map:");
		
		for(Map.Entry<Dozent2, List<String>> entry : map.entrySet()) {
			System.out.println(entry);
		}
		
		System.out.println("**************");
		boolean result = map.containsKey(new Dozent2("Peter"));
		
		System.out.println("Peter gefunden: " + result); // true
		
		List<String> kurseVonPeter = map.get(new Dozent2("Peter"));
		System.out.println("Seine Kurse: " + kurseVonPeter);
		
	}

}
