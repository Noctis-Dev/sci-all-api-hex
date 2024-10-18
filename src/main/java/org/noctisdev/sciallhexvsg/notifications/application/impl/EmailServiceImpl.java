package org.noctisdev.sciallhexvsg.notifications.application.impl;

import org.noctisdev.sciallhexvsg.notifications.application.IEmailService;
import org.noctisdev.sciallhexvsg.notifications.domain.ISMTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements IEmailService {

    @Autowired
    private ISMTP smtp;

    @Override
    public void sendEmail(String to, String subject, String body) {
        smtp.sendEmail(to, subject, body);
    }
}
