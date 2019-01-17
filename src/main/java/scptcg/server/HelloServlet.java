package scptcg.server;

import scptcg.log.Log4j;
import scptcg.log.Logger;

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

        out.println("<html><body>");
        out.println("<h1>Hello World!</h1>");
        out.println("<p>Servletのサンプル（HelloServlet.java）</p>");
        out.println("</body></html>");
        Logger logger = Log4j.getInstance();
        logger.info("Hello, World!");
    }
}
