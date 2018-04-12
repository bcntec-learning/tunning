package houseware.learn.tunning.wildfly;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Stateful")
public class StatefulServlet extends HttpServlet {

    @EJB
    StatefulEJB statefulEJB;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        statefulEJB.sayHello(req.getParameter("name"));
    }
}
