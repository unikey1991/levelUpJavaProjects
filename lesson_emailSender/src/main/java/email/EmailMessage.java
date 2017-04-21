package email;

/**
 * Created by java on 21.04.2017.
 */
public class EmailMessage {


    private String clientEmail;
    private String messageText;
    private String subject;

    public EmailMessage(String clientEmail, String messageText, String subject) {
        this.clientEmail = clientEmail;
        this.messageText = messageText;
        this.subject = subject;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getSubject() {
        return subject;
    }
}


