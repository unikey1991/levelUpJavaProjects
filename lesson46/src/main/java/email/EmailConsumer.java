package email;


import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by java on 21.04.2017.
 */
public class EmailConsumer extends Thread {

    private final ArrayBlockingQueue<EmailMessage> queue;

    public EmailConsumer(ArrayBlockingQueue<EmailMessage> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        EmailMessage message = null;
        while (true) {
            while ((message = queue.poll()) != null) {
                System.out.println(new Date() + ": " + Thread.currentThread().getName() + " Send message to: " + message.getClientEmail());
                Sender.INSTANCE.send(message.getSubject(), message.getMessageText(), message.getClientEmail());
            }
        }
    }
}
