<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/30
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>登入</title>
    <link rel="stylesheet" type="text/css" href="../css/background.css">
    <link rel="stylesheet" type="text/css" href="login.jsp">
</head>
<body>
<h1 style="text-align:center;position:absolute;top:200px;left: 650px;">登入页面</h1>

<form action="login" method="post">
    用户：<input class="opacity" type="text" name="username"><br>
    密码：<input class="opacity" type="password" name="password"><br>
    <div style="color: lightcoral;opacity: 0.5"><c:if test="${not empty sessionScope.error}">
        <c:out value="${sessionScope.error}"/>
    </c:if><br>
    </div>
    <input class="btn" type="submit" value="登入"><br>
</form>


</body>
</html>
