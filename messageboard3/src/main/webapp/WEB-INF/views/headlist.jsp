<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/16
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>头像列表</title>
    <link rel="stylesheet" type="text/css" href="css/background.css">
    <link rel="stylesheet" type="text/css" href="css/form.css">
    <style type="text/css">
        input {
            margin: 10px;
        }
    </style>

</head>
<body>
<div align="center">
    <table class="table" border="1" cellpadding="0px" cellspacing="0px">
        <tr>
            <th>图片</th>
            <th>操作</th>
        </tr>
        <form action="changeHead">
            <c:forEach items="${sessionScope.user.headPortraits}" step="1" begin="0" var="m">

            <tr>
                <td><img id="images" alt="" src="${m.image_url}" width="100px" height="100px"></td>

                <c:choose>
                    <c:when test="${m.id == sessionScope.user.headportrait_id}">
                        <td><input type="radio" name="head" value="${m.id}" checked></td>
                    </c:when>
                    <c:when test="${m.id != sessionScope.user.headportrait_id}">
                        <td><input type="radio" name="head" value="${m.id}"></td>
                    </c:when>
                </c:choose>
            </tr>
            </c:forEach>
    </table>
    <input type="submit" value="确定">
    </form>

    <form action="editperson">
        <input type="submit" value="返回">
    </form>
</div>
</body>
</html>
