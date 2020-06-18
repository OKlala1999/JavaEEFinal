<%@ page import="java.util.List" %>
<%@ page import="com.example.hw.db.model.Homework" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomeworkList</title>
</head>
<body>

<table align="center" width="960" border="1"
       bgcolor="black" cellpadding="1" cellspacing="1">
    <tr align="center" bgcolor="#7fffd4" height="50">
        <td>编号</td>
        <td>作业标题</td>
        <td>作业要求</td>
        <td>创建时间</td>
        <td>截止日期</td>
        <td>提交</td>
        <td>操作</td>
    </tr>

    <c:forEach items="${hList}" var="hw">
        <tr align="center" bgcolor="white" height="30">
            <td>${hw.id}</td>
            <td>${hw.title}</td>
            <td>${hw.content}</td>
            <td>${hw.createTime}</td>
            <td>${hw.deadline}</td>
            <td>未提交</td>
            <td><a href="${pageContext.request.contextPath}/app/student/submitPage?hwID=${hw.id}&&sid=${student.id}">提交</a></td>
        </tr>
    </c:forEach>

    <c:forEach items="${subList}" var="hw">
        <tr align="center" bgcolor="white" height="30">
            <td>${hw.id}</td>
            <td>${hw.title}</td>
            <td>${hw.content}</td>
            <td>${hw.createTime}</td>
            <td>${hw.deadline}</td>
            <td>已提交</td>
            <td><a href="${pageContext.request.contextPath}/app/student/updatePage?hwID=${hw.id}&&sid=${student.id}">编辑</a></td>
        </tr>
    </c:forEach>


</table>
</body>
</html>
