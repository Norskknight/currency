<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %><%--
  Created by IntelliJ IDEA.
  User: student
  Date: 12/12/17
  Time: 10:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>admin</title>
    <link rel="stylesheet" href="style.css">
</head>
<body class="container">
<div class="header">Admin Page</div>
<div class="childContaner">
<form action="grabData" method="get">
    <input type="submit" value="grabData">
</form>
    <form action="addAdminItem" method="POST">
        <input type="text" name="item">
        <input type="submit" value="addAdminItem">
    </form>
</div>
<tags:links/>
</body>
</html>
