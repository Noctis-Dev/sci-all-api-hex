package org.noctisdev.sciallhexvsg.notifications.infraestructure.listeners;

import org.noctisdev.sciallhexvsg.auth.domain.events.NotificationEmailEvent;
import org.noctisdev.sciallhexvsg.notifications.application.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationEmailEventListener {

    @Autowired
    private INotificationService service;

    @EventListener
    public void handleNotification(NotificationEmailEvent event) {
        service.sendEmail(event.getTo(), event.getSubject(), event.getBody());
    }

}
