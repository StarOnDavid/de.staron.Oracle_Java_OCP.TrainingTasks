package _200401_InnerClass_Building;

import java.util.ArrayList;
import java.util.List;

public class Building {
	public class Floor {
		public class Room {
			
		} // end of Room
		
		private ArrayList<Room> rooms;
		
		public Floor () {
			rooms = new ArrayList<Room>();
			rooms.add(new Room());
		}
		
		public Floor (int numRooms) {
			rooms = new ArrayList<Room>();
			do {
				rooms.add(new Room());
				numRooms--;
			} while (numRooms > 0);
		}

		public Room getRoom(int roomNum) {
			return rooms.get(roomNum);
		}
		
	} // end of Floor
	
	public class Address {
		String street;
		String num;
		String city;
		String zipCode;
		
		public Address() {
			super();
			this.street = "n/a";
			this.num = "n/a";
			this.city = "n/a";
			this.zipCode = "n/a";
		}
		public Address(String street, String num) {
			super();
			this.street = street;
			this.num = num;
			this.city = "n/a";
			this.zipCode = "n/a";
		}

		public Address(String street, String num, String city, String zipCode) {
			super();
			this.street = street;
			this.num = num;
			this.city = city;
			this.zipCode = zipCode;
		}

		@Override
		public String toString() {
			if (num == "n/a" || street == "n/a") {
				return "Address: n/a";
			} else if (city == "n/a" || zipCode == "n/a") {
				return "Address: " + street + " " + num;
			} else {
				return "Address: " + street + " " + num + ", "  + zipCode + " " + city;
			}
		}
		
		
	} // end of Adress
	
	private ArrayList<Floor> floors = new ArrayList<Floor>();
	private Address address;
	
	public Building () {
		floors.add(new Floor());
		address = new Address();
	}
	
	public Building (String street, String num, int numFloors, int roomsPerFloor) {
		do {
			floors.add(new Floor(roomsPerFloor));
			numFloors--;
		} while (numFloors > 0);
		address = new Address(street, num);
	}

	public Floor getFloor(int floorNum) {
		return floors.get(floorNum);
	}
	
	public Floor.Room getRoom(int floorNum, int roomNum) {
		return floors.get(floorNum).getRoom(roomNum);
	}

	public Address getAddress() {
		return address;
	}
	
	public int getNumOfFloors() {
		return floors.size();
	}
	
	public int getNumOfRooms(int floor) {
		return floors.get(floor).rooms.size();
	}
	
	
	
} // end of Building
