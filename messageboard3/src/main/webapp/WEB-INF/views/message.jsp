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

<%
    String withoutPermission = (String) session.getAttribute("withoutPermission");
    if (withoutPermission != null && withoutPermission.equals("true")) {
%>
<script>
    alert("你没有这个权限");
</script>
<%
        session.removeAttribute("withoutPermission");
    }
%>
<%
    String accesserror = (String) session.getAttribute("accesserror");
    if (accesserror != null && accesserror.equals("true")) {
%>
<script>
    alert("请不要不通过按键直接访问");
</script>
<%
        session.removeAttribute("accesserror");
    }
%>


<div align="center" style="opacity: 0.7">
    <h1>欢迎:${sessionScope.user.name}</h1>
</div>


<table border="0">
    <tr>
        <td style="width: 200px">
            <c:if test="${not empty sessionScope.permission4}">
                <form action="PersonInfoController" method="post">
                    <input style="width: 200px" type="submit" value="查看个人用户信息">
                </form>
            </c:if>
        </td>
        <td style="width: 200px">
            <div align="left">
                <c:if test="${not empty sessionScope.permission5}">
                    <form action="SelectGroupUserInfoController" method="post">
                        <input style="width: 200px" type="submit" value="查看所在用户组的用户信息">
                    </form>
                </c:if>
            </div>
        </td>
        <td style="width: 200px">
            <div align="left">
                <c:if test="${not empty sessionScope.permission6}">
                    <form action="SelectOtherGroupUserInfoController" method="post">
                        <input style="width: 200px" type="submit" value="查看其他用户组的用户信息">
                    </form>
                </c:if>
            </div>
        </td>
        <td style="width: 200px">
            <div align="left">
                <c:if test="${not empty sessionScope.permission4 and not empty sessionScope.permission5 and not empty sessionScope.permission6}">
                    <form action="SelectAllUserInfoController" method="post">
                        <input style="width: 200px" type="submit" value="查看所有用户信息">
                    </form>
                </c:if>
            </div>
        </td>
        <td style="width: 1000px">
        </td>
        <td style="width: 110px">
            <c:if test="${not empty sessionScope.permission17}">
                <form action="selectrole">
                    <input style="width: 110px" type="submit" value="查看角色及权限">
                </form>
            </c:if>
        </td>
        <td style="width: 50px">
            <div align="center">
                <form action="CancelUserController" method="post">
                    <input style="width: 50px" type="submit" value="注销">
                </form>
            </div>
        </td>
    </tr>
</table>
<table border="0">
    <tr>
        <%--<td style="width: 25%">--%>

        <%--<div align="left">--%>
        <%--<form action="SelectMessageByUserNameController" method="post">--%>
        <%--<input type="text" name="name" placeholder="请输入要查询的用户名">--%>
        <%--<input type="submit" value="查询某个用户">--%>
        <%--</form>--%>
        <%--</div>--%>
        <%--</td>--%>
        <td style="width: 200px">
            <div align="left">
                <c:if test="${not empty sessionScope.permission14}">
                    <form action="SelectPersonMessageController" method="post">
                        <input style="width: 200px" type="submit" value="查询个人的留言">
                    </form>
                </c:if>
            </div>
        </td>

        <td style="width: 200px">
            <div align="left">
                <c:if test="${not empty sessionScope.permission15}">
                    <form action="SelectGroupMessageController" method="post">
                        <input style="width: 200px" type="submit" value="查询所在用户组的人的留言">
                    </form>
                </c:if>
            </div>
        </td>
        <td style="width: 200px">
            <div align="left">
                <c:if test="${not empty sessionScope.permission16}">
                    <form action="SelectOtherGroupMessageController" method="post">
                        <input style="width: 200px" type="submit" value="查询其他用户组的人的留言">
                    </form>
                </c:if>
            </div>
        </td>

        <td style="width: 200px">
            <div align="left">
                <c:if test="${not empty sessionScope.permission14 and not empty sessionScope.permission15 and not empty sessionScope.permission16}">
                    <form action="SelectAllMessageController" method="post">
                        <input style="width: 200px" type="submit" value="查询所有人的留言">
                    </form>
                </c:if>
            </div>
        </td>
        <td style="width: 1000px">

        </td>

        <td style="width: 70px">
            <div align="left">
                <c:if test="${not empty sessionScope.permission7}">
                    <form action="create" method="post">
                        <input style="width: 70px" type="submit" value="新建留言">
                    </form>
                </c:if>
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
        <th>所属组</th>
        <th>删除</th>
        <th>编辑</th>
    </tr>

    <c:if test="${sessionScope.pageBean.endIndex>=0}">
        <c:forEach items="${sessionScope.messageSet}" begin="${sessionScope.pageBean.startIndex}"
                   end="${sessionScope.pageBean.endIndex}" step="1" var="m">
            <tr style="height: 41px">
                <td style="width: 5%"><c:out value="${m.id}"/></td>
                <td style="width: 10%"><c:out value="${m.label}"/></td>
                <td style="width: 35%"><c:out value="${m.detail}"/></td>
                <td style="width: 15%"><c:out value="${m.date_create}"/></td>
                <td style="width: 15%"><c:out value="${m.date_edit}"/></td>
                <td style="width: 5%"><c:out value="${m.user_id}"/></td>
                <td style="width: 5%"><c:out value="${m.user.group_id}"/></td>

                <td>
                    <div style=" opacity:0.7;">
                        <form action="DeleteMessageController" method="post">
                            <input type="hidden" name="messageid" value="${m.id}">
                            <c:if test="${(sessionScope.user.id == m.user_id and not empty sessionScope.permission8) or(sessionScope.user.id != m.user_id and sessionScope.user.group_id == m.user.group_id and not empty sessionScope.permission9) or (sessionScope.user.id != m.user_id and sessionScope.user.group_id != m.user.group_id and not empty sessionScope.permission10)}">
                                <input type="submit" value="删除">
                            </c:if>
                        </form>
                    </div>
                </td>

                <td style="width: 5%">
                    <div style=" opacity:0.7">
                        <form action="IntoEditMessageController" method="post">
                            <input type="hidden" name="messageid" value="${m.id}">
                            <c:if test="${(sessionScope.user.id == m.user_id and not empty sessionScope.permission11) or(sessionScope.user.id != m.user_id and sessionScope.user.group_id == m.user.group_id and not empty sessionScope.permission12) or (sessionScope.user.id != m.user_id and sessionScope.user.group_id != m.user.group_id and not empty sessionScope.permission13)}">
                                <input type="submit" value="编辑">
                            </c:if>
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
