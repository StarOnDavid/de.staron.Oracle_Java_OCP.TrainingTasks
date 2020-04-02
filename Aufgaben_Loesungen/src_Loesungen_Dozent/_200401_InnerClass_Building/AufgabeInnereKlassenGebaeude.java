package _200401_InnerClass_Building;

public class AufgabeInnereKlassenGebaeude {

	public static void main(String[] args) {

		int anzahlStockwerke = 3;
		int anzahlRaeumeProStockwerk = 10;
		Gebaeude g1 = new Gebaeude("Hauptstr.", "45", anzahlStockwerke, anzahlRaeumeProStockwerk);
//		System.out.println(g1);
		
		Gebaeude.Stockwerk sw0 = g1.getStockwerk(0);  
//		System.out.println(sw0);
		
		int stockwerkNummer = 0, raumNummer = 2; 
		Gebaeude.Stockwerk.Raum r1 = g1.getRaum(stockwerkNummer, raumNummer);
		
		System.out.println(r1); // Raum 0.2 / Hauptstr. 45
		
	}

}
