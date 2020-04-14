# Aufgabe 'Browser History - Deque'

Definieren Sie bitte die Klasse `BrowserHistory` und gestalten Sie Ihre Tests nach folgenden Beschreibungen. Verwenden Sie bitte bei der Realisierung die Klasse `ArrayDeque`.

###### A1.
Browser-History wird angelegt, die imstande ist fünf URLs zu merken (inklusive der zuletzt geöffneten aktuell angezeigten URL).
	
	BrowserHistory h = new BrowserHistory();

###### A2. 
Die nächsten fünf `open`-Aufrufe füllen die Browser-History komplett.
Der zuletzt übergebene String 'u5.com' wird als aktuell angezeigte Seite gespeichert.

		h.open("u1.com"); // [u1.com]
		h.open("u2.com"); // u1.com < [u2.com]
		h.open("u3.com"); // u1.com < u2.com < [u3.com]
		h.open("u4.com"); // u1.com < u2.com < u3.com < [u4.com]
		h.open("u5.com"); // u1.com < u2.com < u3.com < u4.com < [u5.com]

		System.out.println( h.getCurrent() ); 	// u5.com
		
> Kommentare nach open-Aufrufen zeigen symbolisch den Zustand von `BrowserHistory`.
		
###### A3.	
Der nächste `open`-Aufruf fügt 'u6.com' der Browser-History hinzu. 
Da die maximale Größe der gespeicherten URLs bereits erreicht wurde, wird der älteste Eintrag 'u1.com' gelöscht.
Der zuletzt hinzugefügte String 'u6.com' wird als aktuell angezeigte Seite gespeichert.

		h.open("u6.com");
		System.out.println( h.getCurrent() );	// u6.com
		
		// u2.com < u3.com < u4.com < u5.com < u6.com
		
###### A4.	
Die nächsten vier `openPrevious`-Aufrufe lassen den Client rückwärts navigieren: zu 'u5.com', 'u4.com', 'u3.com', 'u2.com'. 
Nach jedem Aufruf wechselt auch die aktuell angezeigte Seite. 
Nach dem vierten `openPrevious`-Aufruf ist 'u2.com' die aktuelle Seite.

		h.openPrevious();
		h.openPrevious(); 
		h.openPrevious(); 
		h.openPrevious(); 
		System.out.println( h.getCurrent() );	// u2.com
		
		// [u2.com] > u3.com > u4.com > u5.com > u6.com
		
###### A5.	
Der weitere Versuch `openPrevious` aufzurufen verursacht eine Exception, da die Browser-History keine 'previous'-Einträge mehr hat.  
Die 'u2.com' bleibt als die aktuell angezeigte Seite gespeichert.

		try {
			h.openPrevious();
		} catch (IllegalStateException e) {
			System.out.println( e.getMessage() ); // previous history is empty
		}
		System.out.println( h.getCurrent() );	// u2.com
		
###### A6.
Die nächsten vier `openNext`-Aufrufe lassen den Client vorwärts navigieren: zu 'u3.com', 'u4.com', 'u5.com', 'u6.com'.
Nach dem vierten `openNext`-Aufruf ist 'u6.com' die aktuelle Seite und die Browser-History für die  'previous'-Einträge ist wieder voll.

		h.openNext();
		h.openNext();
		h.openNext();
		h.openNext();
		System.out.println( h.getCurrent() );	// u6.com
		
		// u2.com < u3.com < u4.com < u5.com < [u6.com]
		
###### A7.
Der weitere Versuch `openNext` aufzurufen verursacht eine Exception, da es keine 'next'-URLs mehr gibt. 
Die 'u6.com' bleibt die aktuelle Seite.

		try {
			System.out.println( h.openNext() );
		} catch (IllegalStateException e) {
			System.out.println( e.getMessage() ); // next history is empty
		}
		
		System.out.println( h.getCurrent() );	// u6.com

###### A8. Optional

Die nächsten zwei `openPrevious`-Aufrufe lassen den Client rückwärts navigieren: zu 'u5.com', 'u4.com'. 

		h.openPrevious();
		h.openPrevious(); 

		// u2.com < u3.com < [u4.com] > u5.com > u6.com
		
Damit ist 'u4.com' die aktuelle Seite. Die 'u5.com' und 'u6.com' sind die 'next'-URLs.  
Der darauffolgende Aufruf der Methode `open` löscht alle 'next'-URLs und setzt die neue URL als aktuell angezeigte Seite.

		f.open("u7.com");
		
		// u2.com < u3.com < u4.com < [u7.com]

