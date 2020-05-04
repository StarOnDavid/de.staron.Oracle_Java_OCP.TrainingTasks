package _200430_Stream_collect_ShoppingBasket;

public class Order {
	private String productName;
	private int quantity; // gewünschte Anzahl der Produkt-Objekte
	
	public Order(String productName, int quantity) {
		this.productName = productName;
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	// Konstruktoren und Methoden hier, wenn nötig...
}
