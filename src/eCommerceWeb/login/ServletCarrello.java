package eCommerceWeb.login;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eCommerce.DecreaseQuantityException;
import eCommerce.IncreaseQuantityException;
import eCommerce.Product;
import eCommerce.ProductList;
import eCommerce.User;

/**
 * Servlet implementation class ServletCarrello
 */
@WebServlet("/ServletCarrello")
public class ServletCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCarrello() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getSession().getServletContext();
		User u = (User) context.getAttribute("user");

		Enumeration<String> list=request.getParameterNames();
		while (list.hasMoreElements()) {
			if(list.nextElement().equals("add")) {
				
			


			String code=request.getParameter("add");
			ProductList pl=(ProductList) context.getAttribute("productList");

			Product p=pl.searchByCode(code);
			try {
				u.getCart().addPezzo(p);
			} catch (IncreaseQuantityException | DecreaseQuantityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			RequestDispatcher dispatcher=request.getRequestDispatcher("Carrello.jsp");
			dispatcher.forward(request, response);
			}

		}

	}
	
}
