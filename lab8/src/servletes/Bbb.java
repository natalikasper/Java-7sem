package servletes;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class Bbb extends HttpServlet implements Servlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String result = "";
    Enumeration headers = req.getHeaderNames();
    Enumeration params = req.getParameterNames();

    while (headers.hasMoreElements()) {
      String headerName = (String) headers.nextElement();
      if (headerName.contains("x"))
        result += "\n" + headerName + ": " + req.getHeader(headerName);
    }
    result += "\n";

    while (params.hasMoreElements()) {
      String paramName = (String) params.nextElement();
      result += "\n" + paramName + ": " + req.getParameter(paramName);
    }

    resp.addHeader("X-Bbb1", "15");
    resp.addHeader("X-Bbb2", "1478");

    PrintWriter printWriter = resp.getWriter();
    printWriter.println(result);
  }
}
