package _200409_Set_Abfahrtzeiten;

import java.util.SortedSet;
import java.util.TreeSet;

public class Departures_run {

	public static void main(String[] args) {
		TreeSet<String> depts = Departures.generateAsString(6,12,23,52,20);
//		System.out.println(depts);
		
		System.out.println("Departure times from 06:12 to 23:52 were generated in 20 minute intervals");
		
		System.out.println("\nErste Abfahrtzeit nach 12:03 ist: " + depts.higher("12:03"));
		System.out.println("\nErste Abfahrtzeit vor 12:03 ist: " + depts.lower("12:03"));
		
		System.out.println("\nErste Abfahrtzeit nach 17:12 (inklusive) ist: " + depts.ceiling("17:12"));
		System.out.println("\nErste Abfahrtzeit nach 17:12 (exklusive) ist: " + depts.higher("17:12"));
		
		SortedSet<String> b12a13 = depts.subSet("12:00", "13:00");
		System.out.println("\nAllen Abfahrtzeiten zwischen 12:00 bis 13:00 sind: " + withoutSquareBrackets(b12a13.toString()) );
		
		SortedSet<String> b1152a1312 = depts.subSet("11:52", false, "13:12", true);
		System.out.println("\nAllen Abfahrtzeiten zwischen 11:52 exklusive bis 13:12 inklusive sind: " + withoutSquareBrackets(b1152a1312.toString()) );
		
		System.out.println("\nErst mögliche Abfahrtzeit am Tag: " + depts.first());
		
		System.out.println("\nLetzt mögliche Abfahrtzeit am Tag: " + depts.last());
				
	}

	private static String withoutSquareBrackets (String in) {
		int l = in.length();
		return in.substring(1, l-1);
	}
}
