package _200430_Collections_Autos;

public abstract class Auto <T extends Auto<?>> implements Comparable<T> {
	protected String modell;
	protected int baujahr;

	public Auto(String modell, int baujahr) {
		this.modell = modell;
		this.baujahr = baujahr;
	}
	
	@Override
	public int compareTo(T a2) {
		int erg = modell.compareTo(a2.modell);
		
		if(erg==0) {
			erg = baujahr - a2.baujahr;
		}
		
		return erg;
	}
	
	
	@Override
	public int hashCode() {
		return baujahr + modell.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
//		if( !(obj instanceof Auto ) ) {
//			return false;
//		}

		if(obj==null) {
			return false;
		}
		
		if(getClass()!=obj.getClass()) {
			return false;
		}
		
		@SuppressWarnings("unchecked")
		Auto<T> a2 = (Auto<T>) obj;
		
		return modell.equals(a2.modell) && baujahr==a2.baujahr;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + ". Modell: " + modell + ", Baujahr " + baujahr;
	}
}
