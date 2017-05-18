package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by unike on 18.05.2017.
 */
public class UpdateUserServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("userUpdate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");



    }
}
