<%@ page import="java.util.List" %>
<%@ page import="com.example.hw.db.model.Homework" %>
<%--<%@ page import="com.javaee.code.class2.jdbc.HomeworkJDBC" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
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
      <td>查看学生作业</td>
    </tr>

    <c:forEach items="${hList}" var="hw">
      <tr align="center" bgcolor="white" height="30">
        <td>${hw.id}</td>
        <td>${hw.title}</td>
        <td>${hw.content}</td>
        <td>${hw.createTime}</td>
        <td>${hw.deadline}</td>
        <td><a href="${pageContext.request.contextPath}/app/teacher/listStudentHomework?hwID=${hw.id}">查看提交情况</a></td>
      </tr>
    </c:forEach>
  </table>
  </body>
</html>
