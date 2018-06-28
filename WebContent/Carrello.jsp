<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="eCommerce.Product,eCommerce.ProductList,eCommerce.User,eCommerce.Cart,eCommerce.Account" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ServletCarrello" method="post">

	<%
    ServletContext context = request.getSession().getServletContext();
	User u = (User) context.getAttribute("user");%>
	<h1><b>Carrello di <%=u.getName()+" "+u.getSurname() %></b></h1>
	<%ProductList pl=(ProductList) context.getAttribute("productList");
	%>
<table>
    <tr><td>Codice</td><td>Prezzo</td><td>Descrizione</td><td>Categoria</td></tr>
    <% for(Product q : u.getCart().getProductList()){%>
		<tr>
			<td><%=q.getCode()%></td>
			<td><%=q.getPrice()%></td>
			<td><%=q.getDescription()%></td>
			<td><%=q.getcategory()%></td>
			<td><button type="submit" name="add" value="<%=q.getCode()%>">+</button></td>
			<td><%=q.getQuantity()%></td>
			<td><button type="submit" name="rem" value="<%=q.getCode()%>">-</button></td>
			</tr>
		<%}%> 
</table>
<p>Totale: <%=u.getCart().getTotalAmount() %> euro</p>
</form>
<form action="ServletPagamento" method="post">
<button type="submit" name="pagamento">Effettua pagamento</button>
</form>
</body>
</html>