package org.noctisdev.sciallhexvsg.auth.application.impl;

import org.noctisdev.sciallhexvsg.auth.application.ITokenSettingsService;
import org.noctisdev.sciallhexvsg.auth.domain.models.TokenSetting;
import org.noctisdev.sciallhexvsg.auth.domain.repository.ITokenSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenSettingsService implements ITokenSettingsService {

    @Autowired
    private ITokenSettingsRepository repository;

    @Override
    public TokenSetting find() {
        return repository.findActive();
    }
}
