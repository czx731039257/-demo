<%@ page import="com.demo.dao.PageBean" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/30
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>留言板</title>
</head>
<body>


<table border="1" style="text-align: center;width: 100%" align="center">
    <tr>
        <th>留言序号</th><th>标题</th><th>内容</th><th>创建时间</th><th>修改时间</th><th>留言者</th><th>删除</th><th>编辑</th>
    </tr>
    <!--begin=${sessionScope.pageBean.startIndex} end=${sessionScope.pageBean.endIndex}-->
    <c:forEach items="${sessionScope.messageSet}" begin="${sessionScope.pageBean.startIndex}" end="${sessionScope.pageBean.endIndex}" step="1" var="m">
        <tr>
            <td style="width: 5%"><c:out value="${m.id}"/></td>
            <td style="width: 10%"><c:out value="${m.label}"/></td>
            <td style="width: 50%"><c:out value="${m.detail}"/></td>
            <td style="width: 15%"><c:out value="${m.date_create}"/></td>
            <td style="width: 15%"><c:out value="${m.date_edit}"/></td>
            <td style="width: 5%"><c:out value="${m.user_id}"/></td>

            <td>
                <div align="center" style="padding: auto">
                <form action="delete" method="post" >
                <input type="hidden" name="messageid" value="${m.id}">
                <input type="submit" value="删除">
                </form>
                </div>
            </td>

            <td>
                <div align="center" style="padding: auto">
                <form action="edit" method="post">
                <input type="hidden" name="messageid" value="${m.id}">
                <input type="submit" value="编辑">
                </form>
                </div>
            </td>

        </tr>
    </c:forEach>
</table>
<p align="center">第${sessionScope.pageBean.pageNumber}页</p><br>

<c:if test="${sessionScope.pageBean.pageNumber>1}">
<div align="center">
 <form action="lastpage" method="post" >
     <input type="submit" value="上一页" >
 </form>
</div>
</c:if>

<c:if test="${sessionScope.pageBean.pageNumber<sessionScope.pageBean.totalPage}">
<div align="center">
 <form action="nextpage" method="post">
     <input type="submit" value="下一页">
 </form>
</div>
</c:if>

<div align="center">
<form action="create.jsp" method="post">
    <input type="submit" value="新建">
</form>
</div>

<div align="center">
<form action="cancel" method="post">
<input type="submit" value="注销">
</form>
</div>
</body>
</html>
