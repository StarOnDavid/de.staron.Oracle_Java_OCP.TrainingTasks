# Aufgabe 'reduce - StringBuilder'

#### A1. Optional
Gegeben ist folgender nicht korrekte Code, der alle Strings aus dem Array in einem StringBuilder sammelt:

		/*
			Achtung! So sollte die reduce nicht verwendet werden!
		 */		
		String[] array = { "a", "b", "c", "d" };
		
		StringBuilder idt = new StringBuilder();
		BiFunction<StringBuilder, String, StringBuilder> acc = new BiFunction<StringBuilder, String, StringBuilder>() {
			public StringBuilder apply(StringBuilder t, String u) {
				return t.append(u);
			}
		};
		
		BinaryOperator<StringBuilder> comb = (sBuilder1, sBuilder2) -> sBuilder1; 
		
		StringBuilder result = Stream.of(array).reduce(idt, acc, comb);
		
		System.out.println("result: " + result);

Überlegen Sie, was mit dem Code nicht stimmt.

#### A2.
Gegeben ist folgender modifizierte Code:

		String[] array = { "a", "b", "c", "d" };
		
		StringBuilder idt = new StringBuilder();
		BiFunction<StringBuilder, String, StringBuilder> acc = new BiFunction<StringBuilder, String, StringBuilder>() {
			public StringBuilder apply(StringBuilder t, String u) {
				return new StringBuilder(t).append(u);
			}
		};
		
		BinaryOperator<StringBuilder> comb = (sBuilder1, sBuilder2) -> 
								sBuilder1.append(sBuilder2);  
		
		StringBuilder result = Stream.of(array).reduce(idt, acc, comb);
		
		System.out.println("result: " + result);

Was bewirken die Änderungen?
