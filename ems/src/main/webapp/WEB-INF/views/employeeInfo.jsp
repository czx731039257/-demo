<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/13
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="layui/css/layui.css">
    <script type="text/javascript" src="layui/layui.js"></script>
</head>
<body>


<table id="demo" lay-filter="test"></table>
<script>
    layui.use('table', function(){
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#demo'
            ,height: 312
            ,url: 'queryAllEmployee' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'eno', title: '员工号', width:100, fixed: 'left'}
                ,{field: 'name', title: '姓名', width:80}
                ,{field: 'sex', title: '性别', width:80}
                ,{field: 'age', title: '城市', width:80}
                ,{field: 'post', title: '职位', width: 80}
                ,{field: 'rank', title: '职级', width: 80}
                ,{field: 'department_id', title: '部门id', width: 100}
                ,{field: 'phone', title: '手机号', width: 150}
                ,{field: 'email', title: '邮箱号', width: 150}
                ,{field: 'city', title: '城市', width: 80}
            ]]
        });

    });
</script>
</body>
</html>
