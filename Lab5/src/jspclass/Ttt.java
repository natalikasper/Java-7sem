package jspclass;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Ttt extends HttpServlet implements Servlet {
  public Ttt() {
    super();
  }

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init();
  }

  @Override
  public void destroy() {
    super.destroy();
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PrintWriter printWriter = resp.getWriter();
    printWriter.println(req.getParameter("surname")
      + " " + req.getParameter("lastname")
      + " " + req.getParameter("sex"));
  }
}
