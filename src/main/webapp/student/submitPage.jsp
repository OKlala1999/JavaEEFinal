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
        action="${pageContext.request.contextPath}/app/student/submit"
        method="post">
    <table align="center">
        <tr>
            <td>学生学号：</td>
            <td><input name="sID" readonly style="width:500px" value="${pageContext.request.getParameter("sid")}"></td>
        </tr>
        <tr>
            <td>作业编号：</td>
            <td><input name="hwID" readonly style="width:500px" value="${pageContext.request.getParameter("hwID")}"></td>
        </tr>
        <tr>
            <td>作业标题：</td>
            <td><input name="hwTitle" readonly style="width:500px" value="${pageContext.request.getAttribute("title")}"></td>
        </tr>
        <tr>
            <td>截止日期：</td>
            <td><input name="deadline" readonly style="width: 500px" value="${pageContext.request.getAttribute("ddl")}"></td>
        </tr>
        <tr>
            <td>作业内容：</td>
            <td><textarea rows="20" cols="80" name="hwContent"></textarea></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="提交" />
            </td>
        </tr>
    </table>
</form>
</body>
</html>