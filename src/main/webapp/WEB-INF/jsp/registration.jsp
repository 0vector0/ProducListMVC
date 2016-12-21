<%--todo comeback error page--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
    <style>
        .error {
            color: #ff0000;
            font-style: italic;
            font-weight: bold;
        }
    </style>
</head>
<body>
<sf:form method="post" action="/addUser" modelAttribute="user">
    ${requestScope.alreadyexist}
    <div>
        <label for="name"><s:message code="reg.name"/>:</label>
        <sf:input path="name"/>
        <sf:errors path="name" cssClass="error"/>
    </div>
    <div>
        <label for="email"><s:message code="reg.email"/>:</label>
        <sf:input path="email"/>
        <sf:errors path="email" cssClass="error"/>
    </div>
    <div>
        <label><s:message code="reg.password"/>: </label>
        <sf:input path="password"/>
        <sf:errors path="password" cssClass="error"/>
    </div>

    <div class="submit">
        <button type="submit" name="save"><s:message code="reg.submit"/></button>
    </div>


</sf:form>
</body>
</html>
