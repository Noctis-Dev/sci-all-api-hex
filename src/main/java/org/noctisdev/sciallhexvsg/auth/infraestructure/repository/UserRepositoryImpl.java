package org.noctisdev.sciallhexvsg.auth.infraestructure.repository;

import jakarta.persistence.EntityNotFoundException;
import org.noctisdev.sciallhexvsg.auth.domain.models.User;
import org.noctisdev.sciallhexvsg.auth.domain.repository.IUserRepository;
import org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.IUserMapper;
import org.noctisdev.sciallhexvsg.auth.infraestructure.repository.jpa.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserRepositoryImpl implements IUserRepository {

    @Autowired
    @Qualifier("userMapperImpl")
    private IUserMapper mapper;

    @Autowired
    private UserEntityRepository jpaRepository;

    @Override
    public User create(User userEntity) {
        return mapper.toDomain(jpaRepository.save(mapper.toEntity(userEntity)));
    }

    @Override
    public User find(UUID userUuid) {
        return jpaRepository.findByUserUuid(userUuid)
                .map(mapper::toDomain).orElseThrow(EntityNotFoundException::new);
    }
}
