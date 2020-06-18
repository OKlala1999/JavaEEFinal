<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StudentLogin</title>
</head>
<body>
<div align="center" style="height:400px;width:500px;margin-left: 400px;margin-top: 150px;">
    <form
            action="${pageContext.request.contextPath}/app/student/sRegister"
            method="post">
        <div style="height: 400px; width: 450px; margin-left: 200px;">
            <table align="center">
                <tr>
                    <td><h3>学生登陆</h3></td>
                </tr>
                <tr>
                    <th>ID:</th>
                    <td><input type="text" required="required" name="id" oninput = "value=value.replace(/[^\d]/g,'')"/></td>
                </tr>
                <tr>
                    <th>名字:</th>
                    <td><input type="text" required="required" name="name" /></td>
                </tr>
                <tr>
                    <th>密码：</th>
                    <td><input type="password" required="required" name=password></td>
                </tr>
                <tr>
                    <td></td>
                    <td><font color="red" >${requestScope.message}</font></td>
                </tr>
                <tr>
                    <td><input type="submit" value="注册"></td>
                    <td><input type="reset" value="重置"></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/app/student/sLoginPage">
                            <input type="button" value="返回登录" />
                        </a>
                    </td>
                </tr>

            </table>
        </div>
    </form>
</div>
</body>
</html>
