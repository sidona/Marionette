<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>

<html>
<head>
<title>Welcome</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	Welcome ${username}
	<p>
	<ul>

		<li><a href="<c:url value="/newarticle" />"><spring:message
					code="new_article" /></a></li>
	</ul>
</body>

</html>
