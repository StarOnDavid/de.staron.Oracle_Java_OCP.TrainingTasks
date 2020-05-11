package _200403_MiniTasks;

import java.util.function.Consumer;

public class MiniTask_Consumer {

	public static void main(String[] args) {

		miniTask();
	}

	static void miniTask() {
		/*
		 * Methode useRandom entwickeln, die die gewünschte Anzahl der zufälligen Integer
		 * erzeugt und dem Consumer übergibt.
		 * 
		 */
		Consumer<Integer> c1 = i -> System.out.println(i); // Consumer soll Integer auf der Konsole ausgeben.
		
		useRandom(5, c1); // 5 Zufallswerte generiert
		
	} 
	
	static void useRandom(int anzahlWerte, Consumer<Integer> c) {
		for (int i = 0; i < anzahlWerte; i++) {
			int value = (int)(Math.random() * 100);
			c.accept(value);
		}
	}
}
