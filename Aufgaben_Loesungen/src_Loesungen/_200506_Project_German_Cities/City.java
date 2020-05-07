package _200506_Project_German_Cities;

public class City {
	private int nr;
	private String name;
	private int population;
	private String country;
	
	public City(int nr, String name, int population, String country) {
		super();
		this.nr = nr;
		this.name = name;
		this.population = population;
		this.country = country;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public int getNr() {
		return nr;
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return "City [nr=" + nr + ", name=" + name + ", population=" + population + ", country=" + country + "]";
	}
	
	
}
