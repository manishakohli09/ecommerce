<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Item</title>
</head>
<body>
    <div align="center">
        <h1>Enter New Item</h1>
        <br />
        <form action="/items/additem" method="post" modelAttribute="item">
  
            <table border="0" cellpadding="10">
                <tr>
                    <td>Item Name:</td>
                    <td><input type="text" name="name" required="required" /></td>
                </tr>
                <tr>
                    <td>Quantity:</td>
                    <td><input type="text" quantity="quantity" required="required"/></td>
                </tr>                          
                <tr>
                    <td colspan="2"><button type="submit">Add</button> </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>