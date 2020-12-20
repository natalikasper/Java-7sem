package lab11;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Sss_Json extends HttpServlet implements Servlet {
  @Override
  public void init() throws ServletException {
    super.init();
    System.out.println("Sss_Json:init");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("Sss_Json:get");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Random random = new Random();
            Integer n = Integer.parseInt(request.getHeader("XRand-N"));
            StringBuilder textResult = new StringBuilder();
            Integer count = random.nextInt(6) + 5;

            textResult.append("[");
            for (Integer i = 0; i < count; i++) {
                Integer number = random.nextInt(n*2) - n;
                textResult.append(number).append(i < count -1 ? "," : "");
            }
            textResult.append("]");

            Thread.sleep(1000);

            response.setContentType("application/json");
            response.getWriter().println(textResult);

        } catch (Exception e) {
            response.getWriter().println(e.getMessage());
        }
    }
}
