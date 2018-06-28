package eCommerceWeb.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eCommerce.Account;
import eCommerce.AccountOperationException;
import eCommerce.PaymentWithCC;
import eCommerce.Purchase;
import eCommerce.User;
import eCommerce.model.Payment;

/**
 * Servlet implementation class ServletPagamento
 */
@WebServlet("/ServletPagamento")
public class ServletPagamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPagamento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getSession().getServletContext();
		User u = (User) context.getAttribute("user");
		
		Account a = u .getAccount();
		double value = u.getCart().getTotalAmount();
		
		Payment payment=new PaymentWithCC();
		payment.makePayment(a, value);
		Purchase purchase = new Purchase(u.getCart(), payment);
		try {
			purchase.makePurchaseWithCreditCard();
		} catch (AccountOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("PagamentoEffettuato.jsp");
		dispatcher.forward(request, response);
	}

}
