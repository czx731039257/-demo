<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	前端找不到了！ 这是自己写的测试前端
<br/>------------------------------------<br/>
测试1：增加学生信息<br/>
	    <form action="student/insertStudent">
		学号:<input type="text" name="sno"/><br/>
		姓名:<input type="text" name="name"/><br/>
		年龄:<input type="text" name="age"/><br/>
		性别:<input type="text" name="sex"/><br/>
		专业:<input type="text" name="major"/><br/>
		<input type="submit" value="提交"/>
	</form>
<br/>------------------------------------<br/>	
测试2：删除学生信息<br/>
	    <form action="student/deleteStudentBySno">
		学号:<input type="text" name="sno"/><br/>
		<input type="submit" value="提交"/>
	</form>
<br/>------------------------------------<br/>	
测试3：修改学生信息<br/>
	<form action="student/updatestudentBySno">
		学号:<input type="text" name="sno"/><br/>
		姓名:<input type="text" name="name"/><br/>
		年龄:<input type="text" name="age"/><br/>
		性别:<input type="text" name="sex"/><br/>
		专业:<input type="text" name="major"/><br/>
		<input type="submit" value="提交"/>
	</form>
<br/>------------------------------------<br/>	
测试4：查找学生信息<br/>
	<form action="student/queryStudentBySno">
		学号:<input type="text" name="sno"/><br/>
		姓名:<input type="text" name="name"/><br/>
		年龄:<input type="text" name="age"/><br/>
		性别:<input type="text" name="sex"/><br/>
		专业:<input type="text" name="major"/><br/>
		<input type="submit" value="提交"/>
	</form>	
	
</body>
</html>