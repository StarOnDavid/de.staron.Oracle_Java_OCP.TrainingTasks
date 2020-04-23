# Aufgabe 'intermediate operations'

###### A1.
Gegeben ist der Code:

		List<Integer> list = Arrays.asList(13, 15, 17, 19, 21);
		
		// A
		for(Integer x : list) {
			if(x==15 || x==19) {
				System.out.println("Treffer: " + x);
			}
		}
		// B

Bitte ersetzen Sie den Code zwischen den Zeilen A und B mit einer Pipeline, die dieselben Ausgaben liefert.

###### A2.
Gegeben ist der Code:

		Integer[] array = { 1, 4, 7, 3, -8 };
		
		//A
		for (Integer x : array) {
			System.out.println( x%2==0 ? "gerade" : "ungerade" );
		}
		//B

Bitte ersetzen Sie den Code zwischen den Zeilen A und B mit einer Pipeline, die dieselben Ausgaben liefert.

###### A3.
Gegeben ist die Klasse:

		class Tier {
			private String name;

			public Tier(String name) {
				this.name = name;
			}
			public String toString() {
				return "Tier " + name;
			}
		}
		
und der Code:

		List<String> list = Arrays.asList("Tom", "Jerry", "Rex");
		
		//A
		for(String name : list) {
			Tier t = new Tier(name);
			System.out.println(t);
		}
		//B

Bitte ersetzen Sie den Code zwischen den Zeilen A und B mit einer Pipeline, die dieselben Ausgaben liefert.


###### A4.
Erstellen Sie bitte eine Pipeline, 
    - die 30 Zufallswerte im Bereich [-20 ... 20] generiert (s. Stream.generate),
    - dann die negativen Werte aus dem Bereich [-15 ... -10] ausfiltert (weg wirft),
    - dann die durchgekommenen Werte in Double umwandelt
    - dann die Double-Werte ausgibt

Falls noch nicht realisiert, ändern Sie bitte die Pipeline so, dass sie immer 30 Ausgaben erzeugt.


###### A5.
Gegeben ist die Klasse:

		class Tier {
			private String name;

			public Tier(String name) {
				this.name = name;
			}
			public String toString() {
				return "Tier " + name;
			}
		}
		
und das Array
 		
		Tier[] array = {
			new Tier("Rex"),
			new Tier("Tom"),
			new Tier("Jerry"),
			new Tier("Tom"),
			new Tier("Jerry"),
		};
		
Definieren Sie bitte eine Pipeline, die das Array array als Datenquelle nimmt und nur eindeutige (einzigartige) Tiere ausgibt. Falls nötig, dürfen Sie die Klasse `Tier` anpassen.

###### A6.

Gegeben sind folgende Listen, die die EMail-Adressen beinhalten:
	
		List<String> mailsErsthelfer = Arrays.asList("tom@mycompany.com", "jerry@mycompany.com");
		List<String> mailsIT = Arrays.asList("tom@mycompany.com", "mary@mycompany.com");
		List<String> mailsQM = Arrays.asList("peter@mycompany.com", "jerry@mycompany.com");

Die Listen werden in eine Pipeline gesammelt:

		Stream.of(mailsErsthelfer, mailsIT, mailsQM)
			...
			forEach(System.out::println);

Gestalten Sie die Pipeline so, dass sie einzigartige Mitarbeiter-Namen ausgibt:

		tom
		jerry
		mary
		peter






