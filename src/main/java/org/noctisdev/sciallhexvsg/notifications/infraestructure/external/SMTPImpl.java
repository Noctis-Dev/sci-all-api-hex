package org.noctisdev.sciallhexvsg.notifications.infraestructure.external;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.noctisdev.sciallhexvsg.notifications.domain.external.ISMTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class SMTPImpl implements ISMTP {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(String to, String subject, String body) {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Error sending email", e);
        }
    }
}
