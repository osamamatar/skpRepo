package com.osama.skp.utilityClasses;


import com.osama.skp.utilityClasses.Notifier;
import com.osama.skp.utilityClasses.dto.MessageRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;


@Component
@Primary
public class MailSender implements Notifier {

    @Value("${mail.mail}")
    private String senderMail;
    @Value("${mail.password}")
    private String pass;

    @Override
   public void send(MessageRequest messageRequest) throws AddressException, MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderMail, pass);
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(senderMail, false));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(messageRequest.getDestination()));
        msg.setSubject(messageRequest.getSubject());
        msg.setContent(messageRequest.getMessage(), "text/html");
        msg.setSentDate(new Date());
        Transport.send(msg);
    }
}
