package _200401_InnerClass_Building;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BuildingTest {

	@Test
	void BuildingBasicConstructorTest() {
		Building b = new Building();
		
		assertEquals("Address: n/a", b.getAddress().toString());
		assertEquals(1, b.getNumOfFloors());
		assertEquals(1, b.getNumOfRooms(0));
	}
	
	@Test
	void BuildingConcretConstructorOneTest() {
		Building b = new Building("Hauptstraße", "45", 3, 10);
		
		assertEquals("Address: Hauptstraße 45", b.getAddress().toString());
		assertEquals(3, b.getNumOfFloors());
		
		for(int i = 0; i < 3; i++) {
			assertEquals(10, b.getNumOfRooms(i));
		}
	}

}
