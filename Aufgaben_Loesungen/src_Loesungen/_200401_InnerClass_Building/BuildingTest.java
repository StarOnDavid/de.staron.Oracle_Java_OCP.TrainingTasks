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
	void BuildingConcretConstructorTest() {
		Building b = new Building("Hauptstraße", "45", 3, 10);
		
		assertEquals("Address: Hauptstraße 45", b.getAddress().toString());
		assertEquals(3, b.getNumOfFloors());
		
		for(int i = 0; i < 3; i++) {
			assertEquals(10, b.getNumOfRooms(i));
		}
	}
	
	@Test
	void BuildingConcretConstructorExceptionTest() {
		try {
			@SuppressWarnings("unused")
			Building b = new Building("Hauptstraße", "45", 0, 10);
			fail();     // fails, if no exception is thrown
		} catch (IllegalArgumentException e) { // fails if type not correct
			assertEquals(IllegalArgumentException.class, e.getClass());
			assertEquals("The number of floors in a Building must be greater than 0. Your input: 0" , e.getMessage());
		}
		
		try {
			@SuppressWarnings("unused")
			Building b = new Building("Hauptstraße", "45", 5, -1);
			fail();     // fails, if no exception is thrown
		} catch (IllegalArgumentException e) { // fails if type not correct
			assertEquals(IllegalArgumentException.class, e.getClass());
			assertEquals("The number of rooms per floor in a Building must be greater than 0. Your input: -1" , e.getMessage());
		}
	}
	
	@Test
	void FloorToStringTest() {
		Building b = new Building("Hauptstraße", "45", 3, 10);
		Building.Floor f = b.getFloor(0);
		assertEquals("Floor 0 has 10 rooms. In the building with Address: Hauptstraße 45", f.toString());
	}

	@Test
	void RoomToStringTest() {
		Building b = new Building("Hauptstraße", "45", 3, 10);
		Building.Floor f = b.getFloor(1);
		Building.Floor.Room r = f.getRoom(5);
		assertEquals("Room 5.1 In the building with Address: Hauptstraße 45", r.toString());
	}
}
