package web;

import com.google.gson.Gson;
import dao.UserDAO;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by unike on 18.05.2017.
 */

@WebServlet("/search")
public class SearchServlet extends HttpServlet {



    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();


        resp.setHeader("Access-Control-Allow-Origin","*");

        String query = req.getParameter("query");
        String[] split = query.split(",");
        String queryLogin = split[0].trim();
        String queryPhone = split[1].trim();
        System.out.println("queryLogin: "+queryLogin);
        System.out.println("queryPhone: "+queryPhone);


        List<User> userList = userDAO.read();

        resp.setContentType("application/json");

        PrintWriter out = resp.getWriter();
        Gson gson = new Gson();

        gson.toJson(filterListByQuery(userList, queryLogin, queryPhone), out);

    }

    private List<User> filterListByQuery(List<User> userList, String queryLogin, String queryPhone) {
        List<User> result = new ArrayList<>();
        for (User u : userList){
            if (u.getLogin().contains(queryLogin)) {
                if (u.getPhone().contains(queryPhone)) result.add(u);
            }
            /*if (u.getLogin().contains(queryLogin)) {
                result.add(u);
            }*/
        }
        return result;
    }


}
