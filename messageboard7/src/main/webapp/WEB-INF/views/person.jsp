<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/31
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>用户信息页面</title>

    <script src="webjars/jquery/3.1.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/background.css">
    <link rel="stylesheet" type="text/css" href="css/form.css">
    <style type="text/css">
        div.temp {
            margin: 10px;
        }
    </style>


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
    <table border="1" style="width:40%;height: 40%" cellpadding="0px" cellspacing="0px">
        <tr>
            <td style="width: 200px;height: 100%">
                <div align="center">
                    <div align="center">头像</div>
                    <img src="${sessionScope.user.currentHeadPortrait.image_url}" width="200px" height="200px">
                </div>
            </td>
            <td style="width: 50%;height: 100%">
                <table border="1" style="width: 100%;height: 100%" cellpadding="0px" cellspacing="0px">
                    <tr>
                        <td>
                            <div class="temp">用户ID:${sessionScope.user.id}</div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="temp"> 姓名:${sessionScope.user.name}</div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="temp">密码:${sessionScope.user.password}</div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="temp">邮箱:${sessionScope.user.email}</div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="temp">手机号:${sessionScope.user.phone}</div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="temp">所在用户组ID:${sessionScope.user.group_id}</div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="temp">留言数:${sessionScope.user.count_message}</div>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 80%;">
                            <div class="temp">余额:${sessionScope.user.money}</div>
                        </td>
                        <td>
                            <form action="recharge">
                                <input type="submit" value="充值">
                            </form>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>

    </table>
</div>

<div align="center">
    <table border="0">
        <tr>
            <td>
                <shiro:hasPermission name="编辑自己的用户信息">
                    <form action="editperson" method="post">
                        <input type="submit" style="margin: 10px" value="修改用户信息">
                    </form>
                </shiro:hasPermission>
            </td>
            <td>
                <form action="message" method="post">
                    <input type="submit" style="margin: 10px" value="返回">
                </form>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
