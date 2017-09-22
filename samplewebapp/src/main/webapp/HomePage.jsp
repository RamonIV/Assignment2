<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import ="samplewebapp.DBConnect" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% 
 DBConnect dbconnection = new DBConnect();
 String[] StreetNames = dbconnection.returnStreetNames();

%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<style>
table{
border-style: solid;
width: 200px;
border-collapse: collapse;
}

td{
border-style: solid;
text-align: right;
width: 100px
}

</style>
<body>
<select>
<%
int i = 0;
for(i=0; i < StreetNames.length; i++)
{
	<option value="StreetNames[i]"></option>
}
%>
<option value="Lil Marco">Lil Marco</option>
<option value="Biggie Smalls">Biggie Smalls</option>
<option value="ICP">Eye Si Pee</option>
</select>

<table>
<tr>
<td>Free Parking Spots</td>
<td id="ParkingSpots" name="ParkingSpots">69</td>
</tr>

<tr>
<td>Time Limit</td>
<td id="TimeLimit" name="TimeLimit">98 Hours</td>
</tr>

<tr>
<td>Cost</td>
<td id="Cost" name="Cost">$3.00</td>
</tr>
</table>
<br/>
<button type="button" id="BookButton">BOOK</button>

</body>
</html>