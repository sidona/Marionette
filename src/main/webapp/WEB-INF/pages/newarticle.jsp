<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype HTML>
<html>
<head>
<link rel="stylesheet" href="../css/style.css">
<title>Create a new post</title>
</head>
<body>
	 <a href="<c:url value="/" />"><spring:message
				code="blog.home" /></a>

		<p>

	<form:form action="newarticle" method="POST" modelAttribute="newArticle">
		<h2>
			<spring:message code="newarticle.title" />
		</h2>
		<form:input path="title" size="120" />
		<br>
		<form:errors path="title" />

		<h2>
			<spring:message code="newarticle.content" />
		</h2>
		<form:textarea path="content" cols="120" rows="20" />
		<br>
		<form:errors path="content" />

		<h2>
			<spring:message code="newarticle.tags" />
		</h2>
		Comma separated, please<br>
		<form:input path="tags" size="120" />
		<br>
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>