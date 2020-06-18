<%--
  Created by IntelliJ IDEA.
  User: 87472
  Date: 2020/3/3
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>TeacherLogin</title>
  </head>
  <body>
  <div align="center" style="height:400px;width:500px;margin-left: 400px;margin-top: 150px;">
    <%--<form
            action="${pageContext.request.contextPath}/TeacherServlet?operation=login"
            method="post">--%>
      <form
              action="${pageContext.request.contextPath}/app/teacher/tLogin"
              method="post">
        <div style="height: 400px; width: 450px; margin-left: 200px;">
        <table align="center">
          <tr>
            <td><h3>教师登陆</h3></td>

          </tr>
          <tr>
            <td>ID:</td>
            <td><input type="text" required="required" name="id" ></td>
          </tr>
          <tr>
            <td>密码：</td>
            <td><input type="password" required="required" name=password></td>
          </tr>
          <tr>
            <td></td>
            <td><font color="red" >${requestScope.error}</font></td>
          </tr>
          <tr>
            <td><input type="submit" value="登陆"></td>
            <td><input type="reset" value="重置"></td>
            <td>
              <a href="${pageContext.request.contextPath}/app/teacher/registerPage">
                <input type="button" value="注册账号" />
              </a>
            </td>
            <td>
              <a href="${pageContext.request.contextPath}/app/student/sLoginPage">
                <input type="button" value="学生登陆" />
              </a>
            </td>
          </tr>
        </table>
      </div>
    </form>
  </div>
  </body>
</html>
