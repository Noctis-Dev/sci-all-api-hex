package org.noctisdev.sciallhexvsg.auth.domain.repository;

import org.noctisdev.sciallhexvsg.auth.domain.models.TokenSetting;
import org.noctisdev.sciallhexvsg.auth.domain.models.enums.TokenType;

public interface ITokenSettingsRepository {
    TokenSetting findActive(TokenType type);
}
