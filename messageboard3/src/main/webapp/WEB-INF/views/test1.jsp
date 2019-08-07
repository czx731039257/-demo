<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>测试页面一</title>

</head>
<body>
    <div>给角色设置权限页面</div>
    <form action="testcontroller1">
        <input type="checkbox" name="permission" value="canEditPersonInfo">编辑自己的用户信息<br>
        <input type="checkbox" name="permission" value="canEditGroupInfo">编辑所在组的用户信息<br>
        <input type="checkbox" name="permission" value="canEditOtherGroupInfo">编辑其他组的用户信息<br>
        <input type="checkbox" name="permission" value="canSelectPersonInfo">浏览自己的留言<br>
        <input type="checkbox" name="permission" value="canSelectGroupInfo">浏览同组的留言<br>
        <input type="checkbox" name="permission" value="canSelectOtherGroupInfo">浏览其他组的留言<br>
        <input type="checkbox" name="permission" value="canCreateMessage">新建留言<br>
        <input type="checkbox" name="permission" value="canDeletePersonMessage">删除自己的留言<br>
        <input type="checkbox" name="permission" value="canDeleteGroupMessage">删除同组的人的留言<br>
        <input type="checkbox" name="permission" value="canDeleteOtherGroupMessage">删除其他组的人的留言<br>
        <input type="checkbox" name="permission" value="canEditPersonMessage">编辑自己的留言<br>
        <input type="checkbox" name="permission" value="canEditGroupMessage">编辑同组的人的留言<br>
        <input type="checkbox" name="permission" value="canEditOtherGroupMessage">编辑其他组的人的留言<br>
        <input type="checkbox" name="permission" value="canSelectPersonMessage">浏览自己的留言<br>
        <input type="checkbox" name="permission" value="canSelectGroupMessage">浏览同组的人的浏览<br>
        <input type="checkbox" name="permission" value="canSelectOtherGroupMessage">浏览其他组的人的浏览<br>
        <input type="checkbox" name="permission" value="canAllocationRole">给用户分配角色<br>
        <input type="checkbox" name="permission" value="canAllocationPermission">给用户分配权限<br>
    </form>
</body>