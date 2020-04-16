package _200416_Generics_Zoo;

public class Zoo_run {
	private static Zoo zoo = new Zoo();
	private static Doctor<Monkey> docM = new Doctor<>("Monkey Master");
	private static Doctor<Animal> docA = new Doctor<>("Anis Healer");
	private static Doctor<Treatable> docT = new Doctor<>("Master of the Univers");
	
	public static void main(String[] args) {
		
		
		docM.setHealthy(false);
		
		zoo.addAnimal(new Monkey("Herr Nilsson"));
		zoo.addAnimal(new Monkey("Abu"));
		zoo.addAnimal(new Elephant("Hathi"));
		zoo.addAnimal(new Elephant("Dumbo"));
		zoo.addAnimal(new Suricate("Timon"));
		
		printZoo();

		zoo.getAllAnimals().get(1).setHealthy(false);
		zoo.getAllAnimals().get(3).setHealthy(false);
		zoo.getAllAnimals().get(4).setHealthy(false);
		
		printZoo();
		
//		docM.heal( zoo.getAllAnimals().get(1)); // Comilerfehler - weil DocM nur Monkeys behandeln kann ... cast nötig weil in der Collection Animals gespeichert sind 
		docM.heal((Monkey) zoo.getAllAnimals().get(1));
		
		printZoo();
		
		docA.heal(zoo.getAllAnimals().get(3));
		docA.heal(zoo.getAllAnimals().get(4));
//		docA.heal(docM); // Comilerfehler - DocA kann keine Menschen heilen!
		
		printZoo();
		
		docT.heal(docM);
		
		printZoo();
	}

	private static void printZoo() {
		for(Animal a : zoo.getAllAnimals()) 
			System.out.println(a);
		System.out.println();
		System.out.println((docM));
		System.out.println(docA);
		System.out.println(docT);
		System.out.println("\n");
	}
	
}
