package web;

import dao.UserDAO;
import email.EmailConsumer;
import email.EmailMessage;
import email.EmailProducer;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by unike on 29.05.2017.
 */

@WebServlet("/sendEmail")
public class SendEmailServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();

        Long id = Long.parseLong(req.getParameter("userId"));
        System.out.println(id);
        User user = userDAO.getUserById(id);

        String email = user.getEmail();
        System.out.println(email);
        String urlForConfirm = "http://localhost:8080/verification?"+user.getVerificationKey();
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
    }
}
