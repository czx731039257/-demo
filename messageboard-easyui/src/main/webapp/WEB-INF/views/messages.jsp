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
        function newMessage() {
            $('#dlg').dialog('open').dialog('setTitle', '新建留言');
            $('#fm').form('clear');
            url = 'message/createMessage';
        }

        function editMessage() {
            var row = $('#dg').datagrid('getSelected');
            if (row) {
                $('#dlg').dialog('open').dialog('setTitle', '编辑留言');
                $('#fm').form('load', row);
                url = 'message/editMessage?messageid=' + row.id + '&user_id=' + row.user_id;
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

        function removeMessage() {
            var row = $('#dg').datagrid('getSelected');
            if (row) {
                $.messager.confirm('Confirm', '确认删除这条留言吗', function (r) {
                    if (r) {
                        $.post('message/removeMessage', {messageid: row.id},function (result) {
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
                messageid: $('#messageid').val(),
                username: $('#username').val(),
                groupid: $('#groupid').val()
            });

            // var op = $("#dg").datagrid("options");//获取 option设置对象
            // op.url = "message/asd";//设置url
            // $("#dg").datagrid("load");//重新加载
            // alert(op.url);

        }

        function addTab(title, url){

            // if ($('#tt').tabs('exists', title)){
            //     $('#tt').tabs('select', title);
            // } else {
            //     var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
            //     $('#tt').tabs('add',{
            //         title:title,
            //         content:content,
            //         closable:true
            //     });
            // }


            if($('#tt').tabs('exists',title)){
                var tab=$('#tt').tabs('getTab',title);
                tab.panel('open').panel('refresh',url);
            }else{
                var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
                    $('#tt').tabs('add',{
                        title:title,
                        content:content,
                        closable:true
                    });
            }

            var tab=$('#tt').tabs('getSelected');
            tab.panel('open').panel('refresh',url);
            // $('#tt').tabs('update',{
            //     tab:tab,
            //     options:{
            //
            //     }
            // });
            // tab.panel('refresh');
        }


        function logout() {
           window.location.href='logout';
        }

        function test() {
            alert("sxxxxx");
        }

    </script>
</head>
<body>

<div class="easyui-layout" fit="true">
    <div region="north" border="false" class="p-search" >
        <table style="width: 100%"  border="0"><tr>
            <td><a href="#" class="easyui-linkbutton" onclick="addTab('用戶管理','users')">用户管理</a></td>
            <td><a href="#" class="easyui-linkbutton" onclick="addTab('日志管理','')">日志管理</a></td>
            <td><a href="#" class="easyui-linkbutton" onclick="addTab('同组的人的留言','groupmessages')">同组的人的留言</a></td>
            <td style="width: 85%"></td>
            <td><a href="#" class="easyui-linkbutton" onclick="logout()">注销</a></td>
        </tr></table>
    </div>

    <div region="center" border="false" style="height: 100%">
        <div class="easyui-layout" fit="true">
            <div region="center" border="true" style="border:1px solid #ccc;width: 80%;height: 100%">
                <div  id="tt" class="easyui-tabs" style="width: 100%;height: 100%">
                    <div title="留言管理" style="height: 100%" closable="true">
                        <!--留言榜-->
                            <table id="dg" title="所有留言" class="easyui-datagrid" style="width:100%;height:100%"
                                   url="message/queryAllMessages"
                                   toolbar="#toolbar"
                                   rownumbers="true" fitColumns="true" singleSelect="true" pagination="true">
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
                                <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newMessage()">新建留言</a>
                                <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editMessage()">编辑留言</a>
                                <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeMessage()">删除留言</a>
                                <div id="tb" style="padding:3px">
                                    <span>留言ID:</span>
                                    <input id="messageid" type="text" style="line-height:26px;border:1px solid #ccc">
                                    <span>留言者姓名:</span>
                                    <input id="username" style="line-height:26px;border:1px solid #ccc">
                                    <span>组号:</span>
                                    <input id="groupid" type="text" style="line-height:26px;border:1px solid #ccc">
                                    <a href="#" type="text" class="easyui-linkbutton" plain="true" onclick="doSearch()">搜索</a>
                                </div>

                            </div>
                    </div>
                </div>
            </div>
            <div region="west" border="true" class="p-left" style="width: 20%">
                <div id="sm" class="easyui-sidemenu" data-options="data:data" style="width: 100%;height: max-content"></div>
                <script type="text/javascript">
                    var data = [{
                        text: '留言管理',
                        iconCls: 'icon-more',
                        state: 'open',
                        children: [{
                            text: '<a href="#" style="text-decoration : none;color: black" class="easyui-linkbutton" plain="true" onclick="addTab(\'留言管理\',\'personmessages\')">个人留言</a>'
                        },{
                            text: '<a href="#" style="text-decoration : none;color: black" class="easyui-linkbutton" plain="true" onclick="addTab(\'留言管理\',\'groupmessages\')">同组留言</a>'
                        },{
                            text: '<a href="#" style="text-decoration : none;color: black" class="easyui-linkbutton" plain="true" onclick="addTab(\'留言管理\',\'allmessages\')">全部留言</a>'
                        }]
                    },{
                        text: '用户管理',
                        iconCls: 'icon-more',
                        children: [{
                            text: '<a href="#" style="text-decoration : none;color: black" class="easyui-linkbutton" plain="true" onclick="addTab(\'用户管理\',\'personInfo\')">个人信息</a>'
                        },{
                            text: '<a href="#" style="text-decoration : none;color: black" class="easyui-linkbutton" plain="true" onclick="addTab(\'用户管理\',\'allInfo\')">所有用户信息</a>'
                        },]
                    },{
                        text: '账单管理',
                        iconCls: 'icon-more',
                        children: [{
                            text: '<a href="#" style="text-decoration : none;color: black" class="easyui-linkbutton" plain="true" onclick="addTab(\'账单管理\',\'bills\')">个人账单</a>'
                        }]
                    },{
                        text: '群组管理',
                        iconCls: 'icon-more',
                        children: [{
                            text: '群组成员管理'
                        }]
                    },{
                        text: '日志管理',
                        iconCls: 'icon-more',
                        children: [{
                            text: '<a href="#" style="text-decoration : none;color: black" class="easyui-linkbutton" plain="true" onclick="addTab(\'日志管理\',\'allmessages\')">个人日志</a>'
                        },{
                            text: '<a href="#" style="text-decoration : none;color: black" class="easyui-linkbutton" plain="true" onclick="addTab(\'日志管理\',\'allmessages\')">所有用户的日志</a>'
                        }]
                    },{
                        text: '权限管理',
                        iconCls: 'icon-more',
                        children: [{
                            text: '用户角色管理'
                        },{
                            text: '角色权限管理'
                        }]
                    }];

                </script>
                
            </div>
        </div>
    </div>
</div>






    <!--弹出的表单-->
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

<%--<script>--%>
    <%--$('#testdrag').draggable();--%>
<%--</script>--%>

</body>
</html>
