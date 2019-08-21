<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/20
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>打赏页面</title>
</head>
<body>
<div align="center">
    你当前账户余额：${sessionScope.user.money}
    <form action="rewardSuccess">
        打赏金额：<input type="text" name="money" placeholder="请输入打赏金额">
        <input type="submit" value="确认">
    </form>
</div>
</body>
</html>
