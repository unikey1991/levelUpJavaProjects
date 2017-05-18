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
            userDAO.deleteById(Long.parseLong(req.getParameter("deleteId")));
        }


        req.setAttribute("searchResulList", userList);
        req.getRequestDispatcher("search.jsp").forward(req,resp);



        if (req.getParameter("delete").equals("*")){
            userDAO.deleteById(Long.parseLong(req.getParameter("sr.id")));
        }


    }



}
