<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/31
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>用户信息页面</title>
    <link rel="stylesheet" type="text/css" href="css/background.css">
    <link rel="stylesheet" type="text/css" href="css/form.css">
    <style type="text/css">
        div.temp {
            margin: 10px;
        }
    </style>
</head>
<body>

<div align="center" style="opacity: 0.7">
    <h1>欢迎:${sessionScope.user.name}</h1>
</div>
<div align="center">
    <div class="temp">用户ID:${sessionScope.user.id}<br></div>
    <div class="temp"> 姓名:${sessionScope.user.name}<br></div>
    <div class="temp">密码:${sessionScope.user.password}<br></div>
    <div class="temp">邮箱:${sessionScope.user.email}<br></div>
    <div class="temp">手机号:${sessionScope.user.phone}<br></div>
    <div class="temp">所在用户组ID:${sessionScope.user.group_id}<br></div>
    <div class="temp">留言数:${sessionScope.user.count_message}

        <c:if test="${not empty sessionScope.canEditPersonInfo}">
            <form action="editperson" method="post">
                <input type="submit" style="margin: 10px" value="修改用户信息">
            </form>
        </c:if>
        <form action="message" method="post">
            <input type="submit" style="margin: 10px" value="返回">
        </form>
    </div>
</body>
</html>
