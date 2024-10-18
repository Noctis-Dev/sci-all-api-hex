package org.noctisdev.sciallhexvsg.notifications.application.impl;

import org.noctisdev.sciallhexvsg.notifications.application.INotifyService;
import org.noctisdev.sciallhexvsg.notifications.domain.INotify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotifyServiceImpl implements INotifyService {

    @Autowired
    private INotify notify;

    @Override
    public void sendMessage(String message, String phoneNumber) {
        notify.sendMessage(message, phoneNumber);
    }
}
