package lab6;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Ccc extends HttpServlet implements Servlet {
  @Override
  public void init() throws ServletException {
    super.init();
    getServletContext().setAttribute("atrCBean", new CBean());
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/ccc.jsp");
    requestDispatcher.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    getResult(req, resp);
  }

  private void getResult(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String value1 = req.getParameter("value1");
    String value2 = req.getParameter("value2");
    String value3 = req.getParameter("value3");
    String cbean = req.getParameter("cbean");

      //указание сервлету создать объект класса CBean
      //и записать ссылку на него в атр контекста atrCBean
    if (cbean != null && cbean.equals("new")) {
      System.out.println("new CBean");
      getServletContext().setAttribute("atrCBean", new CBean());
    }
    else System.out.println("old CBean");

    setValues(value1, value2, value3);

    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/ccc.jsp");
    requestDispatcher.forward(req, resp);
  }

  private void setValues(String value1, String value2, String value3) {
    CBean ob = (CBean) getServletContext().getAttribute("atrCBean");

    if (value1 != "") {
      ob.setValue1(value1);
    }

    if (value2 != "") {
      ob.setValue2(value2);
    }

    if (value3 != "") {
      ob.setValue3(value3);
    }
  }
}
