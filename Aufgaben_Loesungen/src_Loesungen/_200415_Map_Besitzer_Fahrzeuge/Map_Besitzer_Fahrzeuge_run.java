package _200415_Map_Besitzer_Fahrzeuge;

import java.util.*;

public class Map_Besitzer_Fahrzeuge_run {

	public static void main(String[] args) {
		
		// A1
		Owner p1 = new Owner("Grant", "MacLaren");
		Owner p2 = new Owner("Marcy", "Warton");
		Owner p3 = new Owner("Carly", "Shannon");
		
		Vehicle v1 = new Vehicle("911 GT3 RS", "Porsche");
		Vehicle v2 = new Vehicle("P1", "McLaren");
		Vehicle v3 = new Vehicle("Mustang Shelby GT500", "Fort");
		Vehicle v4 = new Vehicle("Challenger SRT Hellcat", "Dodge");
		
		//A2
		Map<Vehicle, Owner> vo = new TreeMap<>();
		vo.put(v1, p1);
		vo.put(v2, p3);
		vo.put(v3, p2);
		vo.put(v4, p2);
		
		// A3
		System.out.println("Der "+ v1 + " gehört: " + vo.get(v1));
		
		// A4
		Map<Owner, List<Vehicle>> ov = new TreeMap<>();
		ov.put(p1, List.of(v1));
		ov.put(p2, List.of(v3, v4));
		ov.put(p3, List.of(v2));
		
		// A5
		System.out.println(p2 + " gehören die folgenden Autos: " + ov.get(p2)  );
		
	}
}
