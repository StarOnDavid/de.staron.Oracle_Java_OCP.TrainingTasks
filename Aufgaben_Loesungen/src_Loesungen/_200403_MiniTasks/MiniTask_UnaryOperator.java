package _200403_MiniTasks;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class MiniTask_UnaryOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		miniTask();
	}
	
	static void miniTask() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		
		/* 
		 * Die 'computeAndReplace' soll jedes Element der Liste mit dem Ergebnis
		 * der Berechnung ersetzen, die als 'berechnung'-Parameter der Methode übergeben wird.
		 * 'berechnung' wird also jedes Element der Liste als Eingang bekommen und damit ein 
		 * Ergebnis berechnen.
		 * Testen sie die neue Methode mit der 'berechnung', die den Eingang mit 10 multipliziert
		 */
		UnaryOperator<Integer> compute = i -> i * 10;
		
		computeAndReplace(list, compute);
		System.out.println(list); // Soll Ergebniss: [10, 20, 30, 40]
	}
	
	static void computeAndReplace(List<Integer> list, UnaryOperator<Integer> compute) {
//		for(int i = 0; i < list.size(); i++) {
//			list.set(i, compute.apply(list.get(i)));	
//		}
		list.replaceAll(compute);
	}
	
	

}
