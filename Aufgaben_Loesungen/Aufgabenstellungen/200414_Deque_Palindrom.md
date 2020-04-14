# Aufgabe 'Palindrom - Deque'

> https://de.wikipedia.org/wiki/Palindrom

Gegeben ist folgende main-Methode:


		Character[] arr = { 'a', 'n', 'n', 'a' };
        
      boolean erg = isPalindrome(arr);
      System.out.println(erg); // true
      
      arr = new Character[] { 'r', 'o', 't', 'o', 'r' };
      erg = isPalindrome(arr);
      System.out.println(erg); // true

      arr = new Character[] { 'm', 'o', 't', 'o', 'r' };
      erg = isPalindrome(arr);
      System.out.println(erg); // false      


Um die Klasse `ArrayDeque` kennen zu lernen, realisieren Sie bitte die Methode `isPalindrome` nach der folgenden Beschreibung:

Die Methode `isPalindrome` speichert zuerst die Zeichen aus dem `arr` in einem `ArrayDeque`. 
Dann entfernt sie die Zeichen nacheinander von beiden Enden des ArrayDeque und überprüft dabei, ob sie identisch sind. Auf diese Weise wird ermittelt, ob die Zeichen in dem übergebenen Array ein Palindrom ergeben. Z.B.:

		a n n a		Ein Zeichen vom Head und eins vom Tail entfernen. 
						Beide gleich, weiter.
		  n n			Ein Zeichen vom Head und eins vom Tail entfernen. 
						Beide gleich, weiter.
						Kein Zeichen mehr: Palindrom.
						
		r o t o r		Ein Zeichen vom Head und eins vom Tail entfernen. Beide gleich, weiter.
		  o t o		Ein Zeichen vom Head und eins vom Tail entfernen. Beide gleich, weiter.
		    t			Nur ein Zeichen geblieben: Palindrom.
		    
		m o t o r		Ein Zeichen vom Head und eins vom Tail entfernen.
						Ungleich: kein Palindrom
