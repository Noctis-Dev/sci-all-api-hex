package org.noctisdev.sciallhexvsg.auth.infraestructure.repository.jpa;

import org.noctisdev.sciallhexvsg.auth.infraestructure.entities.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ContactRepository extends JpaRepository<ContactEntity, Long> {

    Optional<ContactEntity> findByPhoneNumber(String phoneNumber);

    Optional<ContactEntity> findByContactUuid(UUID uuid);

}