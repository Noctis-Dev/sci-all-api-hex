package org.noctisdev.sciallhexvsg.notifications.infraestructure.mapper.impl;

import org.noctisdev.sciallhexvsg.notifications.domain.model.Notification;
import org.noctisdev.sciallhexvsg.notifications.domain.model.enums.NotificationChannel;
import org.noctisdev.sciallhexvsg.notifications.domain.model.enums.NotificationType;
import org.noctisdev.sciallhexvsg.notifications.infraestructure.entities.NotificationEntity;
import org.noctisdev.sciallhexvsg.notifications.infraestructure.entities.enums.NotificationChannelEntity;
import org.noctisdev.sciallhexvsg.notifications.infraestructure.entities.enums.NotificationTypeEntity;
import org.noctisdev.sciallhexvsg.notifications.infraestructure.mapper.INotificationMapper;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapperImpl implements INotificationMapper {
    @Override
    public Notification toDomain(NotificationEntity entity) {
        Notification notification = new Notification();

        notification.setId(entity.getId());
        notification.setUuid(entity.getNotificationUuid());
        notification.setTo(entity.getTo());
        notification.setSendDate(entity.getSendDate());
        notification.setNotificationChannel(NotificationChannel.valueOf(entity.getNotificationChannel().name()));
        notification.setNotificationType(NotificationType.valueOf(entity.getNotificationType().name()));

        return notification;
    }

    @Override
    public NotificationEntity toEntity(Notification domain) {
        NotificationEntity notificationEntity = new NotificationEntity();

        notificationEntity.setId(domain.getId());
        notificationEntity.setNotificationUuid(domain.getUuid());
        notificationEntity.setTo(domain.getTo());
        notificationEntity.setSendDate(domain.getSendDate());
        notificationEntity.setNotificationChannel(NotificationChannelEntity.valueOf(domain.getNotificationChannel().name()));
        notificationEntity.setNotificationType(NotificationTypeEntity.valueOf(domain.getNotificationType().name()));

        return notificationEntity;
    }
}
