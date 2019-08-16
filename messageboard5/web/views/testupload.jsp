<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/16
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传测试页面</title>
</head>
<body>
<form action="fileupload" method="post" enctype="multipart/form-data">
    选择文件:<input type="file" name="file" width="120px">
    <input type="submit" value="上传">
</form>
<form action="selectfilelist">
    <input type="submit" value="显示头像列表">
</form>
</body>
</html>
