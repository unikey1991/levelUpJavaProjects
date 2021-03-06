package web;

import dao.UserDAO;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by unike on 13.05.2017.
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);
        UserDAO userDAO = new UserDAO();

        System.out.println(req);
        String login = req.getParameter("login");
        String password = req.getParameter("password");



        User user = userDAO.getUserByLoginAndPassword(login, password);

        if (null != user) {
            req.setAttribute("userId", user.getId());
            req.setAttribute("name", user.getName());
            req.setAttribute("lastName", user.getLastName());
            if (user.isAllowAccess()) {
                session.setAttribute("userId", user.getId());
                session.setAttribute("access", user.getId());
                session.setAttribute("role", user.getRole().name());
                System.out.println(user.getRole().name());
                req.getRequestDispatcher("userPage.jsp").forward(req, resp);
            }
            else {

                req.getRequestDispatcher("emailConfirm.jsp").forward(req, resp);
            }

        } else {


            doGet(req,resp);
        }
    }
}
