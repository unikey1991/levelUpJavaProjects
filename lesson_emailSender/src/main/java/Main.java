import email.EmailConsumer;
import email.EmailMessage;
import email.EmailProducer;
import email.Sender;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by java on 21.04.2017.
 */
public class Main {

    //private static email.Sender Sender = new Sender("levelup.java.16.6@gmail.com", "JavaLevelUp166");


    public static void main(String[] args) throws InterruptedException {



        //Sender.send("test","Dimon herok","dp190792kdg@gmail.com");


        ArrayBlockingQueue<EmailMessage> queue = new ArrayBlockingQueue<>(10);
        EmailProducer producer = new EmailProducer(queue);

        EmailConsumer consumer1 = new EmailConsumer(queue);
        EmailConsumer consumer2 = new EmailConsumer(queue);
        EmailConsumer consumer3 = new EmailConsumer(queue);

        producer.start();

        consumer1.start();
        consumer2.start();
        consumer3.start();

        Thread.sleep(30000);
    }
}
