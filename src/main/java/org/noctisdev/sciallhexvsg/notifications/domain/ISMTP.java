package org.noctisdev.sciallhexvsg.notifications.domain;

public interface ISMTP {

    void sendEmail(String to, String subject, String body);

}
