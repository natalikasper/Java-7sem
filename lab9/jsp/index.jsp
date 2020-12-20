<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.ServletContext" %>
<html>
<head>
    <title>
        Lab9
    </title>
</head>
<body>

<form method="post" action="/Lab9/Ccc">
    <input type="text" name="value1" placeholder="value1"/><br>
    <input type="text" name="value2" placeholder="value2"/><br>
    <input type="text" name="value3" placeholder="value3"/><br>
    <input type="text" name="cbean" placeholder="cbean"/><br>
    <button>Post on the Ccc</button>
</form>

<form method="get" action="/Lab9/Ccc">
    <input type="text" name="value1" placeholder="value1"/><br>
    <input type="text" name="value2" placeholder="value2"/><br>
    <input type="text" name="value3" placeholder="value3"/><br>
    <input type="text" name="cbean" placeholder="cbean"/><br>
    <button>Get on the Ccc</button>
</form>

<h4>Write /Lab9/ccc.jsp?value2=someValue for task2</h4>
</body>
</html>
