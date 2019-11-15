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
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" href="easyui/themes/default/easyui.css" type="text/css"/>
    <link rel="stylesheet" href="easyui/themes/icon.css" type="text/css"/>

    <script>
        function newUser() {
            $('#dlg').dialog('open').dialog('setTitle', '新建留言');
            $('#fm').form('clear');
            url = 'saveUser';
        }

        function editUser() {
            var row = $('#dg').datagrid('getSelected');
            if (row) {
                $('#dlg').dialog('open').dialog('setTitle', '编辑留言');
                $('#fm').form('load', row);
                url = 'editMessage?' + row.id;
            }
        }


        function saveMessage() {
            $('#fm').form('submit', {
                url: url,
                type: "POST",
                contentType: "application/json;charset=utf-8",
                onSubmit: function () {
                    return $(this).form('validate');
                },
                success: function (result) {
                    var result = eval('(' + result + ')');//解析json对象
                    if (result.errorMsg) {
                        $.messager.show({
                            title: 'Error',
                            msg: result.errorMsg
                        });
                    } else {
                        $('#dlg').dialog('close');        // close the dialog
                        $('#dg').datagrid('reload');    // reload the user data
                    }
                }
            });
        }
    </script>
</head>
<body>

<div align="center" style="height: 80%">
    <table id="dg" title="留言榜" class="easyui-datagrid" style="width:90%;height:100%"
           url="test1"
           toolbar="#toolbar"
           rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
        <tr>
            <th field="id" width="10%">留言ID</th>
            <th field="label" width="10%">标题</th>
            <th field="detail" width="42%">内容</th>
            <th field="date_create" width="14%">创建时间</th>
            <th field="date_edit" width="14%">修改时间</th>
            <th field="user_id" width="10%">留言者ID</th>
        </tr>
        </thead>
    </table>
    <div id="toolbar">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">新建留言</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编辑留言</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除留言</a>
    </div>


    <div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
         closed="true" buttons="#dlg-buttons">
        <div class="ftitle">留言信息</div>
        <form id="fm" method="post">
            <div class="fitem">
                <label>标题:</label>
                <input name="label" class="easyui-validatebox" required="true"/>
            </div>
            <div class="fitem">
                <label>内容:</label>
                <input name="detail" class="easyui-validatebox" required="true"/>
            </div>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveMessage()">保存</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel"
           onclick="javascript:$('#dlg').dialog('close')">取消</a>
    </div>


</div>
</body>
</html>
