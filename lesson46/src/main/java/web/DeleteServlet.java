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
 * Created by unike on 25.05.2017.
 */

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();

        List<User> userList = userDAO.read();
        User user = null;
        System.out.println(req.getQueryString());
        for (User u : userList){
            if (u.getId() == Long.parseLong(req.getQueryString())){
                user = u;
            }
        }
        userDAO.delete(user);
        resp.sendRedirect("/");
    }
}
