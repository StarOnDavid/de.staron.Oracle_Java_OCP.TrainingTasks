package _200401_InnerClass_Building;

import java.util.ArrayList;
import java.util.List;

public class Gebaeude {
	
	public class Stockwerk {

		public class Raum {
			private int nummer;
			
			public Raum(int nummer) {
				this.nummer = nummer;
			}
			public String toString() { // Raum 0.2 / Hauptstr. 45
				return "Raum " + Stockwerk.this.nummer + "." + nummer + " / " 
									+ strasse + " " + Gebaeude.this.nummer; 
			}
			
		} // end of Raum
		
		
		private int nummer;
		
		private List<Raum> raeume = new ArrayList<>();
		
		public Stockwerk(int nummer, int anzahlRaeume) {
			this.nummer = nummer;
			
			if(anzahlRaeume<1) {
				throw new IllegalArgumentException("Anzahl der Räume muss größer 0 sein. Übergeben: " + anzahlRaeume);
			}
			
			for (int i = 0; i < anzahlRaeume; i++) {
				raeume.add(new Raum(i));
			}
		}
		
		public Raum getRaum(int nummer) {
			return raeume.get(nummer);
		}
		
	} // end of Stockwerk
	
	private String strasse, nummer;
	
	private List<Stockwerk> stockwerke = new ArrayList<>();
	
	public Gebaeude(String strasse, String nummer, int anzahlStockwerke, int anzahlRaeumeProStockwerk) {
		this.strasse = strasse;
		this.nummer = nummer;
		
		if(anzahlStockwerke<1) {
			throw new IllegalArgumentException("Anzahl der Stockwerke muss größer 0 sein. Übergeben: " + anzahlStockwerke);
		}

		for (int i = 0; i < anzahlStockwerke; i++) {
			stockwerke.add( new Stockwerk(i, anzahlRaeumeProStockwerk) );
		}
	}

	public Stockwerk getStockwerk(int stockwerkNummer) {
		return stockwerke.get(stockwerkNummer);
	}
	
	public Stockwerk.Raum getRaum(int stockwerkNummer, int raumNummer) {
		return getStockwerk(stockwerkNummer).getRaum(raumNummer);
	}
	
}












