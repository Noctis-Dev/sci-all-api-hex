package org.noctisdev.sciallhexvsg.auth.application;

import org.noctisdev.sciallhexvsg.auth.domain.models.TokenSetting;
import org.noctisdev.sciallhexvsg.auth.domain.models.enums.TokenType;

public interface ITokenSettingsService {
    TokenSetting find(TokenType type);
}
