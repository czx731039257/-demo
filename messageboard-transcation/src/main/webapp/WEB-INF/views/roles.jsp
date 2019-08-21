<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>角色页面</title>
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
    <h1 align="center">所有角色</h1>

    <table border="1" cellpadding="0px" cellspacing="0px">
        <tr>
            <th>角色ID</th>
            <th>角色名</th>
            <th>编辑权限</th>
        </tr>
        <c:forEach items="${sessionScope.roles}" begin="0" step="1" var="m">
            <tr>
                <td>${m.id}</td>
                <td>${m.name}</td>
                <td>
                    <form action="intoEditRolesHavePermissions">
                        <input type="hidden" name="roleid" value="${m.id}">
                        <input type="submit" value="编辑权限">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div align="center">
        <form action="intoEditUsersHasRoles" method="post">
            <input type="submit" value="给用户分配角色">
        </form>
    </div>
    <div align="center">
        <form action="message" method="post">
            <input type="submit" value="返回">
        </form>
    </div>
</div>
</body>