package Test;
import eCommerce.*;
public class TestProduct {

	public static void main(String[] args) throws DecreaseQuantityException {
		// TODO Auto-generated method stub
		
		//public Product(String code, double price, String description
		Product p = new Product("12",12.50,"descrizione 1","olio");
		
		//p.decreasesQuantity();
		
		//public Product(String code, double price, String description, int quantity)
		Product p1 = new Product("13",2.50,"vino","descrizione 1",3);
		
		//p1.decreasesQuantity();
		
		
		ProductList lista = new ProductList();
		
		lista.addProduct(p1);
		lista.addProduct(p);
		
		System.out.println(lista.orderPrice());
		
		System.out.println(lista.descendePrice());
		
		
	}

}
