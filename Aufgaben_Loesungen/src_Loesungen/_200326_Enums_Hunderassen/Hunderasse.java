package _200326_Enums_Hunderassen;

public enum Hunderasse {
	DACKEL(.5), COLLIE(1.0), DOGGE(1.5);
	
	private double maxGr;
	
	Hunderasse(double maxGr) {
		this.maxGr = maxGr;
	}
	
	public double getMaxGroesse() {
		return maxGr;
	}

}
