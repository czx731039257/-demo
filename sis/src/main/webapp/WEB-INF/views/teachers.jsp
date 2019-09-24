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
        function insertTeacher() {
            $('#dlg').dialog('open').dialog('setTitle', '添加教师');
            $('#fm').form('clear');
            url = 'insertTeacher';
        }

        function editTeacher() {
            var row = $('#dg').datagrid('getSelected');
            if (row) {
                $('#dlg').dialog('open').dialog('setTitle', '编辑教师信息');
                $('#fm').form('load', row);
                url = 'editTeacher?id=' + row.id;
            }
        }


        function saveTeacher() {
            $('#fm').form('submit', {
                url: url,
                type: "POST",
                contentType: "application/json;charset=utf-8",
                onSubmit: function () {
                    return $(this).form('validate');
                },
                success: function (result) {
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

        function removeTeacher() {
            var row = $('#dg').datagrid('getSelected');
            if (row) {
                $.messager.confirm('Confirm', '确认删除该教师的信息吗', function (r) {
                    if (r) {
                        $.post('removeTeacher', {id: row.id}, function (result) {
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

        function logout() {
            window.location.href = 'logout';
        }

    </script>
</head>
<body>

<div class="easyui-layout" fit="true">
    <div region="center" border="false" style="height: 100%">
        <div class="easyui-layout" fit="true">
            <div region="center" border="true" style="border:1px solid #ccc;width: 80%;height: 100%">
                <table id="dg" title="所有学生信息" class="easyui-datagrid" style="width:100%;height:100%"
                       url="queryAllTeacher"
                       toolbar="#toolbar"
                       rownumbers="true" fitColumns="true" singleSelect="true" pagination="true">
                    <thead>
                    <tr>
                        <th field="id" width="14%">学号</th>
                        <th field="name" width="14%">姓名</th>
                        <th field="sex" width="14%">性别</th>
                        <th field="age" width="14%">年龄</th>
                        <th field="phone" width="14%">手机号</th>
                    </tr>
                    </thead>
                </table>
                <div id="toolbar">
                    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
                       onclick="insertTeacher()">添加教师</a>
                    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"
                       onclick="editTeacher()">编辑教师</a>
                    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeTeacher()">删除教师</a>
                    <div id="tb" style="padding:3px">
                        <span>教工号:</span>
                        <input id="id" type="text" style="line-height:26px;border:1px solid #ccc">
                        <span>姓名:</span>
                        <input id="name" style="line-height:26px;border:1px solid #ccc">
                        <a href="#" type="text" class="easyui-linkbutton" plain="true" onclick="doSearch()">搜索</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<!--弹出的表单-->
<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
     closed="true" buttons="#dlg-buttons">
    <div class="ftitle">教师信息</div>
    <form id="fm" method="post">
        <div class="fitem">
            <label>教工号:</label>
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
            <label>手机:</label>
            <input name="phone" class="easyui-validatebox" required="true"/>
        </div>
    </form>
</div>
<div id="dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveTeacher()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel"
       onclick="javascript:$('#dlg').dialog('close')">取消</a>
</div>

</body>
</html>
