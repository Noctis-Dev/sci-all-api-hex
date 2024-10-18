package org.noctisdev.sciallhexvsg.auth.infraestructure.repository;

import jakarta.persistence.EntityNotFoundException;
import org.noctisdev.sciallhexvsg.auth.domain.models.Token;
import org.noctisdev.sciallhexvsg.auth.domain.repository.ITokenRepository;
import org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.ITokenMapper;
import org.noctisdev.sciallhexvsg.auth.infraestructure.repository.jpa.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TokenRepositoryImpl implements ITokenRepository {

    @Autowired
    private TokenRepository jpaRepository;

    @Autowired
    private ITokenMapper mapper;

    @Override
    public Token save(Token token) {
        return mapper.toDomain(jpaRepository.save(mapper.toEntity(token)));
    }

    @Override
    public Token find(String token) {
        return mapper.toDomain(jpaRepository.findByToken(token).orElseThrow(EntityNotFoundException::new));
    }
}
