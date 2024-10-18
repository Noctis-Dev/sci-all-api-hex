package org.noctisdev.sciallhexvsg.auth.infraestructure.repository;

import jakarta.persistence.EntityNotFoundException;
import org.noctisdev.sciallhexvsg.auth.domain.models.TokenSetting;
import org.noctisdev.sciallhexvsg.auth.domain.repository.ITokenSettingsRepository;
import org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.ITokenSettingsMapper;
import org.noctisdev.sciallhexvsg.auth.infraestructure.repository.jpa.TokenSettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TokenSettingsRepositoryImpl implements ITokenSettingsRepository {

    @Autowired
    private TokenSettingRepository jpaRepository;

    @Autowired
    private ITokenSettingsMapper mapper;

    @Override
    public TokenSetting findActive() {
        return mapper.toDomain(jpaRepository.findByIsActive(Boolean.TRUE).orElseThrow(EntityNotFoundException::new));
    }
}
