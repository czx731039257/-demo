<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/20
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>充值页面</title>
</head>
<body>
<div align="center">
    当前账户余额：${sessionScope.user.money}
    <form action="rechargeSuccess">
        充值金额：<input type="text" name="money" placeholder="请输入充值金额">
        <input type="submit" value="充值">
    </form>
</div>
</body>
</html>
