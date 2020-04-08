# Aufgabe 'Set - TextStatistics'

- Erstellen Sie eine Klasse `TextStatistics`.

- Definieren Sie eine statische Methode `of` für die Klasse `TextStatistics`, an die man ein String übergeben kann:

		TextStatistics stat = TextStatistics.of("Heute ist Montag!");


- Definieren Sie eine weitere Methode `getUniqueChars`, die eine Collection von `Character` liefert, in der alle auftretenden Zeichen von dem zu untersuchenden String aufgelistet sind und __einmalig__ auftauchen:

		Collection<Character> chars = stat.getUniqueChars();

- Geben Sie die gefundenen Zeichen aus.

