package jspclass;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class LastName extends TagSupport {
  String lastnameContent = "<label>Lastname</label>"
    + " <input name='lastname' type='text' width='150'"
    + " maxlength='30' ";
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
      out.print(lastnameContent + (this.value.equals("") ? "" : "value='" + this.value + "' />"));
    } catch (IOException e) {
      System.out.println("lastname: " + e);
    }
    return SKIP_BODY;
  }
}
