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
    <title>账单页面</title>
    <link rel="stylesheet" type="text/css" href="css/background.css">
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" href="easyui/themes/default/easyui.css" type="text/css"/>
    <link rel="stylesheet" href="easyui/themes/icon.css" type="text/css"/>
    <script type="text/javascript">

        //根据后台返回的json数据进行判断
        function chuLi(jsonData) {
            $.procAjaxMsg(jsonData, function () {
                alert(jsonData.backUrl);
                window.location.href = jsonData.backUrl;
            }, function () {
                $.alertMsg(jsonData.errorMsg, "登录提示！");
            });
        }

        //添加dialog窗口，在窗口加两个按钮
        $(function () {
            $('#login').dialog({
                title: "用户登录",
                width: 350,
                height: 200,
                modal: true,
                closable: false,
                collapsible : false,	// 是否折叠
                minimizable :  false,	// 窗口最大化
                maximizable : false,	// 窗口最小化
                resizable : false,	// 是否可调整窗口大小
                buttons: [{
                    text: "登录",
                    iconCls: 'icon-ok',
                    handler: function () {
                        if ($('#loginForm').form('validate')) {//验证表单的正确性
                            $.post("loginVerify",
                                { loginName: $('#loginForm input[name="LoginName"]').val(), loginPwd: $('#loginForm input[name="LoginPwd"]').val() },
                                function (data) {
                                    //chuLi(data);//调用转向函数
                                    if(data.backUrl){
                                        window.location.href = data.backUrl;
                                    }
                                    if(data.errorMsg){
                                        alert(data.errorMsg);
                                    }
                                });
                        }
                    }
                }, {
                    text: "注册",
                    iconCls: 'icon-edit',
                    handler: function () {
                        alert('注册');
                    }
                }]
            })
        })

    </script>
    <style type="text/css">
        .login_item{
            margin:20px auto;

        }
        .login_item span{
            display:inline-block;
            width:100px;
            text-align:right ;
        }

    </style>
</head>
<body>
<br>
<div easyui-dialog id="login">
    <form id="loginForm" action="loginVerify" method="post">
        <div class="login_item"><span>用户名：</span>
            <input type="text" name="LoginName" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写登录名'" /></div>
        <div class="login_item"><span>密    码：</span>
            <input type="password" name="LoginPwd" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写密码'" /></div>
    </form>
</div>

</body>
</html>
