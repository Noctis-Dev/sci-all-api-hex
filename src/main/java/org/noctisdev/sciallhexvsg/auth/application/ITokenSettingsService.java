package org.noctisdev.sciallhexvsg.auth.application;

import org.noctisdev.sciallhexvsg.auth.domain.models.TokenSetting;

public interface ITokenSettingsService {
    TokenSetting find();
}
