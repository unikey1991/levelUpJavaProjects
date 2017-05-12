package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by java on 12.05.2017.
 */
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req);
        String login = req.getParameter("login");
        String password = req.getParameter("password");

//        PrintWriter writer = resp.getWriter();
//        writer.println(String.format("Hello, %s! Your password length is:%d", login, password.length()));


        req.setAttribute("userName", login);
        if (login.equals("Alex")) {
            req.setAttribute("balance", "10000000000$");
        } else req.setAttribute("balance", "-5$");
        req.getRequestDispatcher("userPage.jsp").forward(req,resp);

    }
}
