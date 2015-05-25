package by.qd64.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

@Service
public class EmailManager {

    private Logger logger = Logger.getLogger(getClass());

    @Autowired
    private SettingManager settingManager;

    private Session session = null;

    public void send(String email, String subject, String html) {
        try {
            logger.info("start");
            Message message = new MimeMessage(getSession());
            message.setFrom(new InternetAddress(settingManager.getSender()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject(subject);
            
            message.setContent(html, "text/html; charset=utf-8");
            Transport.send(message);
        } catch (Exception e) {
            logger.info("Failed email to : " + email);
            logger.info(e);
        }
    }


    public void send(List<String> emails, String subject, String html) {
        try {
            logger.info("start");
            Message message = new MimeMessage(getSession());
            message.setFrom(new InternetAddress(settingManager.getSender()));
            for(String email: emails) {
                message.addRecipient(Message.RecipientType.BCC, InternetAddress.parse(email)[0]);
            }
            message.setSubject(subject);
            message.setContent(html, "text/html; charset=utf-8");
            Transport.send(message);
        } catch (Exception e) {
            logger.info(e);
        }
    }

    private Session getSession() {
        if (session == null) {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", settingManager.getMailServer());
            props.put("mail.smtp.port", settingManager.getMailPort());
            session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(settingManager.getMailLogin(),
                            settingManager.getMailPassword());
                }
            });
            session.setDebug(true);
            return session;
        } else {
            return session;
        }
    }
}
