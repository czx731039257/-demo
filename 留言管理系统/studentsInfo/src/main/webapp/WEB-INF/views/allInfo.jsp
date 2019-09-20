<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/22
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<html>
<head>
    <title>所有用户信息</title>
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" href="easyui/themes/default/easyui.css" type="text/css"/>
    <link rel="stylesheet" href="easyui/themes/icon.css" type="text/css"/>

    <script>
        function doSearch() {
            $('#dg').datagrid('load', {
                messageid: $('#userid').val(),
                username: $('#username').val(),
            });
        }
    </script>
</head>
<body>
<table id="dg" title="所有用户信息" class="easyui-datagrid" style="width:100%;height:100%"
       url="user/queryUsers"
       toolbar="#toolbar"
       rownumbers="true" fitColumns="true" singleSelect="true" pagination="true">
    <thead>
    <tr>
        <th field="id" width="10%">用户ID</th>
        <th field="name" width="10%">用户名</th>
        <th field="email" width="42%">邮箱</th>
        <th field="phone" width="14%">手机</th>
        <th field="group_id" width="14%">所在组</th>
        <th field="money" width="10%">余额</th>
    </tr>
    </thead>
</table>
<div id="toolbar">
    <div id="tb" style="padding:3px">
        <span>用户ID:</span>
        <input id="userid" type="text" style="line-height:26px;border:1px solid #ccc">
        <span>用户名:</span>
        <input id="username" style="line-height:26px;border:1px solid #ccc">
        <a href="#" type="text" class="easyui-linkbutton" plain="true" onclick="doSearch()">搜索</a>
    </div>

</div>

</body>
</html>