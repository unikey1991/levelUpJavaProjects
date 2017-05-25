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
 * Created by unike on 18.05.2017.
 */
@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet{

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

        req.setAttribute("name", user.getName());
        req.setAttribute("lastName", user.getLastName());
        req.setAttribute("phone", user.getPhone());
        req.setAttribute("email", user.getEmail());
        req.setAttribute("userId", user.getId());
        req.getRequestDispatcher("userUpdate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDAO userDAO = new UserDAO();

        List<User> userList = userDAO.read();
        User user = null;
        System.out.println(req.getParameter("userId"));
        for (User u : userList){
            if (u.getId() == Long.parseLong(req.getParameter("userId"))){
                user = u;
            }
        }


        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        System.out.println(email);


        user.setName(name);
        user.setLastName(lastName);
        user.setPhone(phone);
        user.setEmail(email);
        userDAO.update(user);

        resp.sendRedirect("/");
    }
}
