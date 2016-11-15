<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<html>
<body>
<h2>Welcome to the Sea Battle world!</h2>
<h3>${msg}</h3>
<s:message code="msg"/>
<br>
<a href="?lang=ru_RU">Russian</a>
<a href="?lang=en">English</a>
<br>
<a href="/">index</a>
<a href="/seabattle/fields">new</a>
</body>
</html>
