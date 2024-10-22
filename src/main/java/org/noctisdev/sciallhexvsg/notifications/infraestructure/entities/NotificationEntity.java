package org.noctisdev.sciallhexvsg.notifications.infraestructure.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.noctisdev.sciallhexvsg.notifications.infraestructure.entities.enums.NotificationChannelEntity;
import org.noctisdev.sciallhexvsg.notifications.infraestructure.entities.enums.NotificationTypeEntity;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "notifications")
public class NotificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id", nullable = false)
    private Long id;

    @NotNull
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "notification_uuid", nullable = false, length = 36)
    private UUID notificationUuid;

    @NotNull
    @Column(name = "send_date", nullable = false)
    private LocalDate sendDate;

    @Size(max = 255)
    @NotNull
    @Column(name = "`to`", nullable = false)
    private String to;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "notification_channel", nullable = false)
    private NotificationChannelEntity notificationChannel;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "notification_type", nullable = false)
    private NotificationTypeEntity notificationType;

}