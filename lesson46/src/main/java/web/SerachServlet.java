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

@WebServlet("/search")
public class SerachServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //UserDAO userDAO = new UserDAO();


        req.getRequestDispatcher("search.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();

        String login = req.getParameter("login");
        String phone = req.getParameter("phone");
        List<User> userList = userDAO.getUsersListByLoginAndPhone(login, phone);


        if (req.getParameter("deleteId") != null){
            long id = Long.parseLong(req.getParameter("deleteId"));
            User user = userDAO.getUserById(id);
            userDAO.delete(user);
        }
        if (req.getParameter("updateId") != null){

            long id = Long.parseLong(req.getParameter("updateId"));
            User user = userDAO.getUserById(id);
            req.setAttribute("login", user.getLogin());
            req.setAttribute("name", user.getName());
            req.setAttribute("lastName", user.getLastName());
            req.setAttribute("phone", user.getPhone());
            req.setAttribute("email", user.getEmail());
            req.setAttribute("userId", user.getId());
            req.getRequestDispatcher("userUpdate.jsp").forward(req,resp);


        }

        if (req.getParameter("update") != null){
            long id = Long.parseLong(req.getParameter("userId"));
            User user = userDAO.getUserById(id);
            user.setLogin(req.getParameter("login"));
            user.setName(req.getParameter("name"));
            user.setLastName(req.getParameter("lastName"));
            user.setPhone(req.getParameter("phone"));
            user.setEmail(req.getParameter("email"));
            userDAO.update(user);
        }


        req.setAttribute("searchResultList", userList);
        req.getRequestDispatcher("search.jsp").forward(req,resp);
    }



}
