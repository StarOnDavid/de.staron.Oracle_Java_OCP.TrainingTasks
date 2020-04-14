package _200409_Set_Abfahrtzeiten;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class AufgabeSetAbfahrtzeiten {

	public static void main(String[] args) {

		List<String> listAbfahrtzeiten = getAbfahrtzeiten();

		TreeSet<String> abfahrtzeiten = new TreeSet<String>(listAbfahrtzeiten);
		
		System.out.println("ALLE: " + abfahrtzeiten);

		System.out.println("suchen Sie die erste Abfahrtzeit nach 12:03: " + abfahrtzeiten.higher("12:03"));
		System.out.println("suchen Sie nach der ersten Abfahrtzeit vor 12:03: " + abfahrtzeiten.lower("12:03"));
	
		System.out.println("suchen Sie nach der ersten Abfahrtzeit nach 17:12 inklusive: " 
				+ abfahrtzeiten.ceiling("17:12"));
		System.out.println("suchen Sie nach der ersten Abfahrtzeit nach 17:12 exklusive: " 
				+ abfahrtzeiten.higher("17:12"));
		
		System.out.println("suchen Sie nach allen Abfahrtzeiten zwischen 12:00 bis 13:00: " 
				+ abfahrtzeiten.subSet("12:00", "13:00"));
		
		System.out.println("suchen Sie nach allen Abfahrtzeiten zwischen 11:52 exklusive bis 13:12 inklusive: " 
				+ abfahrtzeiten.subSet("11:52", false, "13:12", true));
		
		System.out.println("erste / letzte: " + abfahrtzeiten.first() + " / " + abfahrtzeiten.last());
	}
	
	static List<String> getAbfahrtzeiten() {
		
		List<String> list = new ArrayList<>();
		
		for (int stunde = 6; stunde < 24; stunde++) {
			for (int minute = 12; minute < 60; minute+=20) {
				String zeit = String.format("%02d:%02d", stunde, minute);
				list.add(zeit);
			}
		}
		
		return list;
	}

}
