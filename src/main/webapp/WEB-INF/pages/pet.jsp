<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<html>
<head>
    <style>
        .red {
            color: red;
        }
    </style>
    <title>Pet</title>
</head>
<body>
<h2>Pet</h2>
<table border="0">
    <f:form method="post" commandName="pet" action="/pet">
        <c:if test="${edit}">
            <tr>
                <td>Id:</td>
                <td><f:input path="id" readonly="true"/></td>
            </tr>
        </c:if>
        <tr>
            <td>Name:</td>
            <td><f:input path="name"/></td>
            <td><f:errors path="name" class="red"/></td>
        </tr>
        <tr>
            <td>Age:</td>
            <td><f:input path="age"/></td>
            <td><f:errors path="age" class="red"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="hidden" name="edit" value="${edit}">
                <input type="submit">
            </td>
        </tr>
    </f:form>
</table>
<a href="/">index</a>
<a href="/pet/pets">pets</a>
</body>
</html>
