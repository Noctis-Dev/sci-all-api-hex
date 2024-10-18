package org.noctisdev.sciallhexvsg.auth.application;

import org.noctisdev.sciallhexvsg.auth.domain.models.Token;

public interface ITokenService {
    Token createToken();
    Token find(String token);
}
