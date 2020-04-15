package _200415_Map_Besitzer_Fahrzeuge;

public class Vehicle implements Comparable<Vehicle> {
	private String model;
	private String brand;
	
	public Vehicle(String model, String brand) {
		this.model = model;
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public String getBrand() {
		return brand;
	}

	@Override
	public int compareTo(Vehicle v) {
		int br = this.brand.compareTo(v.brand);
		if(br == 0)
			return this.model.compareTo(v.model);
		return br;
	}

	@Override
	public String toString() {
		return brand + " - " + model;
	}
	
	
}
