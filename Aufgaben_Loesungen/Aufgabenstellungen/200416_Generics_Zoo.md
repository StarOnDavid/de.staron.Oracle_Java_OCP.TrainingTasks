# Aufgabe 'Generics - Zoo'

- Entwerfen Sie eine Klassensammlung, die folgender Beschreibung entspricht:

    - Das Interface 'KannBehandeltWerden' deklariert eine Methode 'void setGesund(boolean)'
    - Das Interface 'KannBehandeltWerden' deklariert eine Methode 'boolean isGesund()'
    
    - Mensch ist eine Klasse, die das Interface 'KannBehandeltWerden' realisiert

    - Die Klasse Tier ist abstract
    - alle Tiere können behandelt werden (s. das Interface 'KannBehandeltWerden')
    - Zebras und Affen sind Tiere

    - Ein Zoo kann mehrere Tiere haben (HAS-A)
    - Einem Zoo können beliebige Tiere einzeln hinzugefügt werden
    - Ein Zoo kann eine Collection aller seine Tiere mit einer Methode zurückliefern
    
    - Ein Arzt ist ein Mensch

- Passen Sie die Klasse 'Arzt' so an, dass sich mit ihr folgende Aufgaben lösen lassen:

    - Es ist möglich, einen Arzt zu erzeugen, der nur Affen behandeln kann (aber keine anderen Tiere)
    - Es ist möglich, einen Arzt zu erzeugen, der beliebige Tiere behandeln kann (aber keine Menschen)
    - Es ist möglich, einen Arzt zu erzeugen, der sowohl Tiere als auch Menschen behandeln kann
