package jspclass;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Surname extends TagSupport {
  String surnameContent = "<label>Surname</label>"
    + " <input name='surname' type='text' width='150'"
    + " maxlength='30'";

  public String value = "";

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public int doStartTag() throws JspException {
    JspWriter out = pageContext.getOut();
    try {
      out.print(surnameContent + (this.value.equals("") ? "" : "value= '" + this.value + "' />"));
    } catch (IOException e) {
      System.out.println("Surname" + e);
    }
    return SKIP_BODY;
  }
}
