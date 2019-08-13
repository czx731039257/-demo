<%@ page import="java.util.List" %>
<%@ page import="com.csx.demo2.entity.Permission" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>编辑权限页面</title>
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

<div></div>
<h1 align="center">${sessionScope.role.name}的权限设置</h1>
<table border="1" align="center" cellpadding="0px" cellspacing="0px">
    <tr>
        <td align="left">
            <br>
            <div align="center">(序号-权限名)</div>
            <br>
            <form action="editpermissionsuccess" method="post">
                <c:forEach items="${sessionScope.allpermissions}" begin="0" step="1" var="m">
                    <c:set var="flag" value="0"></c:set>
                    <c:forEach items="${sessionScope.haspermissions}" begin="0" step="1" var="n">
                        <c:if test="${m.id == n.id}">
                            <c:set var="flag" value="1"></c:set>
                        </c:if>
                    </c:forEach>
                    <c:if test="${flag == 1}">
                        <input type="checkbox" name="permission" value="${m.id}" checked="checked">${m.id}-${m.name}<br>
                    </c:if>
                    <c:if test="${flag == 0}">
                        <input type="checkbox" name="permission" value="${m.id}">${m.id}-${m.name}<br>
                    </c:if>
                </c:forEach>
                <div align="center"><input type="submit" value="保存"></div>
            </form>
            <div align="center">
                <form action="roles" method="post">
                    <input type="submit" value="返回">
                </form>
            </div>
        </td>
    </tr>
</table>
</body>