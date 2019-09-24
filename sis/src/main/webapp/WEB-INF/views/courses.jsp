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
        function insertCourse() {
            $('#dlg').dialog('open').dialog('setTitle', '添加课程');
            $('#fm').form('clear');
            url = 'insertCourse';
        }

        function editCourse() {
            var row = $('#dg').datagrid('getSelected');
            if (row) {
                $('#dlg').dialog('open').dialog('setTitle', '编辑课程');
                $('#fm').form('load', row);
                url = 'editCourse?id=' + row.id;
            }
        }


        function saveCourse() {
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

        function removeCourse() {
            var row = $('#dg').datagrid('getSelected');
            if (row) {
                $.messager.confirm('Confirm', '确认删除该课程的信息吗', function (r) {
                    if (r) {
                        $.post('removeCourse', {id: row.id}, function (result) {
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
                <table id="dg" title="所有课程信息" class="easyui-datagrid" style="width:100%;height:100%"
                       url="queryAllCourse"
                       toolbar="#toolbar"
                       rownumbers="true" fitColumns="true" singleSelect="true" pagination="true">
                    <thead>
                    <tr>
                        <th field="id" width="14%">课程号</th>
                        <th field="name" width="14%">课程名</th>
                        <th field="classroom" width="14%">教室</th>
                        <th field="date" width="14%">时间</th>
                        <th field="credit" width="14%">学分</th>
                        <th field="teacher_id" width="14%">教师id</th>
                    </tr>
                    </thead>
                </table>
                <div id="toolbar">
                    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
                       onclick="insertCourse()">添加课程</a>
                    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"
                       onclick="editCourse()">编辑课程</a>
                    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeCourse()">删除课程</a>
                    <div id="tb" style="padding:3px">
                        <span>课程号:</span>
                        <input id="id" type="text" style="line-height:26px;border:1px solid #ccc">
                        <span>课程名:</span>
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
    <div class="ftitle">课程信息</div>
    <form id="fm" method="post">
        <div class="fitem">
            <label>课程号:</label>
        </div>
        <div class="fitem">
            <label>课程名:</label>
            <input name="name" class="easyui-validatebox" required="true"/>
        </div>
        <div class="fitem">
            <label>教室:</label>
            <input name="classroom" class="easyui-validatebox" required="true"/>
        </div>
        <div class="fitem">
            <label>时间:</label>
            <input name="date" class="easyui-validatebox" required="true"/>
        </div>
        <div class="fitem">
            <label>学分:</label>
            <input name="credit" class="easyui-validatebox" required="true"/>
        </div>
        <div class="fitem">
            <label>教师id:</label>
            <input name="teacher_id" class="easyui-validatebox" required="true"/>
        </div>
    </form>
</div>
<div id="dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveCourse()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel"
       onclick="javascript:$('#dlg').dialog('close')">取消</a>
</div>

</body>
</html>
