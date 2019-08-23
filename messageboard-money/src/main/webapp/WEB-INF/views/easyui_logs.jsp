<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/23
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>日志记录</title>
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" href="easyui/themes/default/easyui.css" type="text/css"/>
    <link rel="stylesheet" href="easyui/themes/icon.css" type="text/css"/>
    <script>
        function doSearch() {
            $('#dg').datagrid('load', {
                username: $('#username').val(),
            });
        }
        function emptyLogs() {
            var row = $('#dg').datagrid('getSelected');
            if (row) {
                $.messager.confirm('Confirm', '确认清空日志记录', function (r) {
                    if (r) {
                        $.post('easyui_emptyLogs', function (result) {
                            if (result.success) {
                                $('#dg').datagrid('reload');    // reload the user data
                            } else {
                                $.messager.show({    // show error message
                                    title: 'Error',
                                    msg: result.errorMsg
                                });
                            }
                        }, 'json');
                    }
                });
            }
        }

    </script>
</head>
<body>
<table id="dg" title="用戶信息" class="easyui-datagrid"
       url="easyui_queryLogs"
       toolbar="#toolbar"
       rownumbers="true" fitColumns="true" singleSelect="true" pagination="true">
    <thead>
    <tr>
        <th field="user_name" width="10%">用户名</th>
        <th field="user_id" width="10%">用户ID</th>
        <th field="operation" width="42%">操作类型</th>
        <th field="time" width="14%">耗时(ms)</th>
        <th field="result" width="14%">返回结果</th>
        <th field="date" width="14%">操作时间</th>
    </tr>
    </thead>
</table>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="emptyLogs()">清空日志</a>
    <div id="tb" style="padding:3px">
        <span>用户名:</span>
        <input id="username" type="text" style="line-height:26px;border:1px solid #ccc">
        <a href="#" type="text" class="easyui-linkbutton" plain="true" onclick="doSearch()">搜索</a>
    </div>
</div>

</body>
</html>
