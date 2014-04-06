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
		String modeOfTransit = (String)request.getAttribute("modeOfTransit");
		boolean isHungry = (request.getAttribute("isHungry") != null) ? true : false;
		boolean isMovie = (request.getAttribute("isMovie") != null) ? true : false;
		boolean isOutside = (request.getAttribute("isOutside") != null) ? true : false;
		boolean isArts = (request.getAttribute("isArts") != null) ? true : false;
		
		if (modeOfTransit == null) {
			modeOfTransit = "driving";
		}
		String imageSrc = "http://maps.googleapis.com/maps/api/streetview?size=600x300&location=" + activity.latitude + "," + activity.longitude + "&heading=151.78&pitch=-0.76&sensor=false";
	
		StringBuilder addressURL = new StringBuilder();
		for (int i = 0; i < activity.address.length(); i++) {
			if (activity.address.charAt(i) ==' ') {
				addressURL.append("+");
			} else {
				addressURL.append(activity.address.charAt(i));
			}
		}
	%>

	<%= activity.title %>
	<%= activity.address %>
	<%= activity.phoneNumber %>
	<%= activity.latitude %>
	<%= activity.longitude %>
	<%= activity.website %>
	<%= activity.metadata %>
	
	<img src=<%=imageSrc%> />
	
	<iframe
	  width="600"
	  height="450"
	  frameborder="0" style="border:0"
	  src="https://www.google.com/maps/embed/v1/directions?key=AIzaSyCwehTkiWGttVWmKbBYm-V0Lj1UvWCyzXg
	  &origin=<%=request.getAttribute("latitude")%>,<%=request.getAttribute("longitude")%>
	  &destination=<%=addressURL%>
	  &mode=<%=modeOfTransit%>" >
	</iframe>
	
	<form name="Suggestion" action="GenerateSuggestionsServlet" method="post">
		<input type="hidden" id="latitude" name="latitude" value="<%=request.getAttribute("latitude")%>">	
		<input type="hidden" id="longitude" name="longitude" value="<%=request.getAttribute("longitude")%>">
		<input type="submit" value="Nah, meh"><br>
		
		<input type="radio" name="transport" value="walk" <%if (modeOfTransit.equals("walking")) { %>checked <%}%> >I'm walking<br>
		<input type="radio" name="transport" value="bike" <%if (modeOfTransit.equals("bicycling")) { %>checked <%}%>>I'm biking<br>
		<input type="radio" name="transport" value="car" <%if (modeOfTransit.equals("driving")) { %>checked <%}%>>I'm driving<br>
		<input type="radio" name="transport" value="bus" <%if (modeOfTransit.equals("transit")) { %>checked <%}%>>I'm taking the bus<br>
		
		<input type="checkbox" name="hungry" value="hungry" <%if (isHungry) { %>checked <%}%>>I'm hungry<br>
		<input type="checkbox" name="movie" value="movie" <%if (isMovie) { %>checked <%}%>>I want to see a movie<br>
		<input type="checkbox" name="outside" value="outside" <%if (isOutside) { %>checked <%}%>>I want to go outside<br>
		<input type="checkbox" name="arts" value="arts" <%if (isArts) { %>checked <%}%>>I'm cultured<br>
		
	</form>
	
	<form name="logout" action="LogoutServlet" method="post">
		<input type="submit" value="Log Out">
	</form>

</body>
</html>