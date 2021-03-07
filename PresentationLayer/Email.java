package PresentationLayer;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class Email {

    public void sendEmail(String email, Date date) {
        String to = email;
        String from = "DeliciousCatering@gmail.com";
        String host = "localhost";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Delicous catering booking confirmation!");
            message.setText("We have confirmed your event on "+date+". We hope you enjoy it!");
            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

}