package org.noctisdev.sciallhexvsg.auth.infraestructure.repository;

import org.noctisdev.sciallhexvsg.auth.domain.models.User;
import org.noctisdev.sciallhexvsg.auth.domain.repository.IUserRepository;
import org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.IUserMapper;
import org.noctisdev.sciallhexvsg.auth.infraestructure.repository.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryImpl implements IUserRepository {

    @Autowired
    private UserRepository jpaRepository;

    @Autowired
    private IUserMapper mapper;

    @Override
    public User create(User userEntity) {
        return mapper.toDomain(jpaRepository.save(mapper.toEntity(userEntity)));
    }
}
