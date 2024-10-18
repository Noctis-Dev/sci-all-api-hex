package org.noctisdev.sciallhexvsg.notifications.application;

public interface IEmailService {
    void sendEmail(String to, String subject, String body);
}
