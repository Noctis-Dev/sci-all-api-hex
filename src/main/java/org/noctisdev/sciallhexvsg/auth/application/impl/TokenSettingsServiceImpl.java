package org.noctisdev.sciallhexvsg.auth.application.impl;

import org.noctisdev.sciallhexvsg.auth.application.ITokenSettingsService;
import org.noctisdev.sciallhexvsg.auth.domain.models.TokenSetting;
import org.noctisdev.sciallhexvsg.auth.domain.models.enums.TokenType;
import org.noctisdev.sciallhexvsg.auth.domain.repository.ITokenSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenSettingsServiceImpl implements ITokenSettingsService {

    @Autowired
    private ITokenSettingsRepository repository;

    @Override
    public TokenSetting find(TokenType type) {
        return repository.findActive(type);
    }
}
