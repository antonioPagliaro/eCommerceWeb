package Test;

import eCommerce.Cart;
import eCommerce.DecreaseQuantityException;
import eCommerce.IncreaseQuantityException;
import eCommerce.Product;
import eCommerce.ProductList;
import eCommerce.User;

public class TestAddItem {
	public static void main(String[] args) throws IncreaseQuantityException, DecreaseQuantityException {
		ProductList pl = new ProductList();
		Product p = new Product("1", 1.0, "prodotto 1","scarpe",1);
		Product p2 = new Product("2", 2.5, "prodotto 2","maglie",1);
		Product p3 = new Product("3", 3.0, "prodotto 3","costumi",2);

		pl.addProduct(p);
		pl.addProduct(p2);

		pl.addProduct(p3);



		User user =new User("fabio", "surname", "f.01", "345");
		user.setProductList(pl);
		Cart c=user.getCart();
		c.addUser(user);
		c.addProduct(p);
		c.addProduct(p2);
		c.addProduct(p3);
		System.out.println(c.getProductList());
		
		c.removePezzo(p3);
		System.out.println(c.getProductList());
		
		c.addPezzo(p3);
		System.out.println(c.getProductList());

	}

}
