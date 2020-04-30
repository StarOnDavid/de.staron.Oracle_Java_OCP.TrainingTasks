package _200430_Collections_Cars;

public class VW extends Car {

	public VW(String model, int yearOfManufacture) {
		super(model, yearOfManufacture);
	}

	@Override
	public String toString() {
		return "VW. Model: " + this.model + ", Year of manufacture " + this.yearOfManufacture;
	}
}
