<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.ecommerce.controller.ItemController,com.ecommerce.model.*,java.util.*"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Update Item</h1>
		<br />
		<form action="/items/edititems/${item.id}" modelAttribute="item"
			method="post">

			<table border="0" cellpadding="10">
				<tr>
                    <td>Item Id:</td>
                    <td><input type="text" name="id" value="${item.id}" /></td>
                </tr>
                <tr>
                    <td>Item Name:</td>
                    <td><input type="text" name="name" value="${item.name}" /></td>
                </tr>
                <tr>
                    <td>Item Quantity:</td>
                    <td><input type="text" name="quantity" value="${item.quantity}" /></td>
                </tr>
			
				<tr>
                    <td colspan="2"><button type="submit">Update</button> </td>
                </tr>
				
			</table>
		</form>
	</div>
</body>
</html>