package _200424_Stream_countMinMax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@SuppressWarnings("unused")
public class CountMinMax_run {
	private static Locale[] locales = Locale.getAvailableLocales();

	public static void main(String[] args) {
//		a1();
//		a2();
		a3();
	}

	private static void a1() {
		Optional<Locale> maxDC = Arrays.stream(locales)
				.max((a, b) -> a.getDisplayCountry().compareTo(b.getDisplayCountry()));
		if(maxDC.isPresent())
			System.out.println("Der lexicographisch größten Wert in 'Locale.getDisplayCountry()' ist: " + maxDC.get().getDisplayCountry());
	}
	
	private static void a2() {
		long numOf_de = Arrays.stream(locales)
				.filter(x -> x.getLanguage().contentEquals("de"))
				.count();
		
		System.out.println("In 'Locale.getAvailableLocales()' gibt es " + numOf_de + " Einträge für Länder mit der Sprache 'de'.");
	}
	
	private static void a3() {
		System.out.println("Ausgabe der Vorlage: ");
		a3vorlage();
		
		System.out.println("Ausgabe gelöst als Pipline:");
		Optional<Locale> minWith_t = Arrays.stream(locales)
			.filter(x -> x.getDisplayCountry().contains("t"))
			.min((loc1, loc2) ->  loc1.getDisplayLanguage().compareTo(loc2.getDisplayLanguage()));
		
		if(minWith_t.isPresent()) {
			System.out.println(minWith_t.get().getDisplayCountry());
			System.out.println(minWith_t.get().getDisplayLanguage());
		}
	}
	
	private static void a3vorlage() {
		List<Locale> filtered = new ArrayList<>();
		for (Locale locale : locales) {
		    if(locale.getDisplayCountry().contains("t")) {
		        filtered.add(locale);
		    }
		}

		Comparator<Locale> cmp = (loc1, loc2) -> loc1.getDisplayLanguage().compareTo(loc2.getDisplayLanguage());

		filtered.sort( cmp );

		if(filtered.size() > 0) {
		    Locale min = filtered.get( 0 );
		    System.out.println( min.getDisplayCountry() );
		    System.out.println( min.getDisplayLanguage() );
		}
		System.out.println();
	}
	
}
