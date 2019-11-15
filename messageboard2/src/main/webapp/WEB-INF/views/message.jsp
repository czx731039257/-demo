<%@ page import="com.csx.demo2.entity.PageBean" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/30
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>留言板</title>
    <link rel="stylesheet" type="text/css" href="css/background.css">
    <link rel="stylesheet" type="text/css" href="css/form.css">
</head>
<body>
<div align="center" style="opacity: 0.7">
    <h1>欢迎:${sessionScope.user.name}</h1>
</div>


<table border="0">
    <tr>
        <td style="width: 20%">

            <div align="center">
                <form action="SelectMessageByUserNameController" method="post">
                    <input type="text" name="name" placeholder="请输入要查询的用户名">
                    <input type="submit" value="查询某个用户">
                </form>
            </div>
        </td>
        <td style="width: 5%">
            <div align="center">
                <form action="SelectAllMessageController" method="post">
                    <input type="submit" value="查询所有留言">
                </form>
            </div>
        </td>
        <td style="width: 5%">
            <div align="left">
                <form action="create" method="post">
                    <input type="submit" value="新建">
                </form>
            </div>
        </td>
        <td style="width:10% ">
            <div align="left">
                <form action="SelectAllUserInfoController" method="post">
                    <input type="submit" value="查看所有用户信息">
                </form>
            </div>
        </td>
        <td style="width: 30%">

        </td>
        <td style="width: 5%">
            <form action="PersonInfoController" method="post">
                <input type="submit" value="个人用户信息">
            </form>
        </td>
        <td style="width: 5%">
            <div align="center">
                <form action="CancelUserController" method="post">
                    <input type="submit" value="注销">
                </form>
            </div>
        </td>
    </tr>
</table>


<table border="1" cellpadding="0px" cellspacing="0px" style="text-align: center;width: 100%" align="center">
    <tr>
        <th>留言序号</th>
        <th>标题</th>
        <th>内容</th>
        <th>创建时间</th>
        <th>修改时间</th>
        <th>留言者</th>
        <th>删除</th>
        <th>编辑</th>
    </tr>

    <c:if test="${sessionScope.pageBean.endIndex>=1}">
        <c:forEach items="${sessionScope.messageSet}" begin="${sessionScope.pageBean.startIndex}"
                   end="${sessionScope.pageBean.endIndex}" step="1" var="m">
            <tr>
                <td style="width: 5%"><c:out value="${m.id}"/></td>
                <td style="width: 10%"><c:out value="${m.label}"/></td>
                <td style="width: 50%"><c:out value="${m.detail}"/></td>
                <td style="width: 15%"><c:out value="${m.date_create}"/></td>
                <td style="width: 15%"><c:out value="${m.date_edit}"/></td>
                <td style="width: 5%"><c:out value="${m.user_id}"/></td>

                <td>
                    <div align="center" style=" opacity:0.7;">
                        <form action="DeleteMessageController" method="post">
                            <input type="hidden" name="messageid" value="${m.id}">
                            <input type="submit" value="删除">
                        </form>
                    </div>
                </td>

                <td>
                    <div align="center" style=" opacity:0.7;">
                        <form action="IntoEditMessageController" method="post">
                            <input type="hidden" name="messageid" value="${m.id}">
                            <input type="submit" value="编辑">
                        </form>
                    </div>
                </td>

            </tr>
        </c:forEach>
    </c:if>
</table>
<p align="center">第${sessionScope.pageBean.pageNumber}页</p><br>


<table border="0" align="center">
    <tr>
        <td>
            <c:if test="${sessionScope.pageBean.pageNumber>1}">
                <form action="LastPageController" method="post">
                    <input type="submit" value="上一页">
                </form>
            </c:if>
        </td>
        <td>
            <c:if test="${sessionScope.pageBean.pageNumber<sessionScope.pageBean.totalPage}">
                <form action="NextPageController" method="post">
                    <input type="submit" value="下一页">
                </form>
            </c:if>
        </td>
    </tr>
</table>

</body>
</html>
