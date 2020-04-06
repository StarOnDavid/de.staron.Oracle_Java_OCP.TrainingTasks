/**
 * 
 */
package _200406_Generics_Garage;

/**
 * @author David Staron
 *
 */
public class Truck implements Vehicle {
	private String name;
	private double weight;

	public Truck(String name, double weight) {
		super();
		this.name = name;
		this.weight = weight;
	}
	
	@Override
	public double getWeight() {
		return this.weight;
	}

	@Override
	public String getName() {
		return this.name;
	}

}
