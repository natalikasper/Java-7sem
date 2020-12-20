<%@ page import="java.util.Date" pageEncoding="UTF-8" %>
<!%@ page import="org.apache.commons.lang3.time.DateUtils" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ page import="jspclass.Time" %>
<%@ page import="java.util.Calendar" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>First JSP App</title>
        <style type="text/css">
            TABLE {
             border-collapse: collapse;
             border: 4px solid black;
            }
            TD, TH {
             padding: 5px;
             border: 2px solidr red;
            }
        </style>
    </head>
    <body>
        <p>Today <%= new java.util.Date() %></p>
        
        <% int h=(new Date()).getHours();
        if ((h > 1 && h < 7) || h > 23) out.println("<h2>Good night</h2>");
        if (h > 6 && h < 12) out.println("<h2>Good morning</h2>");
        if (h > 11 && h < 17) out.println("<h2>Good afternoon</h2>");
        if (h > 16 && h < 24) out.println("<h2>Good evening</h2>");
        %>

        <%Date dateNow = new Date();%>
        <%SimpleDateFormat yy = new SimpleDateFormat("dd/MM/yyyy"); %>
        <%SimpleDateFormat u = new SimpleDateFormat("u' ('E') '"); %>
        
        <table>
            <% for (int i=0; i < 7; i++) { 
                Date dateNext = new Date(new Date().getTime() + 60*60*24*1000*i);%>
                <tr>
                    <td><% out.print(yy.format(dateNext)); %></td>
                    <td><% out.print(u.format(dateNext)); %></td>
                </tr>   
            <% } %>

            <!%Date dateNext = DateUtils.addDays(dateNow, 1);%> 
            <%Date dateNext = new Date(new Date().getTime() + 60*60*24*1000);%>

        </table>


        <hr>
        <a href="Jjj">GET (Jjj) </a> <br/> <br/>
        <form action="Jjj" method="POST">
          <input type="submit" name="press" value="POST (Jjj)"> 
        </form>


        <hr>
        <%@ include file="afternoon.jsp" %>
        <jsp:include page="afternoon.jsp"></jsp:include>
        <!--%--<jsp:forward page="afternoon.jsp"></jsp:forward>--%-->
        <hr>


        <a href="/Lab4/Afternoon">Afternoon servlet</a>

    </body>
</html>
