package servletes;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;

import java.io.IOException;
import java.io.PrintWriter;

public class Aaa extends HttpServlet implements Servlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpClient client = new HttpClient();
    String uri = "http://172.16.193.69:8080/Kasper_Lab8/Bbb";
    PostMethod postMethod = new PostMethod(uri);

    postMethod.addRequestHeader("X-Aaa1", "1");
    postMethod.addRequestHeader("X-Aaa2", "2");
    postMethod.addRequestHeader("X-Aaa3", "3");
    postMethod.addParameter("X-Aaa1", "1");
    postMethod.addParameter("X-Aaa2", "2");
    postMethod.addParameter("X-Aaa3", "3");

    client.executeMethod(postMethod);

    PrintWriter printWriter = resp.getWriter();
    printWriter.println(postMethod.getResponseBodyAsString());
    printWriter.println("All Headers: ");

    Header[] headers = postMethod.getResponseHeaders();

    for (Header header : headers)
      printWriter.println(header.getName() + ": " + header.getValue());
  }
}
