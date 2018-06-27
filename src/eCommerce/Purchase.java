package eCommerce;

import eCommerce.model.Payment;

public class Purchase {
	
	

	Cart cart;
	Payment payment;
	
	public Purchase(Cart cart,Payment payment) {
		this.payment=payment;
		this.cart=cart;
	}
	
	
	public void makePurchaseWithCreditCard() throws AccountOperationException  {
//		 makePaymentWithCreditCard();
		payment.makePayment(cart.getUser().getAccount(), cart.getTotalAmount());
		 cart.cleanCart();
		
	}
	
	public void makePurchaseWithCheck(Check check) throws AccountOperationException, PaymentWithCheckException  {
		// makePaymentWithCheck(check);
		payment.makePayment(cart.getUser().getAccount(), cart.getTotalAmount());
		 cart.cleanCart();
		
	}
	
	
//	private void makePaymentWithCheck(Check check) throws AccountOperationException, PaymentWithCheckException {
//		cart.getUser().getAccount().
//		withdrawWithCheck(check);
//		
//	}
//
//
//	private void makePaymentWithCreditCard() throws AccountOperationException {
//		cart.getUser().getAccount().withdraw(cart.getTotalAmount());
//	}
	
	public void abort() {
		cart.removeAll();
		
	}
	
}
