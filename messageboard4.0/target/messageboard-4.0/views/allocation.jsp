<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/8
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑每个用户拥有的角色</title>
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

<div align="center">
    <h1>查看和分配所有用户的角色</h1>
    <table border="1" cellpadding="0px" cellspacing="0px">
        <tr>
            <th>用户ID</th>
            <th>用户名</th>
            <th>用户拥有的角色</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${sessionScope.usersandrole}" begin="0" step="1" var="m">
            <tr>
                <td>${m.id}</td>
                <td>${m.name}</td>

                <form action="editrolesuccesscontroller" method="post">
                    <td>
                        <input type="hidden" name="userid" value="${m.id}">
                        <c:forEach items="${sessionScope.roles}" var="i" begin="0" step="1">
                            <c:set var="flag" value="0"></c:set>
                            <c:forEach items="${m.roles}" var="j" begin="0" step="1">
                                <c:if test="${j.id == i.id}">
                                    <c:set var="flag" value="1"></c:set>
                                </c:if>
                            </c:forEach>
                            <c:if test="${flag == 0}">
                                <input type="checkbox" name="hasroles" value="${i.id}">${i.name}&nbsp;&nbsp;
                            </c:if>
                            <c:if test="${flag == 1}">
                                <input type="checkbox" name="hasroles" value="${i.id}"
                                       checked="checked">${i.name}&nbsp;&nbsp;
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <input type="submit" value="保存">
                    </td>
                </form>

            </tr>
        </c:forEach>
    </table>
    <form action="roles" method="post">
        <input type="submit" value="返回">
    </form>
</div>
</body>
</html>
