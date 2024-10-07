<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <h2> An Error Has Occured </h2>
    <h3> <%= response.getStatus() %> </h3>
    <p> <%=request.getAttribute("error")%> </p>
</body>
</html>