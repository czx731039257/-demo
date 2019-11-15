<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/31
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>用户列表页面</title>
    <link rel="stylesheet" type="text/css" href="css/background.css">
</head>
<body>
<h1 align="center">用户列表</h1>
<table border="1" cellpadding="0px" cellspacing="0px" style="text-align: center;width: 100%" align="center">
    <tr>
        <th>用户ID</th>
        <th>姓名</th>
        <th>邮箱地址</th>
        <th>手机号</th>
        <th>总留言数</th>
    </tr>

    <c:forEach items="${sessionScope.users}" begin="0" step="1" var="m">
        <tr>
            <td style="width: 20%"><c:out value="${m.id}"/></td>
            <td style="width: 20%"><c:out value="${m.name}"/></td>
            <td style="width: 20%"><c:out value="${m.email}"/></td>
            <td style="width: 20%"><c:out value="${m.phone}"/></td>
            <td style="width: 20%"><c:out value="${m.count_message}"/></td>
        </tr>
    </c:forEach>
</table>
<div align="center">
    <form style="margin: 10px" action="message.jsp">
        <input type="submit" value="返回">
    </form>
</div>
</body>
</html>
