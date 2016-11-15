<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<html>
<body>
<h2>Hello World!</h2>
<h3>${msg}</h3>
<s:message code="msg"/>
<br>
<a href="?lang=ru_RU">Russian</a>
<a href="?lang=en">English</a>
<br>
<a href="/">index</a>
<a href="/number">new</a>
<a href="/time">time</a>
<a href="/pet/pets">pets</a>
<a href="/seabattle">sea battle</a>
</body>
</html>
