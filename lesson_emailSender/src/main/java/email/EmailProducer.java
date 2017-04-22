package email;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by java on 21.04.2017.
 */
public class EmailProducer {

    private final ArrayBlockingQueue<EmailMessage> queue;

    public EmailProducer(ArrayBlockingQueue<EmailMessage> queue) {
        this.queue = queue;
    }

    public void start() {
        new Thread(() -> {

            List<EmailMessage> messageList = Arrays.asList(
                    new EmailMessage("user1@yopmail.com", "test message", "test message"),
                    new EmailMessage("user2@yopmail.com", "test message", "test message"),
                    new EmailMessage("user3@yopmail.com", "test message", "test message"),
                    new EmailMessage("user4@yopmail.com", "test message", "test message"),
                    new EmailMessage("user5@yopmail.com", "test message", "test message"),
                    new EmailMessage("user6@yopmail.com", "test message", "test message"),
                    new EmailMessage("user7@yopmail.com", "test message", "test message"),
                    new EmailMessage("user8@yopmail.com", "test message", "test message")
            );

            for (EmailMessage m : messageList) {
                queue.offer(m);
            }

        }).start();
    }


}
