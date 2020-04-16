package _200416_Generics_Zoo;

public abstract class Animal implements Treatable {
	
	private String name, type;
	private boolean healthy = true;
	
	public Animal (String type, String name) {
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
