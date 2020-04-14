package _200414_PriorityQue;

import java.util.Collection;
import java.util.PriorityQueue;

class Blume implements Comparable{
	private int preis;
	
	Blume(int preis){
		this.preis = preis;
	}
	
	public int getPreis() {
		return preis;
	}

	@Override
	public int compareTo(Object o) {
		Blume b = (Blume) o;
		if(this.preis > b.preis) {
			return 1;
		} else if (this.preis < b.preis) {
			return -1;
		} else {
			return 0;
		}
	}
}

public class PriorityQue_Test {

	public static void main(String[] args) {
		PriorityQueue<Blume> blumen = new PriorityQueue<>();
		
		blumen.add(new Blume(3));	
		blumen.add(new Blume(2));
		blumen.add(new Blume(1));
		blumen.add(new Blume(4));
		blumen.add(new Blume(7));
		blumen.add(new Blume(5));
		
		for(Blume b : blumen) {
			System.out.print(b.getPreis() + " ");
		}
		
		System.out.println("\n" + blumen.peek().getPreis());
		System.out.println("\n" + blumen.poll().getPreis());
		for(Blume b : blumen) {
			System.out.print(b.getPreis() + " ");
		}
	}
}
