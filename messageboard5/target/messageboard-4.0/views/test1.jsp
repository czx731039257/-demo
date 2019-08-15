<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>测试页面一</title>

</head>
<body>
    <%
        String withoutPermission = (String)session.getAttribute("withoutPermission");
        if(withoutPermission!=null&&withoutPermission == "true"){
    %>
    <script>
        alert("你没有这个权限");
    </script>
    <%
            session.removeAttribute("withoutPermission");
        }
    %>
    <form action="testcontroller1">
        <input type="submit" value="跳到testcontroller在跳回此页面">
    </form>
</body>