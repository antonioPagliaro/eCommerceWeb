package eCommerce;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart {

	private List<Product> productList;
	private User user;

	private static Cart istance=null; //riferimento all' istanza



	public static Cart getIstance() {
		synchronized(Cart.class) {
			if( istance == null )
				istance = new Cart();
		}
		return istance;
	}


	private Cart () {
		productList=new ArrayList<Product>();
	}

	public void addUser(User user) {
		this.user=user;
	}
	public User getUser() {
		return user;
	}




	public void addProduct( Product product) throws DecreaseQuantityException {
		Product prodottoAggiunto=new Product(product.getCode(),product.getPrice(),product.getDescription(),product.getcategory(),1);
		if(user.getProductList().isDisponibile(product)) {
			user.getProductList().decreaseQuantity(product);
			productList.add(prodottoAggiunto);

		}
	}

	public void removeProduct(Product product) throws DecreaseQuantityException {
		Iterator<Product> iterator = productList.iterator();
		while (iterator.hasNext()) {
			Product p=	iterator.next();
			if(p.getCode().equals(product.getCode())) {
				iterator.remove();
				int q=p.getQuantity();
				for(int i=0;i<q;i++)
					user.getProductList().increaseQuantity(product);

			}
		}
	}



	public boolean addPezzo(Product product) throws IncreaseQuantityException, DecreaseQuantityException {
		if(user.getProductList().isDisponibile(product)) {	//verifica disponibilità nel magazzino

			for(Product p : productList) {
				if(p.getCode().equals(product.getCode())){
					p.increaseQuantity();
					user.getProductList().decreaseQuantity(product);
					return true;
				}
			}return false;
		}
		throw new IncreaseQuantityException();
	}



	public boolean removePezzo(Product product) throws DecreaseQuantityException {
		for(Product p : productList) {
			if(p.getCode().equals(product.getCode())){
				p.decreasesQuantity();
				user.getProductList().increaseQuantity(product);
				return true;
			}
		}
		throw new DecreaseQuantityException();
	
	
}


public double getTotalAmount() {
	double total=0.0;

	for( Product p : productList) {
		total=total+(p.getPrice()*p.getQuantity());
	}
	return total;
}

//reset productList status
public void removeAll() {
	//usare iterator
	Iterator<Product> iterator = productList.iterator();
	while (iterator.hasNext()) {
		Product p=	iterator.next();
		user.getProductList().getProductList().add(p);
		iterator.remove();
	}

}

public void cleanCart() {
	Iterator<Product> iterator = productList.iterator();
	while (iterator.hasNext()) {
		Product p=	iterator.next();
		iterator.remove();
	}
}



public void setUser(User user) {
	this.user = user;
}

public List<Product> getProductList() {
	return productList;
}

public void setProductList(List<Product> productList) {
	this.productList = productList;
}



}
