package Test;
import eCommerceLogin.*;
import java.util.Scanner;

public class TestLogin {
	public static void main(String[] args) throws LoginException {
		Login login=new Login();
		Scanner s=new Scanner(System.in);
		System.out.println("Inserisci username");
		String username=s.nextLine();
		System.out.println("Inserisci password");
		String password=s.nextLine();
//		
//		try {
//			login.signIn();
//		}catch(LoginException e) {
//			System.out.println(e.getMessage());
//		}
	}
}
