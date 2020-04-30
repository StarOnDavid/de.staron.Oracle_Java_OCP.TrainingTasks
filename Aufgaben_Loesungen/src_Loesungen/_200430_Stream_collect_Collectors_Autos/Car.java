package _200430_Stream_collect_Collectors_Autos;

public class Car {

	private String brand, model;
	public Car(String brand, String model) {
		this.brand = brand;
		this.model = model;
	}
	public String getBrand() { return brand; }
	public String getModel() { return model; }
	
	public String toString() { return brand + "/" + model; }
}
