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
</head>
<body>
<div align="center">
    <form action="create" method="post">
        标题：<input type="text" name="label"><br/>
        内容：<input type="text" name="detail"><br/>
        <input type="submit" value="创建">
        <div align="center">
            <form action="message.jsp">
                <input type="submit" value="返回">
            </form>
        </div>
    </form>
</div>

</body>
</html>
