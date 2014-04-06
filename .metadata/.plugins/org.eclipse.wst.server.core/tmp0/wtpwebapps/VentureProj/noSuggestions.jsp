<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ page import="venture.Activity" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
	<title>Venture</title>

</head>
<body>

	<%
		Activity activity = (Activity)request.getAttribute("activity");	
		String modeOfTransit = "driving";	
		
	%>
	
	<div>
	Sorry, you suck. Try again.
	</div>
	
	<form name="Suggestion" action="GenerateSuggestionsServlet" method="post">
		<input type="hidden" id="latitude" name="latitude" value="<%=request.getAttribute("latitude")%>">	
		<input type="hidden" id="longitude" name="longitude" value="<%=request.getAttribute("longitude")%>">
		<input type="submit" value="Nah, meh"><br>
		
		<input type="radio" name="transport" value="walk" <%if (modeOfTransit.equals("walking")) { %>checked <%}%> >I'm walking<br>
		<input type="radio" name="transport" value="bike" <%if (modeOfTransit.equals("bicycling")) { %>checked <%}%>>I'm biking<br>
		<input type="radio" name="transport" value="car" <%if (modeOfTransit.equals("driving")) { %>checked <%}%>>I'm driving<br>
		<input type="radio" name="transport" value="bus" <%if (modeOfTransit.equals("transit")) { %>checked <%}%>>I'm taking the bus<br>
		
		<input type="checkbox" name="hungry" value="hungry" >I'm hungry<br>
		<input type="checkbox" name="movie" value="movie" >I want to see a movie<br>
		<input type="checkbox" name="outside" value="outside" >I want to go outside<br>
		<input type="checkbox" name="arts" value="arts" >I'm cultured<br>
		
	</form>
	
	<form name="logout" action="LogoutServlet" method="post">
		<input type="submit" value="Log Out">
	</form>

</body>
</html>