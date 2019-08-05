<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/31
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人用户信息</title>
    <link rel="stylesheet" type="text/css" href="css/background.css">
    <link rel="stylesheet" type="text/css" href="css/form.css">
    <style type="text/css">
        input{
            margin: 10px;
        }
    </style>
</head>
<body>
<div align="center" style="opacity: 0.7">
    <h1>欢迎:${sessionScope.user.name}</h1>
</div>
<div align="center">
    <form action="EditPersonInfoController" method="post">
        用户ID:${sessionScope.user.id}<br>
        <input type="hidden" name="id" value="${sessionScope.user.id}">
        姓名:<input type="text" name="name" value="${sessionScope.user.name}"><br>
        密码:<input type="text" name="password" value="${sessionScope.user.password}"><br>
        邮箱:<input type="text" name="email" value="${sessionScope.user.email}"><br>
        手机号:<input type="text" name="phone" value="${sessionScope.user.phone}"><br>


        <table border="0" align="center">
            <tr>
                <td><input type="submit" value="保存"></td>
                <td></td>
            </tr>
        </table>
    </form>
    <form action="person" method="post">
        <input type="submit" value="返回">
    </form>


</div>
</body>
</html>
