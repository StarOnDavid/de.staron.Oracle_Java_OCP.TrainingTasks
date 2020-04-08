package _200406_Generics_Garage;

interface Fahrzeug {}

class PKW implements Fahrzeug {}
class LKW implements Fahrzeug {}

//class LKWGarage_Dozent {
//	void reinfahren(LKW lkw) {}
//}
//class PKWGarage_Dozent {
//	void reinfahren(PKW pkw) {}
//}

class Garage_Dozent <F extends Fahrzeug> {
	private F fahrzeug;
	
	void reinfahren(F f) {
		this.fahrzeug = f;
	}
	//...
}

public class AufgabeGenericsGarage {
	public static void main(String[] args) {

		// LKW lkw = new PKW();
		
		Garage_Dozent<PKW> pkwGarage_Dozent = new Garage_Dozent<PKW>();
		pkwGarage_Dozent.reinfahren(new PKW());
		// pkwGarage_Dozent.reinfahren(new LKW());
		
		Garage_Dozent<LKW> lkwGarage_Dozent = new Garage_Dozent<LKW>();
		lkwGarage_Dozent.reinfahren(new LKW());
		// lkwGarage_Dozent.reinfahren(new PKW());
		
		// pkwGarage_Dozent = lkwGarage_Dozent; // Compilerfehler
		pkwGarage_Dozent.reinfahren(new PKW());
		
		// Garage_Dozent<Integer> sinnlos; // Compilerfehler
	}

}
