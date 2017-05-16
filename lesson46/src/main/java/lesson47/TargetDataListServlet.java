package lesson47;

import lesson47.dto.TargetData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by java on 16.05.2017.
 */

@WebServlet("/targetData")
public class TargetDataListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TargetData> list = Arrays.asList(
                new TargetData("user1@yopmail.com", "user1"),
                new TargetData("user2@yopmail.com", "user2"),
                new TargetData("user3@yopmail.com", "user3"),
                new TargetData("user4@yopmail.com", "user4"),
                new TargetData("user5@yopmail.com", "user5"),
                new TargetData("user6@yopmail.com", "user6"),
                new TargetData("user7@yopmail.com", "user7"),
                new TargetData("user8@yopmail.com", "user8"),
                new TargetData("user9@yopmail.com", "user9"),
                new TargetData("user10@yopmail.com", "user10"),
                new TargetData("user11@yopmail.com", "user11")
        );

        req.setAttribute("targetDataList", list);

        req.getRequestDispatcher("targetDataList.jsp").forward(req,resp);


    }
}
