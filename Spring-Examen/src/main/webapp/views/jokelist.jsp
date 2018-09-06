<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: didiercolaes
  Date: 06/09/2018
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Joke</title>
</head>
<body>
<c:if test='${not empty joke}'>
   <p>${joke.joke}</p>
</c:if>
</body>
</html>
