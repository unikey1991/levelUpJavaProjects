package web;

import dao.UserDAO;
import email.EmailConsumer;
import email.EmailMessage;
import email.EmailProducer;
import entity.Role;
import entity.User;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


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
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");



        UserDAO userDAO = new UserDAO();
        if (login.equals("") || password.equals("") || name.equals("") || lastName.equals("")) {
            doGet(req,resp);
        } else {
            req.setAttribute("name", name);
            req.setAttribute("lastName", lastName);

            Date date = new Date();
            char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
            StringBuilder verificationKey = new StringBuilder();
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                char c = chars[random.nextInt(chars.length)];
                verificationKey.append(c);
            }
            //verificationKey.append(date.toString());

            String urlForConfirm = "http://localhost:8080/verification?"+verificationKey.toString();
            User user = new User(login, password, name, lastName, phone,email, verificationKey.toString(), Role.USER); //todo роль пока юзер для всех при реге
            System.out.println(user.toString());

            userDAO.addUser(user);


            System.out.println(email);
            String messageText = "Для подтверждения регистрации просим перейти по укзанному адресу: \n\r" + urlForConfirm;
            EmailMessage emailMessage = new EmailMessage(email,messageText, "Confirm registration");
            List<EmailMessage> list = new ArrayList<>();
            list.add(emailMessage);
            ArrayBlockingQueue<EmailMessage> queue = new ArrayBlockingQueue<>(10);
            EmailProducer emailProducer = new EmailProducer(queue);
            ExecutorService executorService = Executors.newFixedThreadPool(3);
            executorService.execute(new EmailConsumer(queue));
            executorService.execute(new EmailConsumer(queue));
            executorService.execute(new EmailConsumer(queue));
            emailProducer.sendMessage(list);


            req.getRequestDispatcher("userPage.jsp").forward(req, resp);
        }
    }
}
