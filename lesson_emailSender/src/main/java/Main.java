import email.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by java on 21.04.2017.
 */
public class Main {

    //private static email.Sender Sender = new Sender("levelup.java.16.6@gmail.com", "JavaLevelUp166");


    public static void main(String[] args) throws InterruptedException, IOException {



//        Sender.INSTANCE.send("test","Dimon herok","dp190792kdg@gmail.com");


        /*ArrayBlockingQueue<EmailMessage> queue = new ArrayBlockingQueue<>(10);
        EmailProducer producer = new EmailProducer(queue);

        EmailConsumer consumer1 = new EmailConsumer(queue);
        EmailConsumer consumer2 = new EmailConsumer(queue);
        EmailConsumer consumer3 = new EmailConsumer(queue);

        producer.start();

        consumer1.start();
        consumer2.start();
        consumer3.start();

        Thread.sleep(30000);*/

        ///////////
        EmailSenderFromFileList senderFromFileList = new EmailSenderFromFileList("list.txt");
        senderFromFileList.startSender();


        ///////////
        ArrayBlockingQueue<EmailMessage> queue = new ArrayBlockingQueue<>(10);

        EmailProducer producer = new EmailProducer(queue);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new EmailConsumer(queue));
        executorService.execute(new EmailConsumer(queue));
        executorService.execute(new EmailConsumer(queue));

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
        producer.sendMessage(messageList);

        executorService.shutdown();
    }
}
