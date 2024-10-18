package org.noctisdev.sciallhexvsg.auth.infraestructure.repository.jpa;

import org.noctisdev.sciallhexvsg.auth.infraestructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}