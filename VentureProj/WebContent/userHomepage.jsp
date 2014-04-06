<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Adventure Button</title>

	<script>
		var lat;
		var lng;
		var form;
		function getLocation() {
		 	if (navigator.geolocation) { 
				navigator.geolocation.getCurrentPosition(showPosition);
		  	}
		}
		function showPosition(position) {
			lat.value = position.coords.latitude;
			lng.value = position.coords.longitude;
			form.submit();
		}
		window.onload = function() {
			lat = document.getElementById("latitude");
			lng = document.getElementById("longitude");
			form = document.getElementById("form");
		}
		
		
	</script>

</head>
<body>
	Welcome, <%=session.getAttribute("loginName") %>
	
	<form action="GenerateSuggestionsServlet" id="form" method="post">
		<input type="hidden" id="latitude" name="latitude">	
		<input type="hidden" id="longitude" name="longitude">
	</form>		
	<button onclick="getLocation()"> Adventure </button>
	
	
</body>
</html>