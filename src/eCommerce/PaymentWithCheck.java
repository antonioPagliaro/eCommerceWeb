package eCommerce;

import java.util.Date;

import eCommerce.model.Payment;

public class PaymentWithCheck implements Payment{

	Check check;
	public  PaymentWithCheck(Check check) {
	this.check=check;
		}
	
	@Override
	public void makePayment(Account a,double value) {
			//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/M/yyyy");
			Date dateDay = new Date();
			if (check.getDate().equals(dateDay)|| dateDay.after(check.getDate())) {
				if(check.getImporto()==value) {
					try {
						a.withdraw(value);
					} catch (AccountOperationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else System.out.println("Importo assegno non corrispondente");	
			}
			else {
				System.out.println("Non è ancora possibile incassare l'assegno. Torna domani...");
			}
		}

}
	

