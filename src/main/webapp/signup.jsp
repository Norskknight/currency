<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 10/13/17
  Time: 11:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Signup</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<form action="RegisterServlet" method="POST">
    <table align="center" cellpadding = "10">
        <tr>
            <td>User name</td>
            <td><input type="text" name="userId" maxlength="100" /></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="text" name="password" maxlength="100" /></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Submit">
                <input type="reset" value="Reset">
            </td>
        </tr>
    </table>
</form>
<a href="index.jsp">back</a>
</body>
</html>
