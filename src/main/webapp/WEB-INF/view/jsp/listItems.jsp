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
	<h1> Items</h1>
    <a href="/additem" >Add New Items</a>
    <br/><br/>
        <table border="1" cellpadding="5">
            <caption><h2>List of Items</h2></caption>
            <tr>
            	<th>Id</th>
                <th>Name</th>
                <th>Quantity</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${itemLists}" var="item">
                <tr>
                	<td><c:out value="${item.id}" /></td>
                    <td><c:out value="${item.name}" /></td>
                    <td><c:out value="${item.quantity}" /></td>
                    <td>
                    <a type="button" class="btn btn-success"
			        href="/items/edititems/${item.id}">Update</a>
			        <a type="button" class="btn btn-warning"
			        href="/items/deleteItems/${item.id}">Delete</a>
			        
			        </td> 
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>