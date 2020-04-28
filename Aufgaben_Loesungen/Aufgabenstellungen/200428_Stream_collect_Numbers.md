# Aufgabe 'collect - Numbers'

Gegeben ist der Code:
	
		String[] arr = {
			"1,2,3,4,5",
			"7,6,5,4,3",
			"123,456",
		};
		
		List<Integer> list;
		
		// A
		list = new ArrayList<>();
		for (String s : arr) {
			String[] stringNumbers = s.split(",");
			
			for (String sNum : stringNumbers) {
				Integer num = Integer.valueOf(sNum);
				list.add(num);
			}
		}
		// B
		
		System.out.println(list); // [1, 2, 3, 4, 5, 7, 6, 5, 4, 3, 123, 456]

####### A1.

Bilden Sie bitte eine Stream-Pipeline, die den Code zwischen den Zeilen A und B ersetzen kann. 
Sie soll auch

	- jeden String aus dem Array `arr` in Unterstrings spalten (mit dem Trenner ",")	
	- jedes Element aus jedem String-Array zu einem Integer parsen
	- Alle Integer in einer List speichern
	
> Zum Spalten eines Strings in Unterstrings können Sie natürlich auch die Methode `split` der Klasse String verwenden:

		String s = "1,2,3";
		String[] substrings = s.split(",");

####### A2.

Ändern Sie die Pipeline so, dass am Ende nur gerade Zahlen in der Liste gespeichert sind