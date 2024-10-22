package org.noctisdev.sciallhexvsg.auth.domain.events;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter @Setter
public class NotificationEmailEvent extends ApplicationEvent {

    private String to;
    private String subject;
    private String body;

    public NotificationEmailEvent(Object source) {
        super(source);
    }
}
