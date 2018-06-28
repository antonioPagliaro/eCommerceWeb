package eCommerceWeb.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eCommerce.DecreaseQuantityException;
import eCommerce.NonDisponibileException;
import eCommerce.Product;
import eCommerce.ProductList;
import eCommerce.User;

/**
 * Servlet implementation class ServletAggiungi
 */
@WebServlet("/ServletAggiungi")
public class ServletAggiungi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAggiungi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getSession().getServletContext();
		User u = (User) context.getAttribute("user");
		
		ProductList pl=(ProductList) context.getAttribute("productList");
	

		String code=request.getParameter("code");
		System.out.println("code "+ code);
		
			Product p=pl.searchByCode(code);
			System.out.println(p);
			try {
				u.getCart().addProduct(p);
			} catch (DecreaseQuantityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NonDisponibileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher dispatcher=request.getRequestDispatcher("ElencoProdotti.jsp");
			dispatcher.forward(request, response);
			
	}

}
