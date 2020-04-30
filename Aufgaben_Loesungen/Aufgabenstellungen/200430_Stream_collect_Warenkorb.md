# Aufgabe 'collect - Warenkorb'

Gegeben sind folgende Klassen:

		class Produkt {
			private String name;
			private int preis;
			
			// Konstruktoren und Methoden hier, wenn nötig...
		}
		
		class Bestellung {
			private String produktName;
			private int anzahl; // gewünschte Anzahl der Produkt-Objekte
			
			// Konstruktoren und Methoden hier, wenn nötig...
		}
		
> Weitere Hilfsklassen bzw. Hilfsmethoden können Sie gerne definieren.

###### A1.
Folgende Liste existiert:

		List<Produkt> warenkorb = new ArrayList<>();
		warenkorb.add(new Produkt("Brot", 129));
		warenkorb.add(new Produkt("Wurst", 230));
		warenkorb.add(new Produkt("Milch", 99));
		warenkorb.add(new Produkt("Milch", 99));

Definieren Sie eine Pipeline, die den Gesamtpreis aller Produkte im Warenkorb ermittelt.
Geben Sie das Ergebnis aus.

###### A2.

Folgende Liste existiert:

		List<Bestellung> bestellungen = new ArrayList<>();
		bestellungen.add(new Bestellung("Brot", 3));
		bestellungen.add(new Bestellung("Wurst", 1));
		bestellungen.add(new Bestellung("Milch", 2));

Definieren Sie eine Methode `buildWarenkorb`, die eine Liste der Bestellungen erhält und damit mithilfe einer Pipeline die Liste mit den bestellten Produkten erstellt:

		List<Produkt> warenkorb = buildWarenkorb(bestellungen);
		
> In der Liste 'warenkorb' sollen in diesem Beispiel 6 Produkte landen (3 X Brot, 1 X Wurst, 2 X Milch)
		
Die Preise für die zu erzeugende Produkte darf die Methode `buildWarenkorb` selbst (frei) bestimmen. 

###### A3. Optional. 
Die Preise für die zu erzeugende Produkte sucht die Methode `buildWarenkorb` in einer vordefinierten Map, wo jedem Produktnamen der Produktpreis zugeordnet wurde.

