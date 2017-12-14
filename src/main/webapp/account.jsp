<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 10/13/17
  Time: 11:47 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account</title>
    <link rel="stylesheet" href="style.css">
</head>
<body class="container">
<div class="header">Account Page</div>
<div class="childContaner">
add Item
<form action="addItem" method="POST">
    <input name="item"/>
    <INPUT TYPE="SUBMIT" VALUE="add item"/>
</form>
    <div>
        <jsp:include page="RetreveUserItems" />
    </div>
</div>
<tags:links/>
</body>
</html>
