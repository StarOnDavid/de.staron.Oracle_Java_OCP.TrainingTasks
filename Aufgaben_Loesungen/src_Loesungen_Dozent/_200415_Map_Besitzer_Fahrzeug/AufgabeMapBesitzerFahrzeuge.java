package _200415_Map_Besitzer_Fahrzeug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AufgabeMapBesitzerFahrzeuge {

	public static void main(String[] args) {

		Person p1 = new Person("Peter", "M.");
		Person p2 = new Person("Paul", "N.");
		Person p3 = new Person("Mary", "O.");

		Fahrzeug f1 = new Fahrzeug("VW", "Golf");
		Fahrzeug f2 = new Fahrzeug("Opel", "Corsa");
		Fahrzeug f3 = new Fahrzeug("Mercedes", "A1");
		Fahrzeug f4 = new Fahrzeug("Mazda", "Z1");
		
		Map<Fahrzeug, Person> mapFahrzeuge = new HashMap<>();
		
		mapFahrzeuge.put(f1, p1);
		mapFahrzeuge.put(f2, p2);
		mapFahrzeuge.put(f3, p3);
		mapFahrzeuge.put(f4, p3);
		
		for( Map.Entry<Fahrzeug, Person> entry  : mapFahrzeuge.entrySet() ) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
		
		System.out.println("*** A3");
		
		Person person = mapFahrzeuge.get( new Fahrzeug("VW", "Golf") );
		System.out.println( "Person gefunden: " + person );  
		
		System.out.println("*** A4");
		
		Map<Person, List<Fahrzeug>> mapPersonen = new TreeMap<>();
		mapPersonen.put(p1, Arrays.asList(f1));
		mapPersonen.put(p2, Arrays.asList(f2));
		mapPersonen.put(p3, Arrays.asList(f3, f4));
		
		for( Person keyPerson : mapPersonen.keySet()) {
			List<Fahrzeug> valueFahrzeuge = mapPersonen.get(keyPerson);
			System.out.println(keyPerson + ": " + valueFahrzeuge);
		}
		
		System.out.println("*** A5");
		
		List<Fahrzeug> listFahrzeuge = mapPersonen.get( new Person("Mary", "O.") );
		
		System.out.println("Fahrzeuge gefunden: " + listFahrzeuge);
	}

}
