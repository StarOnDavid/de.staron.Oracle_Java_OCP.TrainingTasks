package Functional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

public class _200421_Optional_Comperator_BiFunction {
	private static List<String> listOfPopStars = new ArrayList<>();
	private static List<Double> listOfImportantNums = new ArrayList<>();
	
	static {
		listOfPopStars.add("Madonna Louise Ciccone");
		listOfPopStars.add(null);
		listOfPopStars.add("Shakira Isabel Mebarak Ripoll");
		listOfPopStars.add(null);
		listOfPopStars.add("Beyoncé Giselle Knowles-Carter");
		
		listOfImportantNums.add(3.14159265358979323846); // PI: Verhältnis des Umfangs zum Durchmesser eines Kreises.
		listOfImportantNums.add(null);
		listOfImportantNums.add(2.71828182845904523536); // Eulersche Zahl: Basis des natürlichen Logarithmus
		listOfImportantNums.add(null);
		listOfImportantNums.add(null);
		listOfImportantNums.add(1.61803398874989484820); // Goldener Schnitt:Größenverhältnis, das vielfach näherungsweise in der belebten und unbelebten Natur auftritt 
		listOfImportantNums.add(4.66920160910299067185); //Übergang ins Chaos: Bifurkationsgeschwindigkeit 
	}

	public static void main(String[] args) {
		System.out.println("Orginal ListOfPopStars: " + listOfPopStars);
		
		Comparator<String> cmpLength = Comparator.comparing(String::length);
		
//		list.sort(cmpLength); // NullPointerException
		
		BiFunction<List<String>, Comparator<String>, List<String>> bf1 = _200421_Optional_Comperator_BiFunction::sortListWithNullValue;
		
		listOfPopStars = bf1.apply(listOfPopStars, cmpLength);
		System.out.println("Length sorted ListOfPopStars: " + listOfPopStars);
		
		System.out.println("\nOrginal ListOfImportantNumbers: " + listOfImportantNums);
	
		Comparator<Double> cmpaCos = Comparator.comparing(Math::acos);
		BiFunction<List<Double>, Comparator<Double>, List<Double>> bf2 = _200421_Optional_Comperator_BiFunction::sortListWithNullValue;
		listOfImportantNums = bf2.apply(listOfImportantNums, cmpaCos);
		
		System.out.println("rInt sorted ListOfImportantNumbers: " + listOfImportantNums);
		
	}
	
	void test () {
		
	}
	
	private static <T> List<T> sortListWithNullValue(List<T> list, Comparator<T> cmp ){
		List<Optional<T>> optList = new ArrayList<>();
		int countNull = 0;
		for (T t : list) {
			optList.add( getOptional(t) );
		}
		list.clear();
		
		for (Optional<T> o : optList) {
			if(o.isPresent())
				list.add(o.get());
			else
				countNull++;
		}
		list.sort(cmp);
		for(int i = 0; i < countNull; i++) {
			list.add(null);
		}
		return list;
	}
	
	private static <T> Optional<T> getOptional(T t) {
		if( t == null)
			return Optional.empty();
		
		return Optional.of(t);
	}
}
