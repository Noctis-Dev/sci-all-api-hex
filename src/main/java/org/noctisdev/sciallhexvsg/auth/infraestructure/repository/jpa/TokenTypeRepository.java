package org.noctisdev.sciallhexvsg.auth.infraestructure.repository.jpa;

import org.noctisdev.sciallhexvsg.auth.infraestructure.entities.TokenTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenTypeRepository extends JpaRepository<TokenTypeEntity, Long> {

    Optional<TokenTypeEntity> findByType(String type);

}