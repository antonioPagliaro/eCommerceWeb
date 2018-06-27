package Test;
import eCommerce.*;

public class TestSingleton {
	public static void main(String[] args) throws DecreaseQuantityException {
		ProductList pl= new ProductList();
		Account a=new Account(20.0);
		User u= new User("aaa", "b", "c,", "d",a);
		
		User u2=new User("bbb", "b", "c,", "d",a);
		
		Product p=new Product("1",12.0,"dddddd","scarpe");
		Product p2= new Product("12",1.0,"dafd","maglie");
		Product p3= new Product("1222",1.0,"adfa","maglie");
		pl.addProduct(p);

		pl.addProduct(p2);
		pl.addProduct(p3);
		u.setProductList(pl);
		u2.setProductList(pl);
		
		Cart c=u.getCart();
		c.addUser(u);
		c.addProduct(p);
		c.addProduct(p2);
		
		
	
		Cart c2=u2.getCart();
		c2.addProduct(p3);
		
		System.out.println(c.getProductList());

		System.out.println(c2.getProductList());

	}
}
