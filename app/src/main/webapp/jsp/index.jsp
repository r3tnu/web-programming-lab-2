<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Area Checker</title>
    <meta name="viewport" content="width=device-width initial-scale=1.0">
    <link rel="stylesheet" href="resources/css/bootstrap.min.css" >
</head>
<body>
    <div class="sticky-top">
        Бритов Сергей Олегович, гр. P3216 
    </div>
    <div class="container">
        <section class="header">
            <h1>Lab 1 Web</h1>
        </section>
        <section class="form">
            <div class="row">
                <div class="col">
                    <%@include file="components/form.jsp" %>
                </div>
                <div class="col mp-auto">
                    <canvas id="canvas" class="canvas mx-auto" width="300px" height="300px"></canvas>
                </div>
            </div>
        </section>
        <section class="results">
            <%@include file="components/results.jsp" %>
        </section>
    </div>
    <script type="text/javascript" src="resources/js/jQuery.js"> </script>
    <script type="text/javascript" src="resources/js/main.js"> </script>
</body>
</html>