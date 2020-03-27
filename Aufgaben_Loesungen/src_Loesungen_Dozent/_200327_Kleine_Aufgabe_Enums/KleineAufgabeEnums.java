package _200327_Kleine_Aufgabe_Enums;

import java.util.Arrays;
import java.util.Comparator;

/*
 * A1: Bitte eine neue Klasse (!) 'ElementAlsKlasse' erzeugen
 * 
 * A5: Bitte ähnlich wie bei einer enum:
 *  class X extends ElementAlsKlasse <- Compilerfehler
 *  
 * A6: drei weitere Konstanten hinzufügen: FEUER, ERDE, WASSER
 */

public class KleineAufgabeEnums {

	public static void main(String[] args) {

		// A2. ElementAlsKlasse bitte entsprechend (wie die enum-Klasse) gestalten:
		Element e1 = Element.LUFT;
		System.out.println(e1);
		ElementAlsKlasse e2 = ElementAlsKlasse.LUFT;
		System.out.println(e2);
		
		// A3.
		// Element.LUFT = null; // Compilerfehler
		// ElementAlsKlasse.LUFT = null; // darf auch nicht kompilieren! 
		
		// A4.
		// new Element(); // Compilerfehler: es dürfen keine neuen Objekte gebildet werden
		// new ElementAlsKlasse(); // darf auch nicht kompilieren!
		
		// A7. Bitte die ElementAlsKLasse wie die enum-Klasse gestalten:
		//      (Ausgabe [LUFT, FEUER, ERDE, WASSER] erzeugen)
		Element[] arr1 = Element.values();
		System.out.println("arr1: " + Arrays.toString(arr1)); // [LUFT, FEUER, ERDE, WASSER]
		ElementAlsKlasse[] arr2 = ElementAlsKlasse.values();
		System.out.println("arr2: " + Arrays.toString(arr2)); // [LUFT, FEUER, ERDE, WASSER]
		
		System.out.println("** A8");
		// A8. Die Schleife mit ElementAlsKlasse sollte die Ausgaben wie mit der enum-Klasse erzeugen
		//		LUFT 0
		//		FEUER 1
		//		ERDE 2
		//		WASSER 3
		System.out.println("* mit der enum:");
		for (Element e : arr1) {
			System.out.println(e.name() + " " + e.ordinal());
		}
		System.out.println("* mit ElementAlsKlasse:");
		for (ElementAlsKlasse e : arr2) {
			System.out.println(e.name() + " " + e.ordinal());
		}
		
		System.out.println("** A9");
		// A9: Mit der ElementAlsKlasse sollte es möglich sein mit dem Reverse-Order-Comparator
		//      die Elemente absteigend zu sortieren
		Element[] arrEnums = Element.values();
		Arrays.sort(arrEnums, Comparator.reverseOrder());
		System.out.println("enums absteigend: " + Arrays.toString(arrEnums)); // [WASSER, ERDE, FEUER, LUFT]
		
		ElementAlsKlasse[] arrElements = ElementAlsKlasse.values();
		Arrays.sort(arrElements, Comparator.reverseOrder());
		System.out.println("absteigend mit ElementAlsKlasse: " + Arrays.toString(arrElements)); // [WASSER, ERDE, FEUER, LUFT]
		
		
	}
}




