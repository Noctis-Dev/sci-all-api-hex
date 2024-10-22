package org.noctisdev.sciallhexvsg.notifications.application.impl;

import org.noctisdev.sciallhexvsg.notifications.application.IWhatsappService;
import org.noctisdev.sciallhexvsg.notifications.domain.external.INotify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WhatsappServiceImpl implements IWhatsappService {

    @Autowired
    private INotify notify;

    @Override
    public void sendMessage(String message, String phoneNumber) {
        notify.sendMessage(message, phoneNumber);
    }
}
