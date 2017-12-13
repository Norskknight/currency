<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 12/12/17
  Time: 9:55 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="style.css">
    <title>logout Page</title>
</head>
<body class="container">

<%
    session.removeAttribute("userId");
    session.removeAttribute("password");
    session.invalidate();
%>
<div class="header">Logout</div>
<div class="childContaner">
    <h1>You have successfully logged out</h1>
</div>
<tags:links/>
</body>
</html>