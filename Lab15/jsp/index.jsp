<%@ page import="lab15.EmailAdmin" %>
<%@ page import="javax.mail.MessagingException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Messages</title>
  </head>
  <body>
<%
  try {
    out.println(
     EmailAdmin.showMessages(application.getInitParameter("UserEmail"),
            application.getInitParameter("UserPassword")));
  } catch (MessagingException e) {
    e.printStackTrace();
  }
%>
  <a href="message-form.html">Message</a>
  </body>
</html>
