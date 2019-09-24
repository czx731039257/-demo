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

    </script>
</head>
<body>

<div class="easyui-layout" fit="true">
    <div region="north" border="false" class="p-search" style="height: 15%">
        <div class="easyui-layout" fit="true">
            <div region="north" border="false" class="p-search" style="height: 60% ">
                <h1 style="font-size: 20px; font-weight: bolder; letter-spacing: 5px" align="center" >学生信息管理系统</h1>
            </div>
            <div region="south" border="false" class="p-search" style="height: 40%">
                <table style="width: 100%; height: min-content;" border="0">
                    <tr>
                        <td style="width: 6%"><a href="#" class="easyui-linkbutton"
                                                  onclick="addTab('学生管理','students')">学生管理</a>
                        </td>
                        <td style="width: 6%"><a href="#" class="easyui-linkbutton"
                                                  onclick="addTab('课程管理','courses')">课程管理</a></td>
                        <td style="width: 6%"><a href="#" class="easyui-linkbutton"
                                                  onclick="addTab('教师管理','teachers')">教师管理</a>
                        </td>
                        <td style="width: 6%"><a href="#" class="easyui-linkbutton"
                                                  onclick="addTab('班级管理','classes')">班级管理</a></td>
                        <td style="width: 72%"></td>
                        <td style="width: 4%"><a href="#" class="easyui-linkbutton" onclick="logout()">注销</a></td>
                    </tr>
                </table>
            </div>
        </div>
    </div>

    <div region="center" border="false" style="height: 70%">
        <div class="easyui-layout" fit="true">
            <div region="center" border="true" style="border:1px solid #ccc;width: 80%;height: 100%">
                <div id="tt" class="easyui-tabs" style="width: 100%;height: 100%">
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>
