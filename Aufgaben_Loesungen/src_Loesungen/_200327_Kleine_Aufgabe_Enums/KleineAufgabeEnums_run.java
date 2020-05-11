package _200327_Kleine_Aufgabe_Enums;

import java.util.Arrays;
import java.util.Comparator;

@SuppressWarnings("unused")
public class KleineAufgabeEnums_run {

	public static void main(String[] args) {
		//A2
		ElementAlsKlasse e1 = ElementAlsKlasse.LUFT;

		//A3
//		ElementAlsKlasse.LUFT = null;
		
		//A4
//		new ElementAlsKlasse();
		
		
		//A7
		ElementAlsKlasse[] arr = ElementAlsKlasse.values();
		System.out.println(Arrays.toString(arr));
		
		//A8
		for (ElementAlsKlasse e : arr) {
			System.out.println(e.name() + " " + e.ordinal());
		}
		
		//A9
		ElementAlsKlasse[] arrElements = ElementAlsKlasse.values();
		Arrays.sort(arrElements, Comparator.reverseOrder());
		
		System.out.println("absteigend mit ElementAlsKlasse: " +
						Arrays.toString(arrElements));
	}

}
