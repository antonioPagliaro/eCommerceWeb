package eCommerceLogin;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import eCommerce.Account;
import eCommerce.User;

public class Login {
	
	private Map<String,String> users;
	private Map<String, User> utenti;
	
	
	public Login() {
		initData();
		insUtente();
	}
	
	private void initData() {
		users=new HashMap<String,String>();
		users.put("toni", "toni88");
		users.put("fabio", "fabio95");
		users.put("firno", "firno87");
		users.put("domenico", "guida89");
	}
	
	private void insUtente() {
		//public User(public User(String name, String surname, String username, String password))
		User u1 = new User("toni", "pag", "toni", "pass");
		User u2 = new User("domenico", "guida", "domenico", "1806");
		User u3 = new User("firno", "abio", "firno", "1806");
		User u4 = new User("fabio", "spagna", "fabio", "1806");
		
		
		utenti=new HashMap<String,User>();
		utenti.put(u1.getUsername(), u1);
		utenti.put(u2.getUsername(), u2);
		utenti.put(u3.getUsername(),u3);
		utenti.put(u4.getUsername(), u4);
	}

	public User signIn(String username,String password) throws LoginException {
//		Scanner input = new Scanner(System.in);
//		System.out.println("Inserisci username");
//		String username = input.nextLine();
//		System.out.println("Inserisci password");
//		String password = input.nextLine();
		if (users.get(username)==null)throw new LoginException();
		if(users.get(username).equals(password)) {
			User u = utenti.get(username);
			System.out.println("Login complete");
			return u;
		}
		else 
			throw new LoginException();
	}
}
