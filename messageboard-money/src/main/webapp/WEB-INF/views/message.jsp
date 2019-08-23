<%@ page import="com.csx.demo2.entity.PageBean" %>
<%@ page import="com.csx.demo2.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/30
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<html>
<head>
    <title>留言板</title>
    <script src="webjars/jquery/3.1.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/background.css">
    <link rel="stylesheet" type="text/css" href="css/form.css">
    <script>
        $(document).ready(function () {
            $(".reward").click(function () {

                while(true) {
                    var str = prompt("请输入打赏的金额（数值类型）:", "1");

                    if(str==null){//用户没有点击了取消
                        break;
                    } else if(!isNaN(str)&&str!=0&&str!=""&&str>=0) {
                        if(parseInt(str)<=parseInt($("#balance").attr("value"))) {
                            $.ajax({
                                type: "GET",
                                url: "reward",
                                contentType: "application/json;charset=utf-8",
                                data: {"money": str, "userid": $(this).parent().parent().attr("id")},
                                dataType: "json",
                                success: function (message) {
                                    alert(message["rewardresult"]);
                                    $("#balance").attr("value",message["balance"]);
                                },
                                error: function (message) {
                                    alert("提交失败"+JSON.stringify(message));
                                }
                            })
                            break;
                        }else{
                            alert("充值失败！\n" +
                                "余额不足，当前用户的余额为："+parseInt($("#balance").attr("value")));
                        }
                    }else{
                        alert("充值失败！\n" +
                            "输入金额格式错误，请输入非零非空的数值！");
                    }
                }
            })
        })
    </script>


</head>
<body>

<%
    String withoutPermission = (String) session.getAttribute("withoutPermission");
    if (withoutPermission != null && withoutPermission.equals("true")) {
%>
<script>
    alert("你没有这个权限");
</script>
<%
        session.removeAttribute("withoutPermission");
    }
%>
<%
    String accesserror = (String) session.getAttribute("accesserror");
    if (accesserror != null && accesserror.equals("true")) {
%>
<script>
    alert("请不要不通过按键直接访问");
</script>
<%
        session.removeAttribute("accesserror");
    }
%>
<%--<input id="balance" type="hidden" name="balance" value="${sessionScope.user.money}">--%>

<div align="center" style="opacity: 0.7">
    <h1>欢迎:${sessionScope.user.name}</h1>
</div>
<input id="balance" type="hidden" name="balance" value="${sessionScope.user.money}">
<table border="0">
    <tr>
        <td style="width: 200px">
            <shiro:hasPermission name="浏览自己的用户信息">
                <form action="queryPersonInfo" method="post">
                    <input style="width: 200px" type="submit" value="查看个人用户信息">
                </form>
            </shiro:hasPermission>
        </td>
        <td style="width: 200px">
            <div align="left">
                <shiro:hasPermission name="浏览所在用户组的人的用户信息">
                    <form action="querySameGroupUserInfo" method="post">
                        <input style="width: 200px" type="submit" value="查看所在用户组的用户信息">
                    </form>
                </shiro:hasPermission>
            </div>
        </td>
        <td style="width: 200px">
            <div align="left">
                <shiro:hasPermission name="浏览其他用户组的人的用户信息">
                    <form action="queryOtherGroupUserInfo" method="post">
                        <input style="width: 200px" type="submit" value="查看其他用户组的用户信息">
                    </form>
                </shiro:hasPermission>
            </div>
        </td>
        <td style="width: 200px">
            <div align="left">
                <shiro:hasPermission name="浏览自己的用户信息">
                    <shiro:hasPermission name="浏览所在用户组的人的用户信息">
                        <shiro:hasPermission name="浏览其他用户组的人的用户信息">
                            <form action="queryAllUserInfo" method="post">
                                <input style="width: 200px" type="submit" value="查看所有用户信息">
                            </form>
                        </shiro:hasPermission>
                    </shiro:hasPermission>
                </shiro:hasPermission>
            </div>
        </td>
        <td style="width: 1000px">
        </td>
        <th style="width:110px">
            <shiro:hasPermission name="查看日志">
                <form action="queryAllLog">
                    <input style="width: 110px" type="submit" value="查看日志">
                </form>
            </shiro:hasPermission>
        </th>
        <td style="width: 110px">
            <shiro:hasPermission name="给用户分配角色和权限">
                <form action="queryAllRoles">
                    <input style="width: 110px" type="submit" value="查看角色及权限">
                </form>
            </shiro:hasPermission>
        </td>
        <td style="width: 50px">
            <div align="center">
                <form action="logout" method="post">
                    <input style="width: 50px" type="submit" value="注销">
                </form>
            </div>
        </td>
    </tr>
