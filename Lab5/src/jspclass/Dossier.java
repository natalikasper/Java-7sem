package jspclass;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Dossier extends TagSupport {
  public String action = "";

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  @Override
  public int doStartTag() throws JspException {
    String in = "<form id='aboutMyself' name='aboutMyself' method='post' action='" + this.action + "'>";
    JspWriter out = pageContext.getOut();
    try {
      out.print(in);
    } catch (IOException e) {
      System.out.println("Dossier: " + e);
    }
    return EVAL_BODY_INCLUDE;
  }

  @Override
  public int doEndTag() throws JspException {
    String in = "</form>";
    JspWriter out = pageContext.getOut();
    try {
      out.print(in);
    } catch (IOException e) {
      System.out.println("Dossier:" + e);
    }
    return EVAL_BODY_INCLUDE;
  }
}
