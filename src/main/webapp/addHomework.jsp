<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.*"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-image: url(${pageContext.request.contextPath}/pic/body.jpg)">

<form 
action="${pageContext.request.contextPath}/app/teacher/addHomework?tid=${tid}"
		method="post">
		<table align="center">

			<tr>
				<td>作业标题：</td>
				<td><input name="hwTitle" style="width:500px"></td>
			</tr>
			<tr>
				<td>截止日期：</td>
				<td><input name="deadline" type="datetime-local" style="width: 500px"></td>
			</tr>
			<tr>
				<td>作业要求：</td>
				<td><textarea rows="20" cols="80" name="hwContent"  required="true"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="布置作业" /> 
				</td>
			</tr>
			<tr>
				<td></td>
				<td><font color="red" >${requestScope.message}</font></td>
			</tr>
		</table>
</form>
</body>
</html>