import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
@WebServlet(name = "Ggg", urlPatterns = "/Ggg")
public class Ggg extends HttpServlet {
    private ServletConfig configServ;
    public Ggg() {
        super();
        System.out.println("Ggg:constructor");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.configServ=config;
        configServ.getServletContext().log("Ggg:init");
    }

    @Override
    public void destroy() {
        super.destroy();
        configServ.getServletContext().log("Ggg:destroy");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        resp.setContentType("text/html;charset=utf-8");
        configServ.getServletContext().log("Ggg:service");

        PrintWriter printWriter = resp.getWriter();
        String param = req.getParameter("param2");
        String _click = req.getParameter("click");

        if (_click.equalsIgnoreCase("value4")) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("redirect.html");
            requestDispatcher.forward(req, resp);
        }

        if (_click.equalsIgnoreCase("example")) {
            String p1 = req.getParameter("p1");
            String p2 = req.getParameter("p2");

            printWriter.println("<h4>p1: " + p1 + "</h4><br/><h4>p2: " + p2 + "</h4>");
        }

        if (_click.equalsIgnoreCase("value5")) {
            String param5 = req.getParameter("param5");

            printWriter.println("<br/><h4>Parameter: " + param5 + "</h4>");
        }
        if(param.equalsIgnoreCase("testvalue2"))
        {
            resp.sendRedirect("redirect.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        configServ.getServletContext().log("Ggg:doGet");

        PrintWriter printWriter = resp.getWriter();
        printWriter.println("Servlet Ggg");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        configServ.getServletContext().log("Ggg:doPost");
    }
}
