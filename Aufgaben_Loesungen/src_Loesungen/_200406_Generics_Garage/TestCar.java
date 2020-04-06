package _200406_Generics_Garage;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author David Staron
 *
 */
public class TestCar {

	@Test
	public void testConstructor() {
		Car c = new Car("Fort", 1.56);
		assertTrue(c instanceof Car);
		assertTrue(c instanceof Vehicle);
	}
	
	@Test
	public void testGetters() {
		Car c = new Car("Fort", 1.56);
		assertEquals("Fort", c.getName());
		assertEquals(1.56, c.getWeight(), 0.001);
	}
}
