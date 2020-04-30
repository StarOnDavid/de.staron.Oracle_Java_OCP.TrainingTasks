# Aufgabe 'collect, Collectors - Autos'

Gegeben ist die Klasse:

	public class Auto {
		private String hersteller, modell;
		public Auto(String hersteller, String modell) {
			this.hersteller = hersteller;
			this.modell = modell;
		}
		public String getHersteller() { return hersteller; }
		public String getModell() { return modell; }
		
		public String toString() { return hersteller + "/" + modell; }
	}

und folgende Liste:

	List<Auto> autos = Arrays.asList(
					new Auto("VW", "Golf"),
					new Auto("VW", "Polo"),
					new Auto("Opel", "Corsa"),
					new Auto("Opel", "Astra")
				);

###### A1. mapping
Gegeben ist auch noch der folgender Collector `downstream`:
 
		Collector<String, ?, Set<String>> downstream = Collectors.toSet();

Benötigt wird dazu ein Collector, der Autos einer Pipeline zu Hersteller-Strings umwandelt und aus diesen Strings ein `Set` bildet. Realisieren Sie diesen Collector mit der Methode `mapping`:

		Collector<Auto, ?, Set<String>> collector 
			= Collectors.mapping(mapper, downstream);

Dabei ist `mapper` die `Function` die bestimmt, wie ein Auto in ein String umgewandelt wird.

Testen Sie bitte die Lösung: 

		Set<String> set = autos.stream().collect(collector);
		System.out.println(set); // mögliche Ausgabe: [VW, Opel]


###### A2. groupingBy
Realisieren Sie den Collector `collector` so, dass folgender Code eine Map erzeugt, in der als Schlüssel der Hersteller-String und als Wert die Liste mit __Autos__ von diesem Hersteller erscheinen:

	Map<String, List<Auto>> map = autos.stream().collect(collector);
	System.out.println(map); 
	// mögliche Ausgabe: {VW=[VW/Golf, VW/Polo], Opel=[Opel/Corsa, Opel/Astra]}



###### A3. groupingBy
Realisieren Sie den Collector `collector` so, dass folgender Code eine Map erzeugt, in der als Schlüssel der Hersteller-String und als Wert die Liste der __Modell-Strings__ von diesem Hersteller erscheinen:

	Map<String, List<String>> map = autos.stream().collect(collector);
	System.out.println(map); 
	// mögliche Ausgabe: {VW=[Golf, Polo], Opel=[Corsa, Astra]}


###### A4. groupingBy
Realisieren Sie den Collector `collector` so, dass folgender Code eine Map erzeugt, in der als Schlüssel der Hersteller-String und als Wert die Liste mit __Autos__ von diesem Hersteller erscheinen. __Die Hersteller-String-Schlüssel müssen in der Map sortiert sein__:

	Map<String, List<Auto>> map = autos.stream().collect(collector);
	System.out.println(map); 
	// Ausgabe: {Opel=[Opel/Corsa, Opel/Astra], VW=[VW/Golf, VW/Polo]}


###### A5. partitioningBy
Bitte erzeugen Sie mit den Daten der Liste zwei Datengruppen (Parts)  mit `Stream/collect` und dem Collector `Collectors.partitioningBy`. In der true-Gruppe landen alle Autos, die im Modellnamen ein kleines 'o' haben. In der false-Gruppe werden alle anderen Autos gespeichert.
