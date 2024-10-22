package org.noctisdev.sciallhexvsg.notifications.infraestructure.listeners;

import org.noctisdev.sciallhexvsg.auth.domain.events.NotificationWhatsappEvent;
import org.noctisdev.sciallhexvsg.notifications.application.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationWhatsappEventListener {

    @Autowired
    private INotificationService service;

    @EventListener
    public void handleNotification(NotificationWhatsappEvent event) {
        service.sendWhatsapp(event.getDestination(), event.getMessage());
    }

}
