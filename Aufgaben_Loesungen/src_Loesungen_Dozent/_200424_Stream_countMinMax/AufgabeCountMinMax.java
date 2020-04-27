package _200424_Stream_countMinMax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Stream;

public class AufgabeCountMinMax {

	public static void main(String[] args) {
		
		a1();
		a2();
		a3();
	}

	static void a3() {
		System.out.println("*** A3");
		
		Locale[] locales = Locale.getAvailableLocales();
		
		System.out.println("** ohne Pipeline: ");
		
		// A    
	    List<Locale> filtered = new ArrayList<>();
	    for (Locale locale : locales) {
	        if(locale.getDisplayCountry().contains("t")) {
	            filtered.add(locale);
	        }
	    }
	    
	    Comparator<Locale> cmp = (loc1, loc2) -> 
	            loc1.getDisplayLanguage().compareTo(loc2.getDisplayLanguage());
	    
	    filtered.sort( cmp );
	    
	    if(filtered.size() > 0) {
	        Locale min = filtered.get( 0 );
	        System.out.println( min.getDisplayCountry() );
	        System.out.println( min.getDisplayLanguage() );
	    }
	    // B
	    
		System.out.println("** mit Pipeline: ");

		System.out.println("* Variante 1:");
		Arrays.stream(locales)
				.filter(loc -> loc.getDisplayCountry().contains("t"))
				.sorted( Comparator.comparing(Locale::getDisplayLanguage) )
				.findFirst()
				.ifPresent( minLocale -> {
			        System.out.println( minLocale.getDisplayCountry() );
			        System.out.println( minLocale.getDisplayLanguage() );
				});

		System.out.println("* Variante 2:");
		Arrays.stream(locales)
				.filter(loc -> loc.getDisplayCountry().contains("t"))
				.min( Comparator.comparing(Locale::getDisplayLanguage) )
				.ifPresent( minLocale -> {
					System.out.println( minLocale.getDisplayCountry() );
					System.out.println( minLocale.getDisplayLanguage() );
				});
		
	}
		
	static void a2() {
		System.out.println("*** A2");
			
		Locale[] locales = Locale.getAvailableLocales();
			
		long count = Stream.of(locales)
				.filter(loc -> loc.getLanguage().equals("de"))
				.peek(System.out::println)
				.count();
		
		System.out.println("Locales mit Sprache 'de': " + count);
	}
		
	static void a1() {
		System.out.println("*** A1");
		
		Locale[] locales = Locale.getAvailableLocales();
		
		Comparator<Locale> cmp = (loc1, loc2) -> loc2.getDisplayCountry().compareTo(loc1.getDisplayCountry());
		
		Optional<Locale> maybeLocale = Arrays.stream(locales).sorted(cmp).findFirst();
		
		System.out.println("Locale mit dem größten display-country: " 
				+ maybeLocale.get().getDisplayCountry());
		
		System.out.println("end");
	}
	
}
