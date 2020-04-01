package _200401_Innere_Klassen_Auto;

public class Rennwagen {
	
	public static class Fahrer {
		private String vorname, nachname;

		public Fahrer(String vorname, String nachname) {
			this.vorname = vorname;
			this.nachname = nachname;
		}
		
		@Override
		public String toString() {
			return "Fahrer: " + vorname + " " + nachname;
		}
	} // end of Fahrer
	
	public class Motor {
		private String type;
		
		public Motor(String type) {
			this.type = type;
		}

		@Override
		public String toString() {
			return "Motor " + type + " aus dem Rennwagen " + hersteller; // implizit Rennwagen.this.hersteller
		}
	} // end of Motor
	
	private String hersteller;
	private Fahrer fahrer;
	private Motor motor;
	
	public Rennwagen(String hersteller) {
		this.hersteller = hersteller;
		this.motor = new Motor("Type 1"); // implizit this.new Motor("Type 1");
	}
	
	public Motor getMotor() {
		return motor;
	}
	
	public void setFahrer(Fahrer f) {
		this.fahrer = f;
	}
	
	@Override
	public String toString() {
		return "Rennwagen " + hersteller + ". " + fahrer;
	}
}
