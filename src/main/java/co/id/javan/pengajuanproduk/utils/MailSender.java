package co.id.javan.pengajuanproduk.utils;

import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@Component
public class MailSender {

    public void sendmail(String to, String subject, String msgContent, String bodyContent) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("teston735@gmail.com", "CASSANOVA-7");
                }
            });
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("teston735@gmail.com", false));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            msg.setSubject(subject);
            msg.setContent(msgContent, "text/html");
            msg.setSentDate(new Date());
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(bodyContent, "text/html");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            msg.setContent(multipart);
            Transport.send(msg);
            System.out.println("Email berhasil dikirim");
        } catch (MessagingException e) {
            System.out.println("Email gagal dikirim");
        }
    }

}
