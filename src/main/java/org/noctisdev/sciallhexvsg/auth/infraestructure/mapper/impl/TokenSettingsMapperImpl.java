package org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.impl;

import org.noctisdev.sciallhexvsg.auth.domain.models.TokenSetting;
import org.noctisdev.sciallhexvsg.auth.infraestructure.entities.TokenSettingEntity;
import org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.ITokenSettingsMapper;
import org.springframework.stereotype.Component;

@Component
public class TokenSettingsMapperImpl implements ITokenSettingsMapper {

    @Override
    public TokenSetting toDomain(TokenSettingEntity entity) {
        TokenSetting tokenSetting = new TokenSetting();

        tokenSetting.setId(entity.getId());
        tokenSetting.setIsActive(entity.getIsActive());
        tokenSetting.setAuthTokenExpirationDays(entity.getAuthTokenExpirationDays());
        tokenSetting.setVerifyTokenExpirationDays(entity.getVerifyTokenExpirationDays());

        return tokenSetting;
    }

    @Override
    public TokenSettingEntity toEntity(TokenSetting model) {
        TokenSettingEntity tokenSettingEntity = new TokenSettingEntity();

        tokenSettingEntity.setId(model.getId());
        tokenSettingEntity.setIsActive(model.getIsActive());
        tokenSettingEntity.setAuthTokenExpirationDays(model.getAuthTokenExpirationDays());
        tokenSettingEntity.setVerifyTokenExpirationDays(model.getVerifyTokenExpirationDays());

        return tokenSettingEntity;
    }

}
