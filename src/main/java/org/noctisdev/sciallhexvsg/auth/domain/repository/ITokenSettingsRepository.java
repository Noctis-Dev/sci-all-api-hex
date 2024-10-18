package org.noctisdev.sciallhexvsg.auth.domain.repository;

import org.noctisdev.sciallhexvsg.auth.domain.models.TokenSetting;

public interface ITokenSettingsRepository {
    TokenSetting findActive();
}
