<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <link rel="stylesheet" href="resources/css/bootstrap.min.css" >

</head>
<body>
    <div class="container">
        <h2> An Error Has Occured </h2>
        <h3> <%= response.getStatus() %> </h3>
        <p> <%=request.getAttribute("error")%> </p>
    </div>
</body>
</html>