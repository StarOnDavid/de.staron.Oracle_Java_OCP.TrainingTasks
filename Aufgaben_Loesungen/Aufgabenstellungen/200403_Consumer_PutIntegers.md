# Aufgabe 'Put Integers - Consumer'

Gegeben ist die main-Methode:

	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();
		putIntegers( i -> sb.append(i).append(" ") );
		System.out.println(sb); 	// Zeile A

		
		List<Integer> list = new ArrayList<>();
		putIntegers( i -> list.add(i) );
		System.out.println(list); // Zeile B

		
		putIntegers( System.out::print ); 	// Zeile C, optionale Aufgabe, 
													// die Zeile C kann entfernt werden
	}

Die Ausgabe aus der Zeile A:

		1 2 3 4
		
Die Ausgabe aus der Zeile B:

		[1, 2, 3, 4]

Die Ausgabe aus der Zeile C:

		1234

Definieren Sie bitte die Methode `putIntegers`. 
