<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.ServletContext" %>
<%@ page import="lab6.CBean" %>
<html>
<head>
    <title>
    </title>
</head>
<body>
<%
    CBean ob = (CBean) pageContext.getServletContext().getAttribute("atrCBean");
%>
<%=ob.getValue1()%>
<%=ob.getValue2()%>
<%=ob.getValue3()%>
</body>
</html>