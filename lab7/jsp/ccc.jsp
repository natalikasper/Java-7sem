<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.ServletContext" %>
<%@ page import="lab7.CBean" %>
<html>
<head>
    <title>
    </title>
</head>
<body>
<%
    CBean objFromReq = (CBean) request.getAttribute("atrCBean");
    CBean objFromSess = (CBean) request.getSession().getAttribute(request.getSession().getId());
%>
<h2>Values from attribute of request</h2>

<div>
    <label><%=objFromReq.getValue1()%>
    </label>
    <label><%=objFromReq.getValue2()%>
    </label>
    <label><%=objFromReq.getValue3()%>
    </label>
</div>

<h2>Values from attribute of session</h2>

<div>
    <label><%=objFromSess.getValue1()%>
    </label>
    <label><%=objFromSess.getValue2()%>
    </label>
    <label><%=objFromSess.getValue3()%>
    </label>
</div>
</body>
</html>