package _200416_Generics_Zoo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Zoo {
	
	private List<Animals> anis = new ArrayList<>();
	
	public boolean addAnimal(Animals ani) {
		return this.anis.add(ani);
	}

	public List<Animals> getAllAnimals() {
		return anis;
	}
}
