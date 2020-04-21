package _200420_BiFunction_MethodReference;

import java.util.function.BiFunction;

public class AufgabeBiFunctionMethodReference {

	public static void main(String[] args) {

		/*
		 * A1
		 */
		BiFunction<Auto, Integer, Besitzer> f1 = new BiFunction<> () {
			public Besitzer apply(Auto a, Integer i) {
				return new Besitzer(a, i);
			}
		};
		
		Besitzer b1 = f1.apply(new Auto(), 1);
		System.out.println("b1: " + b1);
		
		/*
		 * A2
		 */
		BiFunction<Auto, Integer, Besitzer> f2 = (a, i) -> new Besitzer(a, i);
		Besitzer b2 = f2.apply(new Auto(), 2);
		System.out.println("b2: " + b2);

		/*
		 * A3
		 */
		
//		BiFunction<Auto, Integer, Besitzer> f3 = new BiFunction<> () {
//			public Besitzer apply(Auto a, Integer i) {
//				return Besitzer.createInstance(a, i);
//			}
//		};
		
		BiFunction<Auto, Integer, Besitzer> f3 = Besitzer::createInstance;
		Besitzer b3 = f3.apply(new Auto(), 3);
		System.out.println("b3: " + b3);
		
		/*
		 * A4
		 */
		BiFunction<Auto, Integer, Besitzer> f4 = Besitzer::new;
		Besitzer b4 = f4.apply(new Auto(), 4);
		System.out.println("b4: " + b4);
		
		/*
		 * A5
		 */
		BesitzerBuilder builder = new BesitzerBuilder();
		
//		BiFunction<Auto, Integer, Besitzer> fa = new BiFunction<>() {
//			public Besitzer apply(Auto a, Integer id) {
//				return builder.build(a, id);
//			}
//		};
		BiFunction<Auto, Integer, Besitzer> f5 = builder::build;
		Besitzer b5 = f5.apply(new Auto(), 5);
		System.out.println("b5: " + b5);
		
		/*
		 * A6
		 */
		BiFunction<Auto, Integer, Besitzer> f6 = Auto::buildBesitzer;
		Besitzer b6 = f6.apply(new Auto(), 6);
		System.out.println("b6: " + b6);
		
		
	} // end of main

}
