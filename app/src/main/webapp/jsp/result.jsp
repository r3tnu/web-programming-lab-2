<%@ page import="me.r3tnu.lab2.point.Point" %>
<%@ page import="java.time.*" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% Point point = (Point) request.getAttribute("point"); %>
<% Instant start = (Instant) request.getAttribute("start"); %>
<% Instant end = (Instant) request.getAttribute("end"); %>

<tr>
    <td> <%= point.getX() %> </td>
    <td> <%= point.getY() %> </td>
    <td> <%= point.getR() %> </td>
    <td> <%= request.getAttribute("result") %> </td>
    <td> <%= Duration.between(start, end).getNano() %> </td>
</tr>