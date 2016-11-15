<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<html>
<head>
    <title>Pets</title>
</head>
<body>
<h2>Pets:</h2>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Age</th>
    </tr>
    <c:forEach items="${pets}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.age}</td>
            <td><a href="/pet/edit/${p.id}">EDIT</a></td>
            <td><a href="/pet/delete/${p.id}">DELETE</a></td>
        </tr>
    </c:forEach>
</table>
<a href="/">index</a>
<a href="/pet">New pet</a>
</body>
</html>
