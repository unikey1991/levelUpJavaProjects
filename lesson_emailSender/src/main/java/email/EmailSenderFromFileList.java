package email;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by unike on 23.04.2017.
 */
public class EmailSenderFromFileList {

    private RandomAccessFile file;
    private List<EmailMessage> messages = new ArrayList<>();


    public EmailSenderFromFileList(String fileName) throws IOException {
        file = new RandomAccessFile(fileName, "r");
        readFromFile(file);
    }

    private EmailMessage parseEmailMessage(String line) {
        String str[] = line.split(";");
        return new EmailMessage(str[0], str[1], str[2]);
    }

    private void readFromFile(RandomAccessFile file) throws IOException {
        file.seek(0);
        String str;
        while ((str = file.readLine()) != null) {
            messages.add(parseEmailMessage(str));
        }
    }

    public void startSender() throws InterruptedException {
        ArrayBlockingQueue<EmailMessage> queue = new ArrayBlockingQueue<>(messages.size());
        new Thread(() -> {
            for (EmailMessage message : messages) {
                queue.offer(message);
            }
        }).start();

        EmailConsumer consumer1 = new EmailConsumer(queue);
        EmailConsumer consumer2 = new EmailConsumer(queue);
        EmailConsumer consumer3 = new EmailConsumer(queue);

        consumer1.start();
        consumer2.start();
        consumer3.start();

        Thread.sleep(30000);
    }
}
