package _200430_Collections_Autos;

public class Fahrzeug {

	private String modell, hersteller;

	public Fahrzeug(String hersteller, String modell) {
		this.modell = modell;
		this.hersteller = hersteller;
	}
	
	@Override
	public String toString() {
		return hersteller + " " + modell;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hersteller == null) ? 0 : hersteller.hashCode());
		result = prime * result + ((modell == null) ? 0 : modell.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fahrzeug other = (Fahrzeug) obj;
		if (hersteller == null) {
			if (other.hersteller != null)
				return false;
		} else if (!hersteller.equals(other.hersteller))
			return false;
		if (modell == null) {
			if (other.modell != null)
				return false;
		} else if (!modell.equals(other.modell))
			return false;
		return true;
	}
		
}
