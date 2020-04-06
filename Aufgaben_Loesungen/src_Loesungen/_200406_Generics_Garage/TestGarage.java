package _200406_Generics_Garage;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author David Staron
 *
 */
class TestGarage {

	@Test
	void testConstrucor() {
		Garage<Car> g = new Garage<>("Car Garage"); 
		assertTrue(g instanceof Garage);
		assertFalse(g instanceof Vehicle);
	}

	@Test
	void testGetters() {
		Garage<Car> g = new Garage<>("Car Garage"); 
		assertEquals("Car Garage", g.getName());
	}
	
	
	@Test
	void testDriveInVehicleInGarageWithCar() {
		Car c = new Car("Fort", 1.56);
		Garage<Car> g = new Garage<>("Car Garage");
		g.driveIn(c);
		assertEquals(c, g.vehicleInside());
	}
	
	@Test
	void testDriveInVehicleInGarageWithTruck() {
		Truck t = new Truck("MAN", 38.7);
		Garage<Truck> g = new Garage<>("Truck Garage");
		g.driveIn(t);
		assertEquals(t, g.vehicleInside());
	}
}
