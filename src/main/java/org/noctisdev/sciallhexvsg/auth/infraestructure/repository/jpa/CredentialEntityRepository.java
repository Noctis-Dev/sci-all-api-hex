package org.noctisdev.sciallhexvsg.auth.infraestructure.repository.jpa;

import org.noctisdev.sciallhexvsg.auth.infraestructure.entities.CredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CredentialEntityRepository extends JpaRepository<CredentialEntity, Long> {

    Optional<CredentialEntity> findByCredentialUuid(UUID credentialUuid);

}