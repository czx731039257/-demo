<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>角色页面</title>

</head>
<body>
<div></div>

    <table border="1">
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
                    <form action="editpermissioncontroller">
                        <input type="hidden" name="roleid" value="${m.id}">
                        <input type="submit" value="编辑">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>