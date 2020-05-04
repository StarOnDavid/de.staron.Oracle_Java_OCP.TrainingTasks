package _200430_Collect_Warenkorb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AufgabeCollectWarenkorb {
	public static void main(String[] args) {
//		a1();
		a2();
	}
	
	static Map<String, Integer> mapPreise = new HashMap<>();
	
	static {
		mapPreise.put("Brot", 129);
		mapPreise.put("Wurst", 230);
		mapPreise.put("Milch", 99);
	}
	
	static List<Produkt> buildWarenkorb(List<Bestellung> bestellungen) {
		return bestellungen.stream()
				.flatMap( bestellung -> {
					String name = bestellung.getProduktName();
					int anzahl = bestellung.getAnzahl();
					int preis = mapPreise.get(name);
					return Stream.generate( () -> new Produkt(name, preis) ).limit(anzahl);
				})
				.collect(Collectors.toList());
	}

	static void a2() {
		System.out.println("*** A2");
		
		List<Bestellung> bestellungen = new ArrayList<>();
		bestellungen.add(new Bestellung("Brot", 3));
		bestellungen.add(new Bestellung("Wurst", 1));
		bestellungen.add(new Bestellung("Milch", 2));
		
		List<Produkt> warenkorb = buildWarenkorb(bestellungen);
		
		System.out.println("* Produkte: ");
		for(Produkt p : warenkorb) {
			System.out.println(p);
		}
	}
		
	static void a1() {
		System.out.println("*** A1");
		
		List<Produkt> warenkorb = new ArrayList<>();
		warenkorb.add(new Produkt("Brot", 129));
		warenkorb.add(new Produkt("Wurst", 230));
		warenkorb.add(new Produkt("Milch", 99));
		warenkorb.add(new Produkt("Milch", 99));
		
		warenkorb.stream()
					.map(Produkt::getPreis)
					.reduce((a, b)->a+b)
					.ifPresent( preis -> System.out.println("Gesamtpreis: " + preis) ); // 557
				
	}

}
