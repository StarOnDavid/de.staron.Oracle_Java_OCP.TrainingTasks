package _200416_Generics_Zoo;

import java.util.Collection;

public class Doctor<T> extends Human {

	public Doctor(String name) {
		super("Doc", name);
	}

	public void heal(T t) {
		((Treatable) t).setHealthy(true);
	}
	
}
