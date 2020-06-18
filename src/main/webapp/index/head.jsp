<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title >教师</title>
	<style>
		a {
			text-decoration: NONE
		}
	</style>
	<style>
		ul {
			list-style-type: none;
			margin: 0;
			padding: 0;
		}

		li {
			display: inline;
			float: left;
			width: 120px;
			text-align: center;
		}

		a {
			text-decoration: none;
			font-size: 15px;
			display: block;
			padding: 8px;
			color: #000000;
		}

		a:hover {
			background-color: #ffffff;
			color: orange;
		}
	</style>
</head>
<body>
	<div align="center" style="height: 50px; font-size: 40px; width: 400px; margin-left: 400px; color: #888888;">教师</div>
	<div style="height: 30px; margin: 0px auto 0 1px;">
		<ul>
<%--			<li><a href="${pageContext.request.contextPath}/app/teacher/addStudentPage" target="body">添加学生</a></li>--%>
			<li><a href="${pageContext.request.contextPath}/app/teacher/addHomeworkPage" target="body">添加作业</a></li>
			<li><a href=${pageContext.request.contextPath}/app/teacher/listHomework target="body">作业查看</a></li>
			<li ><a href="${pageContext.request.contextPath}/app/teacher/tLoginPage" target="_parent">退出</a></li>
		</ul>

	</div>

</body>
</html>