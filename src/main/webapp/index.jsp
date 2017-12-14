
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <link rel="stylesheet" href="style.css">
</head>
<body class="container">
<div class="header">Item Tracker</div>
<div class="childContaner">
    <div>
        <jsp:include page="RetreveItems" />
    </div>
</div>
<tags:links/>
</body>
</html>