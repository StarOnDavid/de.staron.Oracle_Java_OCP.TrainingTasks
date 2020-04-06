/**
 * 
 */
package _200406_Generics_Garage;

/**
 * @author David Staron
 *
 */
public class Car implements Vehicle {
	private String name;
	private double weight;

	public Car(String name, double weight) {
		super();
		this.name = name;
		this.weight = weight;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public double getWeight() {
		return this.weight;
	}
}
