package Test;

import java.util.Date;

import eCommerce.Account;
import eCommerce.AccountOperationException;
import eCommerce.Cart;
import eCommerce.Check;
import eCommerce.DecreaseQuantityException;
import eCommerce.PaymentWithCC;
import eCommerce.PaymentWithCheck;
import eCommerce.PaymentWithCheckException;
import eCommerce.Product;
import eCommerce.ProductList;
import eCommerce.Purchase;
import eCommerce.User;

public class TestPayment {
	public static void main(String[] args) throws DecreaseQuantityException, AccountOperationException, PaymentWithCheckException {
		User u = new User("toni", "pag", "toni", "pass");
		System.out.println(u);
		Product p = new Product("1", 1.0, "prodotto 1","scarpe",1);
		Product p2 = new Product("2", 2.5, "prodotto 2","maglie",1);
		Product p3 = new Product("3", 3.0, "prodotto 3","costumi",2);



		ProductList pl= new ProductList();
		pl.addProduct(p);
		pl.addProduct(p2);
		pl.addProduct(p3);

		System.out.println("elenco generale 1");
		pl.showAll();


		Account account=new Account(18.0);
		u.setAccount(account);

		Cart cart= u.getCart();
		u.setProductList(pl);

		Cart cart2=u.getCart();
		cart2.addUser(u);

		cart.addUser(u);
		cart.addProduct(p);
		cart.addProduct(p2);
		cart2.addProduct(p3);
		
		System.out.println("balance conto utente "+u.getAccount().getBalance());
		System.out.println("Totale prezzo ="+cart.getTotalAmount());
//		PaymentWithCC payCC=new PaymentWithCC();
//		Purchase purchase = new Purchase(cart, payCC);
//		purchase.makePurchaseWithCreditCard();
		
		Date date=new Date("2018/6/25");
		 Check check=new Check( date ,6.5);
		
		PaymentWithCheck payCheck = new PaymentWithCheck(check);
		Purchase purchase = new Purchase(cart, payCheck);
		purchase.makePurchaseWithCheck(check);
		System.out.println("balance conto utente "+u.getAccount().getBalance());

	}
}
