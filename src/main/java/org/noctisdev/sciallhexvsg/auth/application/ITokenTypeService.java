package org.noctisdev.sciallhexvsg.auth.application;

import org.noctisdev.sciallhexvsg.auth.domain.models.TokenType;

public interface ITokenTypeService {

    TokenType find(String type);

}
