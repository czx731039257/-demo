<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/30
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登入</title>
    <style>
        body{
            background-size: 1400px,600px;
            background-repeat: no-repeat;
        }
    </style>
</head>
<body>
<h1 style="text-align:center;position:absolute;top:200px;left: 650px;">登入页面</h1>
    <form style="text-align:center;position: absolute;top: 270px;left: 580px" action="login" method="post">
    用户：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    <input style="background-color: dodgerblue" type="submit" value="登入"><br>
    </form>
    <div style="color: red;size: A3;text-align: center;position: absolute;top: 340px;left: 620px"><%
    String error =(String) session.getAttribute("error");
    if(error!=null)
        out.print(error);
    %></div>

</body>
</html>
