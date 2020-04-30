package _200430_Collections_Cars;

public abstract class Car implements Comparable<Car> {
	protected int yearOfManufacture;
	protected String model;
	
	public Car(String model, int yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
		this.model = model;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + yearOfManufacture;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (yearOfManufacture != other.yearOfManufacture)
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Car c) {
		int result = this.model.compareTo(c.model);
		if(result == 0) {
			return this.yearOfManufacture-c.yearOfManufacture;
		}
		return result;
	}
	
}
