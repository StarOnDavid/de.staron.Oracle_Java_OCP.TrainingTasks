package _200416_Generics_Zoo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

interface KannBehandeltWerden {
	void setGesund(boolean gesund);
	boolean isGesund();
}

class Lebewesen implements KannBehandeltWerden {
	private boolean gesund;

	@Override
	public void setGesund(boolean gesund) {
		this.gesund = gesund;
	}

	@Override
	public boolean isGesund() {
		return gesund;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " ist " + (gesund ? "gesund" : "krank");
	}
}

class Mensch extends Lebewesen {}

abstract class Tier extends Lebewesen {}

class Zebra extends Tier {}
class Affe extends Tier {}


class ZooDozent {
	private List<Tier> tiere = new ArrayList<>();
	
	public void add(Tier t) {
		tiere.add(t);
	}
	
	public Collection<Tier> getTiere() {
		return tiere;
	}
}

class Arzt <T extends KannBehandeltWerden> extends Mensch {
	void behandeln(T t) {
		t.setGesund(true);
	}
}

public class AufgabeGenericsZoo {

	public static void main(String[] args) {

		Affe affe1 = new Affe();
		System.out.println(affe1);
		
		Zebra zebra1 = new Zebra();
		System.out.println(zebra1);

		Arzt<Affe> affenArzt = new Arzt<>();
		affenArzt.behandeln(affe1);
//		affenArzt.behandeln(zebra1); 
		
		System.out.println(affe1);
		
		Arzt<Tier> tierArzt = new Arzt<>();
		tierArzt.behandeln(affe1);
		tierArzt.behandeln(zebra1);
//		tierArzt.behandeln(new Mensch());
		
		Arzt<Lebewesen> lebewesenArzt = new Arzt<>();
		lebewesenArzt.behandeln(zebra1);
		lebewesenArzt.behandeln(affe1);
		lebewesenArzt.behandeln(affenArzt);
		lebewesenArzt.behandeln(new Mensch());
	}

}
