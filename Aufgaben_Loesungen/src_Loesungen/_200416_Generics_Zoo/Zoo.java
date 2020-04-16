package _200416_Generics_Zoo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Zoo {
	
	private List<Animal> anis = new ArrayList<>();
	
	public boolean addAnimal(Animal ani) {
		return this.anis.add(ani);
	}

	public List<Animal> getAllAnimals() {
		return anis;
	}
}
