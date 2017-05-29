package web;

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
@WebServlet("/")
public class HomeServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userRole = (String) session.getAttribute("role");
        req.setAttribute("userRole", userRole);
        req.getRequestDispatcher("home.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userRole = (String) session.getAttribute("role");
        boolean userAccess = (boolean) session.getAttribute("access");
        Long userId = (Long) session.getAttribute("userId");
        resp.sendRedirect("/login");

        resp.sendRedirect("/register");

        resp.sendRedirect("/search");
    }
}
