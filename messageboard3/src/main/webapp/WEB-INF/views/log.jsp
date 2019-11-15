<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/15
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>日志记录</title>
    <title>留言板</title>
    <link rel="stylesheet" type="text/css" href="css/background.css">
    <link rel="stylesheet" type="text/css" href="css/form.css">
</head>
<body>
<%
    String finderror = (String) request.getSession().getAttribute("finderror");
    if (finderror != null && finderror.equals("empty")) {
%>
<script>
    alert("输入不能为空！")
</script>
<%
        request.getSession().removeAttribute("finderror");
    }
%>

<h1 align="center">日志记录</h1>
<table>
    <tr>
        <td>
            <form action="queryLogByUserName">
                <input type="text" name="username" placeholder="请输入用户名">
                <input type="submit" value="搜索">
            </form>
        </td>
        <td>
            <form action="queryAllLog">
                <input type="submit" value="查看所有日志">
            </form>
        </td>
        <td>
            <form action="emptyAllLog">
                <input type="submit" value="清空所有日志">
            </form>
        </td>
    </tr>
</table>
<table border="1" cellpadding="0px" cellspacing="0px" style="text-align: center;width: 100%" align="center">
    <tr>
        <th>用户名</th>
        <th>用户ID</th>
        <th>操作名称</th>
        <th>操作耗时</th>
        <th>返回结果</th>
        <th>操作时间</th>
    </tr>

    <c:if test="${sessionScope.pageBeanForLog.endIndex>=0}">
        <c:forEach items="${sessionScope.logs}" begin="${sessionScope.pageBeanForLog.startIndex}"
                   end="${sessionScope.pageBeanForLog.endIndex}" step="1" var="m">
            <tr style="height: 41px">
                <td style="width: 16%"><c:out value="${m.user_name}"/></td>
                <td style="width: 16%"><c:out value="${m.user_id}"/></td>
                <td style="width: 16%"><c:out value="${m.operation}"/></td>
                <td style="width: 16%"><c:out value="${m.time}ms"/></td>
                <td style="width: 16%"><c:out value="${m.result}"/></td>
                <td style="width: 16%"><c:out value="${m.date}"/></td>
            </tr>
        </c:forEach>
    </c:if>
</table>
<p align="center">第${sessionScope.pageBeanForLog.pageNumber}页</p><br>


<table border="0" align="center">
    <tr>
        <td>
            <c:if test="${sessionScope.pageBeanForLog.pageNumber>1}">
                <form action="lastPageForLog" method="post">
                    <input type="submit" value="上一页">
                </form>
            </c:if>
        </td>
        <td>
            <c:if test="${sessionScope.pageBeanForLog.pageNumber<sessionScope.pageBeanForLog.totalPage}">
                <form action="nextPageForLog" method="post">
                    <input type="submit" value="下一页">
                </form>
            </c:if>
        </td>
    </tr>
</table>
<div align="center">
    <form action="message">
        <input type="submit" value="返回">
    </form>
</div>

</body>
</html>
