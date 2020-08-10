<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Student Confirmation Page</title>
</head>
<body>

	<!-- confirmation area-->
	The student is confirmed: ${student.firstName} ${student.lastName} ${student.email}
	<br>
	Country: ${student.country}
	<br>
	Favorite Language: ${student.favLang}
	<br>
	Operating system Experience: 
	<ul>
		<c:forEach var="expOS" items="${student.experiencedOS}">
			<li>${expOS}</li>
		</c:forEach>
		
	</ul>
	
</body>
</html>