package org.noctisdev.sciallhexvsg.auth.domain.events;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter @Setter
public class NotificationWhatsappEvent extends ApplicationEvent {

    @NotNull
    private String destination;

    @NotNull
    private String message;

    public NotificationWhatsappEvent(Object source) {
        super(source);
    }
}
