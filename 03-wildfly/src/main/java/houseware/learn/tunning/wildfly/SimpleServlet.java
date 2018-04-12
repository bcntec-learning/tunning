package houseware.learn.tunning.wildfly;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/Simple")
public class SimpleServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(SimpleServlet.class.toString());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new ServletException(e);
        }
    }
}
