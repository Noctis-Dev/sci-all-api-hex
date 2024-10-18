package org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.impl;

import org.noctisdev.sciallhexvsg.auth.domain.models.TokenType;
import org.noctisdev.sciallhexvsg.auth.infraestructure.entities.TokenTypeEntity;
import org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.ITokenTypeMapper;
import org.springframework.stereotype.Component;

@Component
public class TokenTypeMapperImpl implements ITokenTypeMapper {

    @Override
    public TokenType toDomain(TokenTypeEntity entity) {
        TokenType tokenType = new TokenType();

        tokenType.setId(entity.getId());
        tokenType.setType(entity.getType());

        return tokenType;
    }

    @Override
    public TokenTypeEntity toEntity(TokenType model) {
        TokenTypeEntity tokenTypeEntity = new TokenTypeEntity();

        tokenTypeEntity.setId(model.getId());
        tokenTypeEntity.setType(model.getType());

        return tokenTypeEntity;
    }

}
