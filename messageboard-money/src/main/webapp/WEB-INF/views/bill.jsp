<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/21
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>账单页面</title>

    <script src="webjars/jquery/3.1.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/background.css">
    <link rel="stylesheet" type="text/css" href="css/form.css">
</head>
<body>
<h1 align="center">账单记录</h1>
<table>
    <%--<tr>--%>
        <%--<td>--%>
            <%--<form action="queryLogByUserName">--%>
                <%--<input type="text" name="username"  placeholder="请输入用户名">--%>
                <%--<input type="submit" value="搜索">--%>
            <%--</form>--%>
        <%--</td>--%>
        <%--<td>--%>
            <%--<form action="queryAllLog">--%>
                <%--<input type="submit" value="查看所有日志">--%>
            <%--</form>--%>
        <%--</td>--%>
        <%--<td>--%>
            <%--<form action="emptyAllLog">--%>
                <%--<input type="submit" value="清空所有日志">--%>
            <%--</form>--%>
        <%--</td>--%>
    <%--</tr>--%>
</table>
<table border="1" cellpadding="0px" cellspacing="0px" style="text-align: center;width: 100%" align="center">
    <tr>
        <th>类型</th>
        <th>金额</th>
        <th>时间</th>
    </tr>

    <c:if test="${sessionScope.pageBeanForBill.endIndex>=0}">
        <c:forEach items="${sessionScope.bill}" begin="${sessionScope.pageBeanForBill.startIndex}"
                   end="${sessionScope.pageBeanForBill.endIndex}" step="1" var="m">
            <tr style="height: 41px">
                <td style="width: 16%"><c:out value="${m.type}"/></td>
                <td style="width: 16%"><c:out value="${m.money}"/></td>
                <td style="width: 16%"><c:out value="${m.date}"/></td>
            </tr>
        </c:forEach>
    </c:if>
</table>
<p align="center">第${sessionScope.pageBeanForBill.pageNumber}页</p><br>


<table border="0" align="center">
    <tr>
        <td>
            <c:if test="${sessionScope.pageBeanForBill.pageNumber>1}">
                <form action="lastPageForBill" method="post">
                    <input type="submit" value="上一页">
                </form>
            </c:if>
        </td>
        <td>
            <c:if test="${sessionScope.pageBeanForBill.pageNumber<sessionScope.pageBeanForBill.totalPage}">
                <form action="nextPageForBill" method="post">
                    <input type="submit" value="下一页">
                </form>
            </c:if>
        </td>
    </tr>
</table>
<div align="center">
    <form action="person">
        <input type="submit" value="返回">
    </form>
</div>

</body>
</html>
