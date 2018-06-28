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
<form action="ServletAggiungi" method="post">
<h1><b>Elenco Prodotti</b></h1>
	<%
    ServletContext context = request.getSession().getServletContext();
	User u = (User) context.getAttribute("user");
	
	ProductList pl=(ProductList) context.getAttribute("productList");

	//User u1 = new User("toni", "pag", "toni", "pass");
    Account account=new Account(18.0);
	u.setAccount(account);

   Cart cart= u.getCart();
	u.setProductList(pl);

	cart.addUser(u); 
	%>
<table>
    <tr><td>Codice</td><td>Prezzo</td><td>Descrizione</td><td>Categoria</td><td>Aggiungi al Carrello</td></tr>
    <% for(Product q : pl.getProductList()){%>
		<tr>
			<td><%=q.getCode()%></td>
			<td><%=q.getPrice()%></td>
			<td><%=q.getDescription()%></td>
			<td><%=q.getcategory()%></td>
			 <td><button type="submit" name="code" value="<%=q.getCode()%>">Aggiungi al carrello</button></td>
			</tr>
		<%}%> 
</table></form>
</body>
</html>