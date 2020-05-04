package _200430_Collections_Autos;

public class BMW extends Auto<BMW> {

	public BMW(String modell, int baujahr) {
		super(modell, baujahr);
	}
	
	public void setBaujahr(int baujahr) {
		this.baujahr = baujahr;
	}
}
