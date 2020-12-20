import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sss extends HttpServlet {

    public Sss() {
        System.out.println("Constructor");
    }

    public void init(ServletConfig sc) throws ServletException{
        System.out.println("Hello: init");
    }

    public void destroy(){
        System.out.println("Hello: destroy");
    }

    // service or doGet, doPost only
    protected void service(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        System.out.println("Hello: service: " + rq.getMethod());

        PrintWriter pw = rs.getWriter();
        pw.println("<html><body>"
                + "<h2>Hello: service with method - " + rq.getMethod() + "</h2>"
                + "<h3>ServerName: " + rq.getServerName() + "</h3>"
                + "<h3>LocalAddr: " + rq.getLocalAddr() + "</h3>"
                + "<br>Hello: FirstName = " + rq.getParameter("firstname")
                + "<br>Hello: LastName = " + rq.getParameter("lastname")
                + "</body></html>");
    }

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        rs.setContentType("text/html");
        PrintWriter pw = rs.getWriter();
        pw.println("<html><body>"
                + "<br>hello:doPost:firstname = " + rq.getParameter("firstname")
                + "<br>hello:doPost:lastname = " + rq.getParameter("lastname")
                + "</body></html>");
        pw.close();
    }

    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        rs.setContentType("text/html");
        PrintWriter pw = rs.getWriter();
        pw.println("<html><body>"
                +"<br>Hello: FirstName = " + rq.getParameter("firstname")
                +"<br>Hello: LastName = " + rq.getParameter("lastname")
                +"<br>Hello: getRemoteHost: " + rq.getQueryString()
                +"</body></html>");
        pw.close();
    }
}