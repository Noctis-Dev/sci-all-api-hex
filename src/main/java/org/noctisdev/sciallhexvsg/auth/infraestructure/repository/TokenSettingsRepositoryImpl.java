package org.noctisdev.sciallhexvsg.auth.infraestructure.repository;

import jakarta.persistence.EntityNotFoundException;
import org.noctisdev.sciallhexvsg.auth.domain.models.TokenSetting;
import org.noctisdev.sciallhexvsg.auth.domain.models.enums.TokenType;
import org.noctisdev.sciallhexvsg.auth.domain.repository.ITokenSettingsRepository;
import org.noctisdev.sciallhexvsg.auth.infraestructure.entities.enums.TokenTypeEntity;
import org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.ITokenSettingsMapper;
import org.noctisdev.sciallhexvsg.auth.infraestructure.repository.jpa.TokenSettingEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TokenSettingsRepositoryImpl implements ITokenSettingsRepository {

    @Autowired
    private ITokenSettingsMapper mapper;

    @Autowired
    private TokenSettingEntityRepository jpaRepository;

    @Override
    public TokenSetting findActive(TokenType type) {
        return jpaRepository.findByTokenTypeEntityAndIsActive(TokenTypeEntity.valueOf(type.name()), true)
                .map(mapper::toDomain).orElseThrow(EntityNotFoundException::new);
    }
}
