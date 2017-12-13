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
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>logout Page</title>
</head>
<body>
<%
    session.removeAttribute("userId");
    session.removeAttribute("password");
    session.invalidate();
%>
<center>
    <h1>You have successfully logged out</h1>
    To login again <a href="login.jsp">click here</a>.
</center>
</body>
</html>