package _200401_Innere_Klassen_Auto;

public class RaceCar {

	class Engine {
		private String name;
		
		Engine(String name){
			this.name = name;
		}
		
		@Override
		public String toString() {
			return "Engine: " + name ;
		}
	}
	
	static class Driver {
		private String fname, lname;
		
		Driver(String fname, String lname) {
			this.fname = fname;
			this.lname = lname;
		}
		@Override
		public String toString() {
			return "Driver: " + fname + " " + lname;
		}
		
		
	}
	
	private String brand;
	private Driver driver;
	private Engine engine;
	
	public RaceCar(String brand) {
		this.brand = brand;
		this.engine = new Engine("Cobra-Jet-7-Liter-V8");
	}
	
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	public Engine getEngine() {
		return engine;
	}

	@Override
	public String toString() {
		return "RaceCar: " + brand + 
				", " + driver + ", " + engine;
	}
	
	
}
