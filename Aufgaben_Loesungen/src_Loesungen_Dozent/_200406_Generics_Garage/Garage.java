/**
 * 
 */
package _200406_Generics_Garage;

/**
 * @author David Staron
 *
 */
public class Garage <T extends Vehicle> {
	private String name;
	private T vInGarage;
	
	public Garage(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public T vehicleInside() {
		return vInGarage;
	}

	public void driveIn(T vehicle) {
		this.vInGarage = vehicle;
	}

	
}
