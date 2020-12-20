package lab11;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Sss_Header extends HttpServlet implements Servlet {
  @Override
  public void init() throws ServletException {
    super.init();
    System.out.println("Sss_Header:init");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("Sss_Header:get");
  }

	@Override
    	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
		System.out.println("Sss_Header:post");
            Integer x = Integer.parseInt(request.getHeader("Value-x"));
            Integer y = Integer.parseInt(request.getHeader("Value-y"));
            Integer z = x + y;

            Thread.sleep(1000);

            response.setHeader("Value-z", z.toString());
        } catch (Exception e) {
            response.getWriter().println(e.getMessage());
        }
    }
}
