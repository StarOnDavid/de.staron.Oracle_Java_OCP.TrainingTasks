package _200416_Generics_Zoo;

public class Creatures implements Treatable {
	private String name, type;
	private boolean healthy = true;
	
	public Creatures (String type, String name) {
		this.type = type;
		this.name = name;
	}
	
	@Override
	public void setHealthy(boolean healthy) {
		this.healthy = healthy;
	}

	@Override
	public boolean isHealthy() {
		return healthy;
	}

	@Override
	public String toString() {
		return type + ": " + name + " is healthy: " + (healthy ? "+" : "-");
	}
}

class Humans extends Creatures {	
	public Humans (String type, String name) {
		super(type, name);
	}
}

class Doctor<T> extends Humans {

	public Doctor(String name) {
		super("Doc", name);
	}

	public void heal(T t) {
		((Treatable) t).setHealthy(true);
	}	
}

abstract class Animals extends Creatures {
	public Animals (String type, String name) {
		super(type, name);
	}
}

class Elephant extends Animals {

	public Elephant(String name) {
		super("Elephant", name);
	}
}

class Monkey extends Animals {
	
	public Monkey(String name) {
		super("Monky", name);
	}
}

class Suricate extends Animals {

	public Suricate(String name) {
		super("Suricate", name);
	}

}