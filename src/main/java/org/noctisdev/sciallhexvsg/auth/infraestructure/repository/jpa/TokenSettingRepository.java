package org.noctisdev.sciallhexvsg.auth.infraestructure.repository.jpa;

import org.noctisdev.sciallhexvsg.auth.infraestructure.entities.TokenSettingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenSettingRepository extends JpaRepository<TokenSettingEntity, Long> {

    Optional<TokenSettingEntity> findByIsActive(boolean isActive);

}