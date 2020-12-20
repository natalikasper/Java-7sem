import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Sss", urlPatterns = "/Sss")
public class Sss extends HttpServlet {
    private ServletConfig configServ;
    public Sss() {
        super();
        System.out.println("Sss:constructor");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.configServ=config;
        configServ.getServletContext().log("Sss:init");
    }

    @Override
    public void destroy() {
        super.destroy();
        configServ.getServletContext().log("Sss:destroy");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        configServ.getServletContext().log("Sss:service");
        RequestDispatcher requestDispatcher = null;

        String _click = req.getParameter("click");

        PrintWriter printWriter = resp.getWriter();


        if (_click == null) {  
            printWriter.println("Sss:doGet");
        } else {

            if (_click.equalsIgnoreCase("value")) { 
                resp.sendRedirect("http://172.16.193.69:8080/Lab3_K/Ggg");
            }

            if (_click.equalsIgnoreCase("value1")) {  
                printWriter.println("Sss:POST in service");
            }

            if (_click.equalsIgnoreCase("value2")) {
                resp.sendRedirect("http://172.16.193.69:8080/Lab3_K/Ggg?param2=testvalue");
                printWriter.println("<br/>POST Sss -> Ggg");
            }

            if (_click.equalsIgnoreCase("value3")) {
                resp.sendRedirect("redirect.html");
            }

            if (_click.equalsIgnoreCase("value4")) {
                requestDispatcher = req.getRequestDispatcher("http://172.16.193.69:8080/Lab3_K/Ggg");
                requestDispatcher.forward(req, resp);
            }

            if(_click.equalsIgnoreCase("value5")){
                requestDispatcher = req.getRequestDispatcher("http://172.16.193.69:8080/Lab3_K/Ggg");
                requestDispatcher.forward(req, resp);
            }

            if(_click.equalsIgnoreCase("value6")) {
                HttpClient hc = new HttpClient();
                GetMethod gm = new GetMethod("http://172.16.193.69:8080/Lab3_K/Ggg?click=example&p1=Kasper&p2=Natasha");

                hc.executeMethod(gm);
                resp.setContentType("text/html");
                PrintWriter pw = resp.getWriter();
                pw.println(gm.getResponseBodyAsString());
                pw.flush();
            }

            if (_click.equalsIgnoreCase("value7")) {
                RequestDispatcher requestDispatcher2 = req.getRequestDispatcher("redirect.html");
                requestDispatcher2.forward(req, resp);
            }

            if (_click.equalsIgnoreCase("value8")) {
                resp.sendRedirect("http://172.16.193.69:8080/Lab3_K/Ggg?param2=testvalue2");
            }

            if(_click.equalsIgnoreCase("value9")) {
                HttpClient hc2 = new HttpClient();
                PostMethod gm2 = new PostMethod("http://172.16.193.69:8080/Lab3_K/Ggg");
                gm2.addParameter("click","example");
                gm2.addParameter("p1","Kasper");
                gm2.addParameter("p2","Natasha");
                hc2.executeMethod(gm2);
                resp.setContentType("text/html");
                PrintWriter pw = resp.getWriter();
                pw.println(gm2.getResponseBodyAsString());
                pw.flush();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        configServ.getServletContext().log("Sss:doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        configServ.getServletContext().log("Sss:doPost");


    }
}