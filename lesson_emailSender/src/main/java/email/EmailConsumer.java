package email;

import com.sun.xml.internal.ws.resources.SenderMessages;

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
            while ((message = queue.poll()) != null){
                Sender.INSTANCE.send(message.getClientEmail(),message.getMessageText(),message.getSubject());
            }
        });
    }
}
