<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="eCommerce.Product,eCommerce.ProductList,eCommerce.User,eCommerce.Cart,eCommerce.Account" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Elenco Prodotti</title>
</head>
<body BACKGROUND="https://st2.depositphotos.com/2082539/11583/i/950/depositphotos_115836148-stock-photo-fly-on-a-wooden-board.jpg" TEXT="white">
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
    <tr><td><h3>Codice</td></h3><td><h3>Prezzo</td></h3><td><h3>Descrizione</td></h3><td><h3>Categoria</td></h3><td><h3>Aggiungi al Carrello</td></h3></tr>
    <% for(Product q : pl.getProductList()){%>
		<tr>

			<td><h3><%=q.getCode()%></h3></td>
			<td><h3><%=q.getPrice()%></h3></td>
			<td><h3><%=q.getDescription()%></h3></td>
			<td><h3><%=q.getcategory()%></h3></td>
			<td><button onclick=<%cart.addProduct(q); %>>Aggiungi al Carrello</button></td>

			<td><%=q.getCode()%></td>
			<td><%=q.getPrice()%></td>
			<td><%=q.getDescription()%></td>
			<td><%=q.getcategory()%></td>
			 <td><button type="submit" name="code" value="<%=q.getCode()%>">Aggiungi al carrello</button></td>

			</tr>
		<%}%> 
</table>
</form>
<FONT SIZE="2">PEZZI NEL CARRELLO <%=u.getCart().getProductList().size() %></FONT><br>
<form action="Carrello.jsp" method="post">
<button type="submit" name="carrello">Vai al carrello</button>
</form>
</body>
</html>