package org.noctisdev.sciallhexvsg.auth.infraestructure.repository;

import org.noctisdev.sciallhexvsg.auth.domain.models.TokenType;
import org.noctisdev.sciallhexvsg.auth.domain.repository.ITokenTypeRepository;
import org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.ITokenTypeMapper;
import org.noctisdev.sciallhexvsg.auth.infraestructure.repository.jpa.TokenTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TokenTypeRepositoryImpl implements ITokenTypeRepository {

    @Autowired
    private TokenTypeRepository jpaRepository;

    @Autowired
    private ITokenTypeMapper mapper;

    @Override
    public TokenType find(String tokenType) {
        return mapper.toDomain(jpaRepository.findByType(tokenType).orElseThrow());
    }
}
