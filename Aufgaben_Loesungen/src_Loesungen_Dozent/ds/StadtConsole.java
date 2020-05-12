package ds;

import java.util.List;

public class StadtConsole {

	static void printTable(List<Stadt> list) {
	
		// | Nr. | Stadt	| Einwohner | Bundesland |
		
		String fmt = "| %3s | %-22s | %9s | %-22s |%n";
		
		String header = String.format(fmt, 
					"Nr.", "Stadt", "Einwohner", "Bundesland");
		
		printDiv(header.length());
		System.out.print(header);
		printDiv(header.length());
		
		for (int i = 0; i < list.size(); i++) {
			
			Stadt s = list.get(i);
			
			System.out.format(fmt,
						i+1, 
						s.getName(),
						s.getEinwohner(),
						s.getLand() );
			
		}
		
		printDiv(header.length());
		System.out.print(header);
		printDiv(header.length());
	}
	
	private static void printDiv(int headerWidth) {
		for (int i = 0; i < headerWidth-2; i++) {
			System.out.print('-');
		}
		System.out.println();
	}
}
