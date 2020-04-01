package _200401_Innere_Klassen_Auto;

public class InnerClass_run {

	public static void main(String... args) {
	    RaceCar rw = new RaceCar("Fort Mustang Shelby GT 500");
	
	    RaceCar.Driver f = new RaceCar.Driver("Dominic", "Toretto");
	    rw.setDriver(f);
	
	    RaceCar.Engine m = rw.getEngine();
	
	    System.out.println(rw);		//Zeile A
	    System.out.println(m);		//Zeile B
	}
}
