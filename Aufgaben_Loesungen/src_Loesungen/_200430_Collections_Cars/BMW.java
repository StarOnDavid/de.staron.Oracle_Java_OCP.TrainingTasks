package _200430_Collections_Cars;

public class BMW extends Car {

	public BMW(String model, int yearOfManufacture) {
		super(model, yearOfManufacture);
	}
	
	public void setYoM(int year) {
		this.yearOfManufacture = year;
	}

	@Override
	public String toString() {
		return "BMW. Model: " + this.model + ", Year of manufacture " + this.yearOfManufacture;
	}

}
