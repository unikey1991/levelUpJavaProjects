package email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by java on 21.04.2017.
 */
public enum Sender {


    INSTANCE;

    /*private String username;
    private String password;
    private Properties props;
*/
    //singletone - это зло! не юзать!
//    private volatile static Sender instance;
//
//    private Sender(){
//    }
//
//    public static  Sender getInstance(){
//        if (null != instance) return  instance;
//
//        synchronized (Sender.class) {
//            if (null == instance) {
//                instance = new Sender();
//            }
//        }
//        return instance;
//    }


    /*public Sender(String username, String password) {
        this.username = username;
        this.password = password;

        props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
    }*/

    private volatile Lock lock = new ReentrantLock();

    public void send(String subject, String text, String toEmail){
        lock.lock();
        final String password = "JavaLevelUp166";
        String username = "levelup.java.16.6@gmail.com";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });



        try {
            Message message = new MimeMessage(session);
            //ot kogo
            message.setFrom(new InternetAddress(username));
            //komy
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            //zagolovok pisma
            message.setSubject(subject);
            //soderjimoe
            message.setText(text);

            //otpravlaem soobwenie
            Transport.send(message);
            System.out.println(new Date() + "Sent message successfully");


            Thread.sleep(3000);
        } catch (InterruptedException | MessagingException e) {
            e.printStackTrace();
        }

        lock.unlock();
    }
}
