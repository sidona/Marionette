<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/style.css">
<title>My Blog</title>
</head>
<body>

    Welcome   <a href="<c:url value="/newarticle" />"><spring:message
				code="new_article" /></a>


	<h1>My Blog</h1>
	<c:forEach items="${myarticles}" var="article">
		<h2>
			<a href="<c:url value="/article/${article.permalink}" />">${article.title}</a>
		</h2>
Posted ${article.date}
	<i>By ${article.author}</i>


		<br> Comments:
	<c:choose>
			<c:when test="${article.comments ne null}">
				<c:set var="numComments" value="${fn:length(article.comments)}" />
			</c:when>
			<c:otherwise>
				<c:set var="numComments" value="0" />
			</c:otherwise>
		</c:choose>

		<a href="<c:url value="/article/${article.permalink}" />">${numComments}</a>

		<hr>
	${article.content}
	<em>Filed Under</em>:
	<c:if test="${article.tags ne null}">
			<c:forEach items="${article.tags}" var="tag">
				<a href="<c:url value="/tag/${tag}" />">${tag}</a>
			</c:forEach>
		</c:if>
	</c:forEach>
</body>
</html>

