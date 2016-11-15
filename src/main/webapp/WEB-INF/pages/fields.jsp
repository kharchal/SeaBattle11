<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<html>
<head>
    <title>Fields</title>
    <style>
        td a:link { color:blue;
            text-decoration:none;}
        td a:visited { color:darkblue;
            text-decoration:none;}
        td a:hover { color:red;
            text-decoration:none;}
        td a:active { color:black;
            text-decoration:none;}
    </style>
</head>
<body>
<h2>Fields:</h2>
<table border="0">
    <tr>
        <th>${playerA.name}</th>
        <th>${playerB.name}</th>
    </tr>
    <tr>
        <td>
            left pane

            <table border="0">
                <tr>
                    <td></td>
                    <c:forEach var="i" begin="0" end="9">
                        <th width="20">${i}</th>
                    </c:forEach>
                </tr>
                <c:set var="line" value="${playerA.field.cells}"/>
                <c:forEach var="i" begin="0" end="9">
                    <tr>
                        <th>${i}</th>
                        <c:set var="cell" value="${line[i]}"/>
                        <c:forEach var="j" begin="0" end="9">
                            <td align="center">
                                <a href="/seabattle/shot/${i}-${j}">
                                    <c:set var="c" value="${cell[j]}"/>


                                            ${c.toString()}

                                </a>
                            </td>
                        </c:forEach>
                        <th>${i}</th>
                    </tr>
                </c:forEach>
                <tr>
                    <td></td>
                    <c:forEach var="i" begin="0" end="9">
                        <th>${i}</th>
                    </c:forEach>
                </tr>
            </table>

        </td>
        <td>right pane
            <table border="0">
                <tr>
                    <td></td>
                    <c:forEach var="i" begin="0" end="9">
                        <th width="20">${i}</th>
                    </c:forEach>
                </tr>
                <c:set var="line" value="${playerB.field.cells}"/>
                <c:forEach var="i" begin="0" end="9">
                    <tr>
                        <th>${i}</th>
                        <c:set var="cell" value="${line[i]}"/>
                        <c:forEach var="j" begin="0" end="9">
                            <td align="center">
                                <a href="/seabattle/shot/${i}-${j}">
                                    <c:set var="c" value="${cell[j]}"/>
                                    <c:choose>
                                        <c:when test="${c.isShut()}">
                                            ${c.toString()}
                                        </c:when>
                                        <c:otherwise>
                                            ~
                                        </c:otherwise>
                                    </c:choose>
                                </a>
                            </td>
                        </c:forEach>
                        <th>${i}</th>
                    </tr>
                </c:forEach>
                <tr>
                    <td></td>
                    <c:forEach var="i" begin="0" end="9">
                        <th>${i}</th>
                    </c:forEach>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td></td>
        <td>You shut at: ${x}, ${y}.</td>
    </tr>
</table>
<a href="/">index</a>
</body>
</html>
