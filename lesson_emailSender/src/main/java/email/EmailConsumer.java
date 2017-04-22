package email;

import com.sun.xml.internal.ws.resources.SenderMessages;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by java on 21.04.2017.
 */
public class EmailConsumer {

    private final ArrayBlockingQueue<EmailMessage> queue;

    public EmailConsumer(ArrayBlockingQueue<EmailMessage> queue) {
        this.queue = queue;
    }

    public void start() {
        new Thread(() -> {
            EmailMessage message = null;
            while ((message = queue.poll()) != null) {
                System.out.println(new Date() + ": " + Thread.currentThread().getName() + " Send message to: " + message.getClientEmail());
                Sender.INSTANCE.send(message.getSubject(), message.getMessageText(), message.getClientEmail());
            }

        }).start();
    }
}
