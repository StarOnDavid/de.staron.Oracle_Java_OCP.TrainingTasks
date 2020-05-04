package _200430_Stream_collect_ShoppingBasket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

public class Collect_ShoppingBasket {
	private static List<Product> shoppingBasket_master = new ArrayList<>();
	private static List<Order> orders = new ArrayList<>();
	private static Map<String, Integer> productPrice = new HashMap<>();
	
	static {
		shoppingBasket_master.add(new Product("Brot", 129));
		shoppingBasket_master.add(new Product("Wurst", 230));
		shoppingBasket_master.add(new Product("Milch", 99));
		shoppingBasket_master.add(new Product("Milch", 99));
		
		orders.add(new Order("Brot", 3));
		orders.add(new Order("Wurst", 1));
		orders.add(new Order("Milch", 2));
		
		for (Product p : shoppingBasket_master) {
			productPrice.put(p.getName(), p.getPrice());
		}
	}

	public static void main(String[] args) {
		a1();
		a2();
		a3();
	}

	private static void a3() {
		System.out.println("*** A3");
		List<Product> shopphingBasket = buildWarenkorb_a3(orders);
		shopphingBasket.stream().forEach(System.out::println);
		
		System.out.println();
	}
	
	private static List<Product> buildWarenkorb_a3(List<Order> orders) {
		List<Product> shoppingBasket = new ArrayList<>();
		orders.stream()
			.flatMap(order -> { List<Product> tempProducts = new ArrayList<>();
								for(int i = 0; i < order.getQuantity(); i++) {
									tempProducts.add(new Product(order.getProductName(), productPrice.get(order.getProductName())));
									}
								return tempProducts.stream();	
								}
			)
			.forEach(p -> shoppingBasket.add(p));
		
		return shoppingBasket;
	}

	private static void a2() {
		System.out.println("*** A2");
		List<Product> shopphingBasket = buildWarenkorb_a2(orders);

		shopphingBasket.stream().forEach(System.out::println);
		
		System.out.println();
	}
	
	private static List<Product> buildWarenkorb_a2(List<Order> orders) {
		Function<Order, Stream<Product>> mapper = order -> {
			Product tempProd = getProduct_a2(order.getProductName());
			List<Product> tempProducts = new ArrayList<>();
			for(int i = 0; i < order.getQuantity(); i++) {
				tempProducts.add(tempProd);
			}
			return tempProducts.stream();
		};
		
		List<Product> shoppingBasket = new ArrayList<>();
		
		orders.stream()
			.flatMap(mapper)
			.forEach(p -> shoppingBasket.add(p));
		return shoppingBasket;
	}

	private static Product getProduct_a2(String productName) {
		Optional<Product> tempPro = shoppingBasket_master.stream().reduce((p1, p2) -> {return p1.getName() == productName ? p1 : p2;});
		
		if(tempPro.isPresent() && tempPro.get().getName() == productName)
			return tempPro.get();
		
		return new Product("Unknown", 0);
	}

	private static void a1() {
		System.out.println("*** A1");
		BinaryOperator<Integer> accumulator = (p1, p2) -> { return p1 + p2;};
		Optional<Integer> sumPrices = shoppingBasket_master.stream()
											.map(p -> p.getPrice())
											.reduce(accumulator);
		if(sumPrices.isPresent()) {
			System.out.println("Sum of prices is: " + sumPrices.get());
		} else {
			System.out.println("Empty!!!");
		}
		
		System.out.println();
	}

}
