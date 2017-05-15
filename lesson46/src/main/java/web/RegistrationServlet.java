package web;

import dao.UserDAO;
import entity.User;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by unike on 13.05.2017.
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(req);
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");


        UserDAO userDAO = new UserDAO();
        if (login.equals("") || password.equals("") || name.equals("") || lastName.equals("")) {
            doGet(req,resp);
        } else {
            req.setAttribute("name", name);
            req.setAttribute("lastName", lastName);
            User user = new User(login, password, name, lastName);
            System.out.println(user.toString());

            userDAO.addUser(user);


            req.getRequestDispatcher("userPage.jsp").forward(req, resp);
        }
    }
}
