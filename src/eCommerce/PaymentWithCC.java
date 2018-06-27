package eCommerce;

import eCommerce.model.Payment;

public class PaymentWithCC implements Payment{

	@Override
	public void makePayment(Account a,double value) {
		try {
			a.withdraw(value);
		} catch (AccountOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
