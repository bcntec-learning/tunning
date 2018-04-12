package houseware.learn.tunning.wildfly;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Stateful")
public class StatelesslServlet extends HttpServlet {

    @EJB
    StatelessEJB statelessEJB;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        statelessEJB.sayHello(req.getParameter("name"));
    }
}
