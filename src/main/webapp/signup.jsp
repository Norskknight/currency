<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %><%--
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
<body class="container">
<div class="header">Signup Page</div>
<div class="itemFieldContaner">


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
</div>
<tags:links/>
</body>
</html>
