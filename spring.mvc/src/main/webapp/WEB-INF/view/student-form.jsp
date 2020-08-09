<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Form</title>
</head>
<body>

	<!-- form area -->
	<form:form action="processForm" modelAttribute="student">

		First Name: <form:input path="firstName" />
		<br>
		<br>
		Last Name: <form:input path="lastName" />
		<br>
		<br>
		Country: 
		<form:select path="country">
			<form:option value="" label="--Select your country--"></form:option>
			<form:options items="${countryOptions}" />
		</form:select>
		<br><br>
		Your Favorite Programming Language
		<br>
		<form:radiobuttons path="favLang" items="${favoriteLanguageArray}"/>
		<br><br>
		Experienced Operating Systems
		<br>
		<form:checkboxes items="${operatingSystemArray}" path="experiencedOS"/>
		<br><br>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>