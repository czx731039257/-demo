<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/14
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="jquery/jquery-3.2.1.min.js" ></script>
</head>
<body>
    <script>
        $(function(){



           $.ajax({
                type : "GET",
                //请求的媒体类型
                contentType: "application/json;charset=UTF-8",
                //请求地址
                url : "jsontest",
                dataType: "json",
                //请求成
                success : function(result) {
                    window.alert(result);
                },
                //请求失败，包含具体的错误信息
                error : function(e){
                    window.alert(e);
                }
            });
        });
    </script>
</body>
</html>
