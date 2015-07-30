<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype HTML>
<html>
<head>
<link rel="stylesheet" href="../css/style.css">
<title>Blog Post</title>
</head>
<body>

    Welcome  <a href="<c:url value="/newarticle" />"><spring:message
				code="new_article" /></a>




	<a href="<c:url value="/" />">Blog Home</a>
	<br>
	<br>

	<h2>${article.title}</h2>
	Posted ${article.date}
	<i> By ${article.author}</i>
	<br>
	<hr>
	${article.content}
	<p>
		<em>Filed Under</em>:
		<c:if test="${article.tags ne null}">
			<c:forEach items="${article.tags}" var="tag">
				<a href="<c:url value="/tag/${tag}" />">${tag}</a>
			</c:forEach>
		</c:if>
	<p>Comments:
	<ul>
		<c:choose>
			<c:when test="${article.comments ne null}">
				<c:set var="numComments" value="${fn:length(article.comments)}" />
			</c:when>
			<c:otherwise>
				<c:set var="numComments" value="0" />
			</c:otherwise>
		</c:choose>
		<c:if test="${numComments > 0}">
			<c:forEach var="i" begin="0" end="${numComments -1}">
				 Author:  ${article.comments[i].author}<br>
				 Comment:  ${article.comments[i].content}<br>
				<hr>
			</c:forEach>
		</c:if>
		<h3>Add a comment</h3>

		<form:form action="newcomment" method="post" modelAttribute="comment">
			<input type="hidden" name="permalink" value="${article.permalink}" />
			<br>
			<fieldset>
				<table>
					<tr>
						<td><form:label path="author" cssErrorClass="error">
								<spring:message code="comment.author" />
							</form:label></td>
						<td><form:input path="author" /></td>
						<td><form:errors path="author" /></td>
					</tr>

					<tr>
						<td><form:label path="content" cssErrorClass="error">
								<spring:message code="comment.content" />
							</form:label></td>
						<td><form:textarea path="content" /></td>
						<td><form:errors path="content" /></td>
					</tr>

					<tr>
						<td><form:label path="email" cssErrorClass="error">
								<spring:message code="comment.email" />
							</form:label></td>
						<td><form:input path="email" /></td>
						<td><form:errors path="email" /></td>
					</tr>
				</table>
			</fieldset>
			<input type="submit">
		</form:form>
	</ul>
</body>
</html>


