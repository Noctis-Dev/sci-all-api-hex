package org.noctisdev.sciallhexvsg.auth.infraestructure.repository.jpa;

import org.noctisdev.sciallhexvsg.auth.infraestructure.entities.CredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialRepository extends JpaRepository<CredentialEntity, Long> {
}