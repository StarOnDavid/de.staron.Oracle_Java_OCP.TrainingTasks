# Kleine Aufgabe 'Enums'

#### A1.
Bitte eine neue Klasse (1) 'ElementAlsKlasse' erzeugen.

#### A2.
'ElementAlsKlasse' bitte entsprechend gestalten, dass folgende Zeile kompiliert:

*ElementAlsKlasse e1 = ElementAlsKlasse.LUFT;*

#### A3.
Die folgende Zeile Code darf nicht kompilieren.

*ElementAlsKlasse.LUFT = null;*

#### A4.
Es darfen nicht möglich sein neuen Objekte zu bilden. Die folgende Zeile Code darf nicht kompilieren.

*new ElementAlsKlasse();*

#### A5.
Ähnlich wie bei einer enum-Klasse darf es nicht möglich sein die Klasse 'ElementsAlsKlasse' zu erweitern (extends).

*class X extends ElementAlsKlasse <- Compilerfehler*

#### A6.
drei weitere Konstanten hinzufügen: FEUER, ERDE, WASSER

#### A7.
Bitte geben sie die Klasse wie bei einer enum-Klasse aus.

*Ausgabe: [LUFT, FEUER, ERDE, WASSER]*

#### A8.
Eine Schleife mit ElementAlsKlasse soll die Ausgabe wie mit einer enum-Klasse erzeugen.

<em>for (ElementAlsKlasse e : arr) { <br>
&#160;&#160;&#160;&#160;System.out.println(e.name() + " " + e.ordinal()); <br>
}</em>

#### A9.