<%-- 
    Document   : arithmeticcalculator
    Created on : Sep 22, 2020, 10:59:09 AM
    Author     : 815138
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        
        <form method="post" action="arithmetic">
            First: <input type="text" name="first" value="${first}"><br>
            Second: <input type="text" name="second" value="${second}"><br>
            <input type="submit" value="+" name="add">
            <input type="submit" value="-" name="minus">
            <input type="submit" value="*" name="multiply">
            <input type="submit" value="%" name="divise">
        </form><br>
        Result: ${result} <br>
        <a href="age">Age Calculator</a>
    </body>
</html>
