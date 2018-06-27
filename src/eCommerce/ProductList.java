package eCommerce;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ProductList {


	// Attributi
	private List<Product> productList;


	// Costruttore
	public ProductList(List<Product> productList) {
		this.productList = productList;
	}

	public ProductList() {
		this.productList = new ArrayList<Product>();
	}

	// get and set
	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}


	// Aggiungi prodotto
	public void addProduct(Product p) {
		productList.add(p);
	}

	// Rimuovi prodotto
	public void removeProduct(Product p) {
		productList.remove(p);
	}


	public void showAll() {
		for(Product p : productList) {
			System.out.println(p);
		}
	}


	// metodo di ricerca per categoria 

	public List<Product> searchByCategory(String category) {
		List<Product> temp = new ArrayList<Product>();
		for (Product p: productList) {
			if(p.getcategory().equals(category)) {
				temp.add(p);
			}
		}return temp;
	}

	// metodo di ricerca per prezzo
	public List<Product> searchByPrice(double min, double max) {
		List<Product> temp = new ArrayList<Product>();
		for (Product p: productList) {
			if(p.getPrice() <= max && p.getPrice() >= min){
				temp.add(p);
			}
		}return temp;
	}

	// Metodo per ordinare in modo ascendente il prezzo
	public ArrayList<Product> orderPrice(){
		ArrayList<Product> catalogoOrdinato = (ArrayList<Product>) productList;
		Collections.sort(catalogoOrdinato, new Comparator<Product>(){
			@Override
			public int compare(Product o1, Product o2){
				return ((Double)o1.getPrice()).compareTo(o2.getPrice());
			}
		});
		return catalogoOrdinato;   
	}


	// Metoto per ordinare in modo discendente il prezzo
	public ArrayList<Product> descendePrice(){
		ArrayList<Product> catalogoOrdinato = orderPrice();

		Collections.reverse(catalogoOrdinato);
		return catalogoOrdinato; 

	}

	public boolean isDisponibile(Product product) {
		for(Product p : productList) {
			if(p.getCode().equals(product.getCode())){
				if(p.getQuantity()>0) 
					return true;
				}
			}
		
		return false;
	}

	public void decreaseQuantity(Product product) throws DecreaseQuantityException {
		for(Product p : productList) {
			if(p.getCode().equals(product.getCode())){
				p.decreasesQuantity();
			}
		}
	}
	
	
	public void increaseQuantity(Product product) throws DecreaseQuantityException {
		for(Product p : productList) {
			if(p.getCode().equals(product.getCode())){
				p.increaseQuantity();
			}
		}
	}


}


