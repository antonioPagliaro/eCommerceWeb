package eCommerce;

public class User {
	
	//Attributi della classe
	private String name;
	private String surname;
	private String username;
	private String password;
    private Cart cart;
    private Account account;
    private ProductList productList;

	


	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public ProductList getProductList() {
		return productList;
	}

	public void setProductList(ProductList productList) {
		this.productList = productList;
	}

	//Costruttori della classe
	public User(String name, String surname, String username, String password,Account account) {
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.account=account;
		addCart();
	}

	
	
	public User(String name, String surname, String username, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.addCart();
	}

	// Metodio Get and Set

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", username=" + username + ", password=" + password
				+ "]";
	}
	
	
	
	
	
	public void addCart() {
		this.cart=Cart.getIstance();
	}
	
	
	
	
	
	

}
