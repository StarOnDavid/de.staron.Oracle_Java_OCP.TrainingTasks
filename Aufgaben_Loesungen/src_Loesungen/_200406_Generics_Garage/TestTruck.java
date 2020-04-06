package _200406_Generics_Garage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * @author David Staron
 *
 */
class TestTruck {
	
	@Test
	public void testConstructor() {
		Truck t = new Truck("MAN", 38.7);
		assertTrue(t instanceof Truck);
		assertTrue(t instanceof Vehicle);
	}
	
	@Test
	public void testGetters() {
		Truck t = new Truck("MAN", 38.7);
		assertEquals("MAN", t.getName());
		assertEquals(38.7, t.getWeight(), 0.001);
	}
}