</table>
<table border="0">
    <tr>
        <td style="width: 200px">
            <div align="left">
                <shiro:hasPermission name="浏览自己的留言">
                    <form action="queryPersonMessage" method="post">
                        <input style="width: 200px" type="submit" value="查询个人的留言">
                    </form>
                </shiro:hasPermission>
            </div>
        </td>

        <td style="width: 200px">
            <div align="left">
                <shiro:hasPermission name="浏览所在组的人的留言">
                    <form action="querySameGroupMessage" method="post">
                        <input style="width: 200px" type="submit" value="查询所在用户组的人的留言">
                    </form>
                </shiro:hasPermission>
            </div>
        </td>
        <td style="width: 200px">
            <div align="left">
                <shiro:hasPermission name="浏览其他组的人的留言">
                    <form action="queryOtherGroupMessage" method="post">
                        <input style="width: 200px" type="submit" value="查询其他用户组的人的留言">
                    </form>
                </shiro:hasPermission>
            </div>
        </td>

        <td style="width: 200px">
            <div align="left">
                <shiro:hasPermission name="浏览自己的留言">
                    <shiro:hasPermission name="浏览所在组的人的留言">
                        <shiro:hasPermission name="浏览其他组的人的留言">
                            <form action="queryAllMessage" method="post">
                                <input style="width: 200px" type="submit" value="查询所有人的留言">
                            </form>
                        </shiro:hasPermission>
                    </shiro:hasPermission>
                </shiro:hasPermission>
            </div>
        </td>
        <td style="width: 1000px">

        </td>

        <td style="width: 70px">
            <div align="left">
                <shiro:hasPermission name="新建留言">
                    <form action="create" method="post">
                        <input style="width: 70px" type="submit" value="新建留言">
                    </form>
                </shiro:hasPermission>
            </div>
        </td>
    </tr>
</table>


<table border="1" cellpadding="0px" cellspacing="0px" style="text-align: center;width: 100%" align="center">
    <tr>
        <th>留言序号</th>
        <th>标题</th>
        <th>内容</th>
        <th>创建时间</th>
        <th>修改时间</th>
        <th>留言者</th>
        <th>所属组</th>
        <th>打赏</th>
        <th>删除</th>
        <th>编辑</th>
    </tr>

    <c:if test="${sessionScope.pageBean.endIndex>=0}">
        <c:forEach items="${sessionScope.messageSet}" begin="${sessionScope.pageBean.startIndex}"
                   end="${sessionScope.pageBean.endIndex}" step="1" var="m">
            <tr id="${m.user_id}" style="height: 41px">
                <td style="width: 5%"><c:out value="${m.id}"/></td>
                <td style="width: 10%"><c:out value="${m.label}"/></td>
                <td style="width: 35%"><c:out value="${m.detail}"/></td>
                <td style="width: 15%"><c:out value="${m.date_create}"/></td>
                <td style="width: 15%"><c:out value="${m.date_edit}"/></td>
                <td style="width: 5%"><c:out value="${m.user_id}"/></td>
                <td style="width: 5%"><c:out value="${m.user.group_id}"/></td>

                <td>
                    <c:if test="${sessionScope.user.id !=m.user_id}">
                        <%--<form action="reward">--%>
                            <%--<input type="hidden" name="messagehostid" value="${m.user_id}">--%>
                            <%--<input type="submit" value="打赏">--%>
                        <%--</form>--%>
                        <input class="reward" type="button" value="打赏">
                    </c:if>
                </td>
                <td>
                    <div>
                        <form action="deleteMessage" method="post">
                            <input type="hidden" name="messageid" value="${m.id}">
                            <c:choose>
                                <c:when test="${sessionScope.user.id == m.user_id}">
                                    <shiro:hasPermission name="删除自己的留言">
                                        <input type="submit" value="删除">
                                    </shiro:hasPermission>
                                </c:when>
                                <c:otherwise>
                                    <c:choose>
                                        <c:when test="${sessionScope.user.group_id == m.user.group_id}">
                                            <shiro:hasPermission name="删除所在用户组的人的留言">
                                                <input type="submit" value="删除">
                                            </shiro:hasPermission>
                                        </c:when>
                                        <c:otherwise>
                                            <shiro:hasPermission name="删除其他用户组的人的留言">
                                                <input type="submit" value="删除">
                                            </shiro:hasPermission>
                                        </c:otherwise>
                                    </c:choose>
                                </c:otherwise>
                            </c:choose>

                        </form>
                    </div>
                </td>

                <td>
                    <div>
                        <form action="intoEditMessage" method="post">
                            <input type="hidden" name="messageid" value="${m.id}">
                            <c:choose>
                                <c:when test="${sessionScope.user.id == m.user_id}">
                                    <shiro:hasPermission name="编辑自己的留言">
                                        <input type="submit" value="编辑">
                                    </shiro:hasPermission>
                                </c:when>
                                <c:otherwise>
                                    <c:choose>
                                        <c:when test="${sessionScope.user.group_id == m.user.group_id}">
                                            <shiro:hasPermission name="编辑所在用户组的人的留言">
                                                <input type="submit" value="编辑">
                                            </shiro:hasPermission>
                                        </c:when>
                                        <c:otherwise>
                                            <shiro:hasPermission name="编辑其他用户组的人的留言">
                                                <input type="submit" value="编辑">
                                            </shiro:hasPermission>
                                        </c:otherwise>
                                    </c:choose>
                                </c:otherwise>
                            </c:choose>


                        </form>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>
<p align="center">第${sessionScope.pageBean.pageNumber}页</p><br>


<table border="0" align="center">
    <tr>
        <td>
            <c:if test="${sessionScope.pageBean.pageNumber>1}">
                <form action="lastPageForMessage" method="post">
                    <input type="submit" value="上一页">
                </form>
            </c:if>
        </td>
        <td>
            <c:if test="${sessionScope.pageBean.pageNumber<sessionScope.pageBean.totalPage}">
                <form action="nextPageForMessage" method="post">
                    <input type="submit" value="下一页">
                </form>
            </c:if>
        </td>
    </tr>
</table>

</body>
</html>
