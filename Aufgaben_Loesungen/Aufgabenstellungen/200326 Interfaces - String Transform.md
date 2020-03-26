# Aufgabe 'Interfaces - String Transform'

> Optional. Verwenden Sie JUnit um die Lösungen der folgenden Aufgaben zu testen

###### A1.
Eine Methode `transform` wird benötigt, die ein String-Array als Argument erhält, jeden String aus dem String-Array in ein Grossbuchstaben-String umwandelt, und den so erstellten String in einer ArrayList speichert. Die ArrayList mit den transformierten Strings wird zurückgeliefert:
 
		String[] arr = { "mo", "di", "mi" };
				
		ArrayList<String> list = transform(arr);
		
		System.out.println(list); // [MO, DI, MI]

###### A2.
Ändern Sie (oder überladen Sie) die Methode `transform`. Die neue`transform` soll nicht mehr die Strings zu Großbuchstaben-Strings verarbeiten. Stattdessen soll eine beliebige benutzerdefinierte Transformation für die übergebenen Strings möglich sein. Der Benutzer (Der Entwickler, der die Methode `transform` aufruft) soll selbst die Logik der Transformation bestimmen können. 


> Achtung! Die Aufgaben A3 und A4 sollen mit derselben Methode `transform` lösbar sein. Die Methode `transform` darf nicht für jede neue weitere Aufgabe angepasst werden.  


###### A3.
Testen Sie die Lösung aus A2. In diesem Test soll die Methode `transform` jedem String ein Punkt hinzufügen.

		String[] arr = { "mo", "di", "mi" };
		
		ArrayList list = /* hier die neue Methode 'transform' aufrufen */
		
		System.out.println(list); // [mo., di., mi.]

###### A4.
Testen Sie die Lösung aus A2. In diesem Test soll die Methode `transform` jedem String seine Länge in Klammern hinzufügen.

		String[] arr = { "mo", "di", "mi" };
		
		ArrayList list = /* hier die neue Methode 'transform' aufrufen */
		
		System.out.println(list); // [mo(2), di(2), mi(2)]

###### A5. Optional
Ändern Sie (oder überladen Sie) die Methode `transform`. Die neue `transform` soll nicht mehr die transformierten String in einer `ArrayList` zurückliefern. Stattdessen soll ein benutzerdefinierter Empfänger für die transformierten String möglich sein, der die geänderten Strings einzeln akzeptiert. Testen Sie die Lösung, bestimmen Sie für den Test einen Empfänger der transformierten Strings, der die Strings in einem StringBilder sammelt.
