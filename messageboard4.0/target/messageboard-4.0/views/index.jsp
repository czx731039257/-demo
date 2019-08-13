<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/30
  Time: 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>测试页面</title>
  </head>
  <body>
  <c:forEach items="${sessionScope.messageSet}" step="1" var="i">
    <c:out value="${i.id}"/> &nbsp;
  </c:forEach>
  </body>
</html>
