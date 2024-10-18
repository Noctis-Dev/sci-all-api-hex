package org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.impl;

import org.noctisdev.sciallhexvsg.auth.domain.models.Token;
import org.noctisdev.sciallhexvsg.auth.infraestructure.entities.TokenEntity;
import org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.ITokenMapper;
import org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.ITokenTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TokenMapperImpl implements ITokenMapper {

    @Autowired
    private ITokenTypeMapper tokenTypeMapper;

    @Override
    public Token toDomain(TokenEntity entity) {
        Token token = new Token();

        token.setId(entity.getId());
        token.setToken(entity.getToken());
        token.setExpirationDate(entity.getExpirationDate());
        token.setTokenType(tokenTypeMapper.toDomain(entity.getTokenTypeEntity()));

        return token;
    }

    @Override
    public TokenEntity toEntity(Token model) {
        TokenEntity tokenEntity = new TokenEntity();

        tokenEntity.setId(model.getId());
        tokenEntity.setToken(model.getToken());
        tokenEntity.setExpirationDate(model.getExpirationDate());
        tokenEntity.setTokenTypeEntity(tokenTypeMapper.toEntity(model.getTokenType()));

        return tokenEntity;
    }
}
