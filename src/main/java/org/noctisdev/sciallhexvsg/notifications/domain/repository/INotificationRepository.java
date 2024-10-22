package org.noctisdev.sciallhexvsg.notifications.domain.repository;

import org.noctisdev.sciallhexvsg.notifications.domain.model.Notification;

public interface INotificationRepository {

    Notification save(Notification notification);

}
