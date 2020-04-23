package _200423_MiniTask_StreamMethoden;

import java.util.Arrays;

class Blume {
	private int preis;
	
	public Blume(int preis) {
		this.preis = preis;
	}
	
	public int getPreis() {
		return preis;
	}

	public void setPreis(int preis) {
		this.preis = preis;
	}

	@Override
	public String toString() {
		return "Blume kostet: " + preis;
	}
	
	
}

public class Map {

	public static void main(String[] args) {
		Integer[] preise = {11, null, 7, -22, 15, 3};
		
		Arrays.stream(preise)
			  .filter(x -> x != null && x > 0)
			  .map(Blume::new)
			  .forEach(System.out::println);
	}
}
