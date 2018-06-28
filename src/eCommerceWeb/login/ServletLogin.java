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

import eCommerce.User;
import eCommerceLogin.Login;
import eCommerceLogin.LoginException;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletLogin() {
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
			// TODO Auto-generated catch block
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
