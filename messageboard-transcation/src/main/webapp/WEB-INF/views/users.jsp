<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/31
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<html>
<head>
    <title>用户列表页面</title>
    <link rel="stylesheet" type="text/css" href="css/background.css">
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

<h1 align="center">用户列表</h1>
<table border="1" cellpadding="0px" cellspacing="0px" style="text-align: center;width: 100%" align="center">
    <tr>
        <th>用户ID</th>
        <th>姓名</th>
        <th>邮箱地址</th>
        <th>手机号</th>
        <th>所在用户组id</th>
        <th>总留言数</th>
        <th>编辑</th>
    </tr>

    <c:forEach items="${sessionScope.users}" begin="0" step="1" var="m">
        <tr style="height: 41px">
            <td style="width: 10%"><c:out value="${m.id}"/></td>
            <td style="width: 20%"><c:out value="${m.name}"/></td>
            <td style="width: 20%"><c:out value="${m.email}"/></td>
            <td style="width: 20%"><c:out value="${m.phone}"/></td>
            <td style="width: 10%"><c:out value="${m.group_id}"/></td>
            <td style="width: 10%"><c:out value="${m.count_message}"/></td>
            <td>
                <div align="center" style=" opacity:0.7;">
                    <form action="intoEditUserInfo" method="post">
                        <input type="hidden" name="userid" value="${m.id}">

                        <c:choose>
                            <c:when test="${sessionScope.user.id == m.id}">
                                <shiro:hasPermission name="编辑自己的用户信息">
                                    <input type="submit" value="编辑">
                                </shiro:hasPermission>
                            </c:when>
                            <c:otherwise>
                                <c:choose>
                                    <c:when test="${sessionScope.user.group_id == m.group_id}">
                                        <shiro:hasPermission name="编辑所在用户组的人的用户信息">
                                            <input type="submit" value="编辑">
                                        </shiro:hasPermission>
                                    </c:when>
                                    <c:otherwise>
                                        <shiro:hasPermission name="编辑其他用户组的人的用户信息">
                                            <input type="submit" value="编辑">
                                        </shiro:hasPermission>
                                    </c:otherwise>
                                </c:choose>
                            </c:otherwise>
                        </c:choose>
                    </form>
                </div>
            </td>

        </tr>
    </c:forEach>
</table>
<div align="center">
    <form style="margin: 10px" action="message">
        <input type="submit" value="返回">
    </form>
</div>
</body>
</html>
