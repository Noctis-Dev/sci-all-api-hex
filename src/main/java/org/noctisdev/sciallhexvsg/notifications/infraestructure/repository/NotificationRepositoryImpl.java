package org.noctisdev.sciallhexvsg.notifications.infraestructure.repository;

import org.noctisdev.sciallhexvsg.notifications.domain.model.Notification;
import org.noctisdev.sciallhexvsg.notifications.domain.repository.INotificationRepository;
import org.noctisdev.sciallhexvsg.notifications.infraestructure.mapper.INotificationMapper;
import org.noctisdev.sciallhexvsg.notifications.infraestructure.repository.jpa.NotificationEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationRepositoryImpl implements INotificationRepository {

    @Autowired
    private NotificationEntityRepository repository;

    @Autowired
    private INotificationMapper mapper;

    @Override
    public Notification save(Notification notification) {
        return mapper.toDomain(repository.save(mapper.toEntity(notification)));
    }
}
