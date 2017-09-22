<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CurrentStatus</title>
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

<table>
<tr>
<td>CURRENTLY BOOKED</td>
<td id="BookedAmount" name="BookedAmount">5</td>
</tr>

<tr>
<td>CURRENT TIME PARKED</td>
<td id="TimeParked" name="TimeParked">6</td>
</tr>
</table>
<br>
<button type="button" id="Rebook">REBOOK</button>
<button type="button" id="CheckOut">CHECKOUT</button>
</body>
</html>