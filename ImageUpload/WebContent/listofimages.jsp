<%@page import="DBconnection.DatabaseConnectivity"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/tablestyle.css" type="text/css" />
<title>KING SIZE BED IMAGES</title>
</head>
<body>
	<h1>YOUR KING SIZE BED IMAGES</h1>
	<a href="addnewimage.jsp" class="newbutton">Add New</a>
	<table class="table">
		<tr>
			<th>Id</th>
			<th>Image</th>
			<th>Action</th>
		</tr>
		<%
		DatabaseConnectivity databaseConnectivity = DatabaseConnectivity.getInstance();
		databaseConnectivity.openConnection();
		String sql = "select * from product_image";
		ResultSet rs = databaseConnectivity.fatchData(sql);
		while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getInt(1)%></td>
			<td>
			<img alt="image" src="FM_Image/<%=rs.getString(2)%>" width="150px" height="150px">
			</td>
			<td>&nbsp; <a
				href="#<%--EditCountry.jsp?id=<%=rs.getInt(1)%>--%>" class="editb">Change
					Image</a>
			</td>
		</tr>
		<%
		}
		databaseConnectivity.closeConnection();
		%>
	</table>
</body>
</html>