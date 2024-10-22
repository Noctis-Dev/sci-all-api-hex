package org.noctisdev.sciallhexvsg.notifications.domain.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UUID;
import org.noctisdev.sciallhexvsg.notifications.domain.model.enums.NotificationChannel;
import org.noctisdev.sciallhexvsg.notifications.domain.model.enums.NotificationType;

import java.time.LocalDate;

@Getter @Setter
public class Notification {
    private Long id;

    @UUID
    private java.util.UUID uuid;

    @NotNull
    private LocalDate sendDate;

    @NotNull
    private String to;

    @NotNull
    private NotificationChannel notificationChannel;

    @NotNull
    private NotificationType notificationType;

}
