<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Products Page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>Product List</h1>

<c:if test="${!empty listProducts}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="120">Description</th>
            <th width="120">Price</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listProducts}" var="product">
            <tr>
                <td>${product.productId}</td>
                <td><a href="/productdata/${product.productId}" target="_blank">${product.name}</a></td>
                <td>${product.description}</td>
                <td>${product.price}${product.price}</td>
                <td><a href="<c:url value='/edit/${product.productId}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${product.productId}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Product</h1>

<c:url var="addAction" value="/products/add"/>

<form:form action="${addAction}" commandName="product">
    <table>
        <c:if test="${!empty product.name}">
            <tr>
                <td>
                    <form:label path="productId">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="productId" readonly="true" size="8"/>
                        <%--<form:hidden path="id"/>--%>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="description">
                    <spring:message text="Description"/>
                </form:label>
            </td>
            <td>
                <form:input path="description"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="price">
                    <spring:message text="Price"/>
                </form:label>
            </td>
            <td>
                <form:input path="price"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty product.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Product"/>"/>
                </c:if>
                <c:if test="${empty product.name}">
                    <input type="submit"
                           value="<spring:message text="Add Product"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
