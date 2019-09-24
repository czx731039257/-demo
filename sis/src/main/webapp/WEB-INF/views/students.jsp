<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/22
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<html>
<head>
    <title>easyui</title>
    <link rel="stylesheet" type="text/css" href="css/background.css">
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" href="easyui/themes/default/easyui.css" type="text/css"/>
    <link rel="stylesheet" href="easyui/themes/icon.css" type="text/css"/>


    <script>
        function insertStudent() {
            $('#dlg').dialog('open').dialog('setTitle', '添加学生');
            $('#fm').form('clear');
            url = 'insertStudent';
        }

        function editStudent() {
            var row = $('#dg').datagrid('getSelected');
            if (row) {
                $('#dlg').dialog('open').dialog('setTitle', '编辑学生');
                $('#fm').form('load', row);
                url = 'editStudent?id=' + row.id;
            }
        }


        function saveStudent() {
            $('#fm').form('submit', {
                url: url,
                type: "POST",
                contentType: "application/json;charset=utf-8",
                onSubmit: function () {
                    return $(this).form('validate');
                },
                success: function (result) {
                    //var result = eval('(' + result + ')');//解析json对象
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

        function removeStudent() {
            var row = $('#dg').datagrid('getSelected');
            if (row) {
                $.messager.confirm('Confirm', '确认删除该学生的信息吗', function (r) {
                    if (r) {
                        $.post('removeStudent', {id: row.id}, function (result) {
                            if (result.successMsg) {
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


        function doSearch() {
            $('#dg').datagrid('load', {
                id: $('#id').val(),
                name: $('#name').val(),
                major: $('#major').val(),
                class_id: $('#class_id').val()
            });
        }

        function addTab(title, url) {
            if ($('#tt').tabs('exists', title)) {
                var tab = $('#tt').tabs('getTab', title);
                tab.panel('open').panel('refresh', url);
            } else {
                var content = '<iframe scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
                $('#tt').tabs('add', {
                    title: title,
                    content: content,
                    closable: true
                });
            }

            var tab = $('#tt').tabs('getSelected');
            tab.panel('open').panel('refresh', url);
        }


        function logout() {
            window.location.href = 'logout';
        }

        function test() {
            alert("sxxxxx");
        }

    </script>
</head>
<body>

<table id="dg" title="所有学生信息" class="easyui-datagrid" style="width:100%;height:100%"
       url="queryAllStudent"
       toolbar="#toolbar"
       rownumbers="true" fitColumns="true" singleSelect="true" pagination="true">
    <thead>
    <tr>
        <th field="id" width="14%">学号</th>
        <th field="name" width="14%">姓名</th>
        <th field="sex" width="14%">性别</th>
        <th field="age" width="14%">年龄</th>
        <th field="major" width="14%">专业</th>
        <th field="phone" width="14%">手机号</th>
        <th field="class_id" width="14%">所在班级</th>
    </tr>
    </thead>
</table>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
       onclick="insertStudent()">添加学生</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"
       onclick="editStudent()">编辑学生</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
       onclick="removeStudent()">删除学生</a>
    <div id="tb" style="padding:3px">
        <span>学号:</span>
        <input id="id" type="text" style="line-height:26px;border:1px solid #ccc">
        <span>姓名:</span>
        <input id="name" style="line-height:26px;border:1px solid #ccc">
        <span>专业:</span>
        <input id="major" type="text" style="line-height:26px;border:1px solid #ccc">
        <span>班级:</span>
        <input id="class_id" type="text" style="line-height:26px;border:1px solid #ccc">
        <a href="#" type="text" class="easyui-linkbutton" plain="true"
           onclick="doSearch()">搜索</a>
    </div>
</div>


<!--弹出的表单-->
<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
     closed="true" buttons="#dlg-buttons">
    <div class="ftitle">学生信息</div>
    <form id="fm" method="post">
        <div class="fitem">
            <label>学号:</label>
        </div>
        <div class="fitem">
            <label>姓名:</label>
            <input name="name" class="easyui-validatebox" required="true"/>
        </div>
        <div class="fitem">
            <label>性别:</label>
            <input name="sex" class="easyui-validatebox" required="true"/>
        </div>
        <div class="fitem">
            <label>年龄:</label>
            <input name="age" class="easyui-validatebox" required="true"/>
        </div>
        <div class="fitem">
            <label>专业:</label>
            <input name="major" class="easyui-validatebox" required="true"/>
        </div>
        <div class="fitem">
            <label>手机:</label>
            <input name="phone" class="easyui-validatebox" required="true"/>
        </div>
        <div class="fitem">
            <label>班级:</label>
            <input name="class_id" class="easyui-validatebox" required="true"/>
        </div>
    </form>
</div>
<div id="dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveStudent()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel"
       onclick="javascript:$('#dlg').dialog('close')">取消</a>
</div>

</body>
</html>
