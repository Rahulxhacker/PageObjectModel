package utilities;

import java.util.Properties;

import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.*;
import jakarta.mail.internet.*;

public class MonitoringMail {

    public void sendMail(
            String mailServer,
            String from,
            String[] to,
            String subject,
            String messageBody,
            String attachmentPath,
            String attachmentName) {

        Properties props = new Properties();

        // ===== SMTP CONFIG =====
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // TLS
        props.put("mail.smtp.host", mailServer);
        props.put("mail.smtp.port", "587"); // TLS PORT
        props.put("mail.debug", "true");

        Session session = Session.getInstance(props, new SMTPAuthenticator());

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            InternetAddress[] addressTo = new InternetAddress[to.length];
            for (int i = 0; i < to.length; i++) {
                addressTo[i] = new InternetAddress(to[i]);
            }
            message.setRecipients(Message.RecipientType.TO, addressTo);

            message.setSubject(subject);
            message.addHeader("X-Priority", "1");

            // ===== Mail Body =====
            MimeBodyPart bodyPart = new MimeBodyPart();
            bodyPart.setContent(messageBody, "text/html");

            // ===== Attachment =====
            MimeBodyPart attachmentPart = new MimeBodyPart();
            DataSource source = new FileDataSource(attachmentPath);
            attachmentPart.setDataHandler(new DataHandler(source));
            attachmentPart.setFileName(attachmentName);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(bodyPart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);

            Transport.send(message);

            System.out.println("✅ Mail sent successfully");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private static class SMTPAuthenticator extends Authenticator {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(
                    TestConfig.from,
                    TestConfig.password
            );
        }
    }
}
