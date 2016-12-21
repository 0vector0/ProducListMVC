<%--todo comeback error page--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<h3>Products list</h3>
<br/>
<a href="${s:mvcUrl('getRegister').build()}">Registration</a>
<%--<a href="${s:mvcUrl('getLogin').build()}">Login</a>--%>
<a href="<c:url value="/products"/>">Products list</a>
<br/>
</body>
</html>