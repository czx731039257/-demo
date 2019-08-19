<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/31
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人用户信息</title>
    <link rel="stylesheet" type="text/css" href="css/background.css">
    <link rel="stylesheet" type="text/css" href="css/form.css">
    <style type="text/css">
        input {
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
<%
    String uploaderror = (String) session.getAttribute("uploaderror");
    if (uploaderror != null) {
        out.print("<script>\n" +
                "    alert(\"" + uploaderror + "\");\n" +
                "</script>");
        session.removeAttribute("uploaderror");
    }
%>


<div align="center" style="opacity: 0.7">
    <h1>欢迎:${sessionScope.user.name}</h1>
</div>
<div align="center">
    <table border="1" cellpadding="0px" cellspacing="0px">
        <tr>
            <td>
                <div align="center">
                    用户id：${sessionScope.user.id}<br>
                    <img src="${sessionScope.user.currentHeadPortrait.image_url}" width="150px" height="150px">
                    <table border="0">
                        <tr>
                            <td>
                                <form action="uploadhead" method="post" enctype="multipart/form-data">
                                    <input type="file" name="file" width="50px">
                                    <input type="submit" value="上传头像">
                                </form>
                            </td>
                            <td>
                                <form action="headlist">
                                    <input type="submit" value="选择头像">
                                </form>
                            </td>
                        </tr>
                    </table>
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <form action="EditPersonInfoSuccessController" method="post">
                    <input type="hidden" name="id" value="${sessionScope.user.id}">
                    姓名:<input style="width: 80%" type="text" name="name" value="${sessionScope.user.name}"><br>
                    密码:<input style="width: 80%" type="text" name="password" value="${sessionScope.user.password}"><br>
                    邮箱:<input style="width: 80%" type="text" name="email" value="${sessionScope.user.email}"><br>
                    手机号:<input style="width: 77%" type="text" name="phone" value="${sessionScope.user.phone}"><br>
                    所在用户组号:${sessionScope.user.group_id}<br>


                    <table border="0" align="center">
                        <tr>
                            <td><input type="submit" value="保存用戶基本信息"></td>
                            <td></td>
                        </tr>
                    </table>
                </form>
            </td>
        </tr>
    </table>
</div>

<div align="center">

    <form action="person" method="post">
        <input type="submit" value="返回">
    </form>
</div>
</body>
</html>
