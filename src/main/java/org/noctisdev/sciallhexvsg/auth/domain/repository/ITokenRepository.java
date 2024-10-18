package org.noctisdev.sciallhexvsg.auth.domain.repository;

import org.noctisdev.sciallhexvsg.auth.domain.models.Token;

public interface ITokenRepository {
    Token save(Token token);
    Token find(String token);
}
