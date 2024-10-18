package org.noctisdev.sciallhexvsg.auth.domain.repository;

import org.noctisdev.sciallhexvsg.auth.domain.models.TokenType;

public interface ITokenTypeRepository {
    TokenType find(String tokenType);
}
