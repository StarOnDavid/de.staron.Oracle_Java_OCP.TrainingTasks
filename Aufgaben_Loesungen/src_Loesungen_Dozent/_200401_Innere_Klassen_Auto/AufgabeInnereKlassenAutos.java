package _200401_Innere_Klassen_Auto;

public class AufgabeInnereKlassenAutos {

	public static void main(String... args) {
	    Rennwagen rw = new Rennwagen("Mercedes");
	
	    Rennwagen.Fahrer f = new Rennwagen.Fahrer("M.", "Schuhmacher");
	    rw.setFahrer(f);
	
	    Rennwagen.Motor m = rw.getMotor();
	
	    System.out.println(rw);		//Zeile A: Rennwagen Mercedes. Fahrer: M. Schuhmacher
	    System.out.println(m);		//Zeile B: Motor Type1 aus dem Rennwagen Mercedes
	}

}
