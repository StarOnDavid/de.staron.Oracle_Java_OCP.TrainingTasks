package _200422_Stream_bilden;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Stream_bilden_run {

	public static void main(String[] args) {
		Stream_bilden sb = new Stream_bilden();

		try {
			//A1
			printTask("Aufgabe 1 - as for-loop", "a1_for", new Class[0], new Object[0], sb);
			printTask("Aufgabe 1 - as pipeline", "a1_pipe", new Class[0], new Object[0], sb);
			
			//A2
			int numOf = 3; // statt 100 Random Zahlen wie in der Aufgabe hier frei wählbar.
			printTask("Aufgabe 2 - as for-loop", "a2_for", new Class[] {int.class}, new Object[] {numOf}, sb);
			printTask("Aufgabe 2 - as pipeline", "a2_pipe", new Class[] {int.class}, new Object[] {numOf}, sb);
			
			//A3
			numOf = 3; // statt von 100 runter wie in der Aufgabe hier frei wählbar.
			printTask("Aufgabe 3 - as for-loop", "a3_for", new Class[] {int.class}, new Object[] {numOf}, sb);
			printTask("Aufgabe 3 - as pipeline", "a3_pipe", new Class[] {int.class}, new Object[] {numOf}, sb);
			
			//A4
			numOf = 3; // statt von 100 runter wie in der Aufgabe hier frei wählbar.
			printTask("Aufgabe 4 - as for-loop", "a4_for",  new Class[0], new Object[0], sb);
			printTask("Aufgabe 4 - as pipeline", "a4_pipe",  new Class[0], new Object[0], sb);
			
			//A4
			numOf = 3; // statt von 100 runter wie in der Aufgabe hier frei wählbar.
			printTask("Aufgabe 5 - as for-loop", "a5_for",  new Class[0], new Object[0], sb);
			printTask("Aufgabe 5 - as pipeline", "a5_pipe",  new Class[0], new Object[0], sb);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* Nach dem lösen der 2. Aufgabe entstand die Idee aus einer Methode eine andere Methode auf zu rufen deren Name der ersten übergeben wird.
	 * In etwa so: 
	 * 		methodePrintTask ( param 'message', param 'aufZuRufendeMethode' ) {
	 * 			sysout -> 'message'
	 * 			
	 * 			Aufruf -> 'aufZuRufendeMethode'
	 * 
	 * 			sysout -> newLine
	 *		}
	 * 	
	 * Bei der Suche nach einer Lösung bin ich auf 'Refections' gestoßen. 
	 * Ein mächtiges Werkzeug, was in diesem fall wirkt wie mit 'Kanonen auf Spatzen geschossen'.
	 * 
	 * Entsprechende Links:
	 * https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/package-summary.html
	 * https://www.dpunkt.de/java/Die_Sprache_Java/Objektorientierte_Programmierung_mit_Java/70.html
	 * 
	 * Hier die daraus resultierende 'printTask'-Methode:
	 */
	private static void printTask (String message, String methodName, @SuppressWarnings("rawtypes") Class[] signature,
   			Object[] parameters, Object target) throws Exception{
		System.out.println(message);
		
		Method m = target.getClass().getDeclaredMethod(methodName, signature);
		   
   		if (Modifier.isPrivate(m.getModifiers())) {
   			m.setAccessible(true);
   		}
   
   		m.invoke(target, parameters);
   		
   		System.out.println();
	}
}
