package lab7;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class Ccc extends HttpServlet implements Servlet {
  @Override
  public void init() throws ServletException {
    super.init();  
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    getResult(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    getResult(req, resp);
  }

  private void getResult(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();
    String sessionId = session.getId();
    CBean cbeanSession = (CBean) session.getAttribute(sessionId);
    CBean objForSession = new CBean();
    CBean objForRequest = new CBean();
    String value1 = req.getParameter("value1");
    System.out.println(value1);
    String value2 = req.getParameter("value2");
    System.out.println(value2);
    String value3 = req.getParameter("value3");
    System.out.println(value3);
    String cbean = req.getParameter("cbean");

    if (cbeanSession != null) {
      objForSession = cbeanSession;
    } 
    else {
      session.setAttribute(sessionId, objForSession);
      session.setMaxInactiveInterval(100);
    }

    if (cbean != null && cbean.equals("new")) {
      req.setAttribute("atrCBean", new CBean());
      session.removeAttribute(sessionId);
      session.setAttribute(sessionId, new CBean());
    }

    setValues(objForSession, objForRequest, value1, value2, value3);

    session.setAttribute(sessionId, objForSession);
    req.setAttribute("atrCBean", objForRequest);

    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/ccc.jsp");
    requestDispatcher.forward(req, resp);
  }

  private void setValues(CBean objForSession, CBean objForRequest, String value1, String value2, String value3) {
    if (value1 != "") {
      objForSession.setValue1(value1);
      objForRequest.setValue1(value1);
    }

    if (value2 != "") {
      objForSession.setValue2(value2);
      objForRequest.setValue2(value2);
    }

    if (value3 != "") {
      objForSession.setValue3(value3);
      objForRequest.setValue3(value3);
    }
  }
}
