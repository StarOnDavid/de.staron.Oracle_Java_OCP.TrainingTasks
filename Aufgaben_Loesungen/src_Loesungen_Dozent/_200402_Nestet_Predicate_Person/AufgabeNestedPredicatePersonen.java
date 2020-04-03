package _200402_Nestet_Predicate_Person;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class PersonPredicateNachJahr implements Predicate<PersonDozent> {
	private int geburtsjahr;

	public PersonPredicateNachJahr(int geburtsjahr) {
		this.geburtsjahr = geburtsjahr;
	}

	@Override
	public boolean test(PersonDozent p) {
		return p.getGeburtsjahr() > geburtsjahr;
	}
}

public class AufgabeNestedPredicatePersonen {
	
	static class PersonPredicateNachnameMitChar implements Predicate<PersonDozent> {
		private char ch;

		public PersonPredicateNachnameMitChar(char ch) {
			this.ch = ch;
		}
		
		@Override
		public boolean test(PersonDozent p) {
			return p.getNachname().indexOf(ch) != -1;
		}
	}

	public static void main(String[] args) {
		
		PersonDozent[] personen = {
			new PersonDozent("Yoko", "Ono", 1950),	
			new PersonDozent("John", "Smith", 1930),	
			new PersonDozent("Edgar", "Poe", 1860),	
			new PersonDozent("Ute", "Toll", 1990)	
		};
		
		System.out.println("** A3. Personen geboren nach 1900: ");
		Predicate<PersonDozent> predicateIstNach1900 = new PersonPredicateNachJahr(1900);
		
		List<PersonDozent> listPersonen = filtern(personen, predicateIstNach1900);
		print(listPersonen);
		
		System.out.println("*** A4. Personen mit 'o' im Nachnamen: ");
		Predicate<PersonDozent> predicateHatImNachnamenKleinesO = new PersonPredicateNachnameMitChar('o');
		listPersonen = filtern(personen, predicateHatImNachnamenKleinesO);
		print(listPersonen);
		
		System.out.println("*** A5. Personen mit dem Nachnamen länger 3:");
		class PersonPredicateNachnameLen implements Predicate<PersonDozent> {
			@Override
			public boolean test(PersonDozent p) {
				return p.getNachname().length() >= 4;
			}
		}
		listPersonen = filtern(personen, new PersonPredicateNachnameLen());
		print(listPersonen);
		
		System.out.println("*** A6. Kombiniert A3 UND A4: ");
		Predicate<PersonDozent> combinedPredicate = new Predicate<PersonDozent> () {
			@Override
			public boolean test(PersonDozent p) {
				return predicateIstNach1900.test(p) && predicateHatImNachnamenKleinesO.test(p);
			}
		};
		
		listPersonen = filtern(personen, combinedPredicate);
		print(listPersonen);
		
		System.out.println("*** A6. Alternative Lösung");
		listPersonen = filtern(personen, predicateIstNach1900.and(predicateHatImNachnamenKleinesO));
		print(listPersonen);
		
		
		System.out.println("*** A7. Geboren in einem Schaltjahr:");
		Predicate<PersonDozent> predicateSchaltjahr = p -> Year.isLeap( p.getGeburtsjahr() );
		listPersonen = filtern(personen, predicateSchaltjahr);
		print(listPersonen);
	} // end of main
	
	static void print(List<PersonDozent> personen) {
		for (int i = 0; i < personen.size(); i++) {
			PersonDozent p = personen.get(i);
			System.out.format("%d. %6s %6s %d %n", (i+1), p.getVorname(), p.getNachname(), p.getGeburtsjahr());
		}
	}
	
	static List<PersonDozent> filtern(PersonDozent[] personen, Predicate<PersonDozent> predicate) {
		List<PersonDozent> result = new ArrayList<>();
		
		for(PersonDozent p : personen) {
			if( predicate.test(p) ) {
				result.add(p);
			}
		}
		
		return result;
	}
	

}
