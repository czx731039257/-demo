<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/30
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>留言新建页面</title>
    <link rel="stylesheet" type="text/css" href="css/background.css">
    <link rel="stylesheet" type="text/css" href="css/form.css">
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
    <form action="CreateMessageController" method="post">
        标题：<input type="text" style="margin: 10px" name="label"><br/>
        内容：<input type="text" style="margin: 10px" name="detail"><br/>
        <table border="0">
            <tr>
                <td>
                    <input type="submit" style="margin: 10px" value="创建">
                </td>
                <td>

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
