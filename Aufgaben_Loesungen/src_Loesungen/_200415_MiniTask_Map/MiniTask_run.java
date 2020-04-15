package _200415_MiniTask_Map;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MiniTask_run {

	public static void main(String[] args) {
		Map<Dozent, List<String>> dwl = new TreeMap<>();
		
		dwl.put(new Dozent("Herbert"), List.of("JavaOCA", "JavaOCP", "C++ Basics"));
		dwl.put(new Dozent("Giesela"), List.of("Projekt Managment SCRUM", "Rechnungswesen", "Team Building"));
		dwl.put(new Dozent("Jonny"), List.of("SQL", "PL/SQL"));
		
		//System.out.println(dwl);
		for(Map.Entry<Dozent, List<String>> d : dwl.entrySet()) {
			System.out.println(String.format("%7s: %s", d.getKey(), d.getValue()));
		}
	}

}
