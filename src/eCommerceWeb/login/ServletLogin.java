package eCommerceWeb.login;

import java.io.IOException;
import java.io.PrintWriter;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eCommerce.Product;
import eCommerce.ProductList;
import eCommerce.User;
import eCommerceLogin.Login;
import eCommerceLogin.LoginException;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductList pl = new ProductList();
    /**
     * Default constructor. 
     */
    public ServletLogin() {
        // TODO Auto-generated constructor stub
    }

    public void init() {
    	Product p = new Product("1", 1.0, "prodotto 1","scarpe",1);
    	Product p2 = new Product("2", 2.5, "prodotto 2","maglie",1);
    	Product p3 = new Product("3", 3.0, "prodotto 3","costumi",2);

    	pl.addProduct(p);
    	pl.addProduct(p2);
    	pl.addProduct(p3);
    	
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
		context.setAttribute("productList", pl);
		
		Login login=new Login();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User user=null;
		try {
		 user=	login.signIn(username,password);
		context.setAttribute("user", user);
//		response.setContentType("text/html");
//		PrintWriter pw= response.getWriter();
//		pw.print(user);
		} catch (LoginException e) {
			e.printStackTrace();
		}
		
		
		if(user!=null) {
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("ElencoProdotti.jsp");
			dispatcher.forward(request, response);
			}
		else{
			RequestDispatcher dispatcherErr=request.getRequestDispatcher("AutenticazioneFallita.html");
			dispatcherErr.forward(request, response);
		}

		

	}

}
