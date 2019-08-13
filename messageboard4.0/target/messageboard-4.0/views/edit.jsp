<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/30
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑页面</title>
    <link rel="stylesheet" type="text/css" href="css/background.css">
    <link rel="stylesheet" type="text/css" href="css/form.css">
    <style type="text/css">
        input{
            margin: 10px;
        }
    </style>
</head>
<body>

<%
    String withoutPermission = (String) session.getAttribute("withoutPermission");
    if (withoutPermission != null && withoutPermission == "true") {
%>
<script>
    alert("你没有这个权限");
</script>
<%
        session.removeAttribute("withoutPermission");
    }
%>

<div align="center" style="opacity: 0.7">
    <h1>欢迎:${sessionScope.user.name}</h1>
</div>
<div align="center">
留言序号：${sessionScope.message.id}<br>
<form action="EditMessageSuccessController" method="post">
    <input type="hidden" name="messageid" value="${sessionScope.message.id}">
    留言标签：<input type="text" name="label" value="${sessionScope.message.label}"><br>
    留言内容：<input type="text" name="detail" value="${sessionScope.message.detail}"><br>
    <table border="0">
        <tr>
            <td>
                <input type="submit" value="完成">
            </td>
        </tr>
    </table>
</form>
    <div align="center">
    <form action="message" method="post">
        <input type="submit" value="返回">
    </form>
    </div>
</div>
</body>
</html>
