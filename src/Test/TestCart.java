package Test;
import eCommerce.*;
import eCommerceLogin.Login;
import eCommerceLogin.LoginException;
public class TestCart {
	public static void main(String[] args) throws AccountOperationException, LoginException, DecreaseQuantityException, IncreaseQuantityException {

		//		
		//		Login l = new Login();
		//		
		//		User u = l.signIn();

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



		System.out.println("Totale prezzo ="+cart.getTotalAmount());
		System.out.println("Carrello utente "+u.getCart().getProductList());
		//		
		System.out.println("elenco generale 2");
		//
		pl.showAll();


		cart.removeProduct(p);
		System.out.println("Carrello utente "+u.getCart().getProductList());
		pl.showAll();


		cart.addPezzo(p3);
		System.out.println("Carrello utente "+u.getCart().getProductList());
		pl.showAll();



		cart.removePezzo(p3);
		System.out.println("Carrello utente "+u.getCart().getProductList());
		pl.showAll();
		
		
		

		//		System.out.println("Conto utente prima del pagamento:"+u.getAccount().getBalance());
		//		Purchase purchase=new Purchase(cart);
		//		purchase.makePurchaseWithCreditCard();
		//		System.out.println("Conto utente dopo del pagamento:"+u.getAccount().getBalance());
		//		
		//		
		//		
		//		
		//		System.out.println("Rimozione carrello");
		//		purchase.abort();
		//		
		//		
		//		
		//		System.out.println("elenco generale 3 ");
		//		pl.showAll();
		//		System.out.println("Carrello utente "+u.getCart().getProductList());

	}
}
