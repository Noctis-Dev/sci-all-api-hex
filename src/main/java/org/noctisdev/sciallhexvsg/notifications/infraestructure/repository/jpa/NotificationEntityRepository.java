package org.noctisdev.sciallhexvsg.notifications.infraestructure.repository.jpa;

import org.noctisdev.sciallhexvsg.notifications.infraestructure.entities.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationEntityRepository extends JpaRepository<NotificationEntity, Long> {
  }