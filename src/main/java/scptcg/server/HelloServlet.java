package scptcg.server;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "HelloServlet",
        urlPatterns = {"/Hello"})
public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out;

        res.setContentType("text/html; charset=Shift_JIS");
        out = res.getWriter();

        System.out.println("Hello");

        out.println("<html><body>");
        out.println("<h1>Hello World!</h1>");
        out.println("<p>Servletのサンプル（HelloServlet.java）</p>");
        out.println("</body></html>");
    }
}
