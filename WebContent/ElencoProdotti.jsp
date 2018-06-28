<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="eCommerce.Product,eCommerce.ProductList,eCommerce.User,eCommerce.Cart,eCommerce.Account" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Elenco Prodotti</title>
</head>
<body>
<h1><b>Elenco Prodotti</b></h1>
	<%
    ServletContext context = request.getSession().getServletContext();
	User u = (User) context.getAttribute("user");
	
	ProductList pl = new ProductList();
	Product p = new Product("1", 1.0, "prodotto 1","scarpe",1);
	Product p2 = new Product("2", 2.5, "prodotto 2","maglie",1);
	Product p3 = new Product("3", 3.0, "prodotto 3","costumi",2);

	pl.addProduct(p);
	pl.addProduct(p2);
	pl.addProduct(p3);

	User u1 = new User("toni", "pag", "toni", "pass");
    Account account=new Account(18.0);
	u1.setAccount(account);

   Cart cart= u1.getCart();
	u1.setProductList(pl);

	cart.addUser(u1); 
	%>
<table>
    <tr><td>Codice</td><td>Prezzo</td><td>Descrizione</td><td>Categoria</td><td>Aggiungi al Carrello</td></tr>
    <% for(Product q : pl.getProductList()){%>
		<tr>
			<td><%=q.getCode()%></td>
			<td><%=q.getPrice()%></td>
			<td><%=q.getDescription()%></td>
			<td><%=q.getcategory()%></td>
			<td><button onclick=<%cart.addProduct(q); %>>Aggiungi al Carrello</button></td>
			</tr>
		<%}%> 
</table>
</body>
</html>