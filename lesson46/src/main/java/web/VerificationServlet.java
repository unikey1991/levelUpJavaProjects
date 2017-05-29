package web;

import dao.UserDAO;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by unike on 28.05.2017.
 */

@WebServlet("/verification")
public class VerificationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        List<User> userList = userDAO.read();

        for (User u: userList){
            if (u.getVerificationKey().equals(req.getQueryString())){
                u.setAllowAccess(true);
                userDAO.update(u);
            }
        }

        resp.sendRedirect("/login");

    }
}
