package org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.impl;

import org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.IContactMapper;
import org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.ICredentialMapper;
import org.noctisdev.sciallhexvsg.auth.domain.models.User;
import org.noctisdev.sciallhexvsg.auth.infraestructure.entities.UserEntity;
import org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseMapperImpl implements IUserMapper {

    @Autowired
    private ICredentialMapper credentialMapper;

    @Autowired
    private IContactMapper contactMapper;

    @Override
    public User toDomain(UserEntity entity) {
        User user = new User();

        user.setId(entity.getId());
        user.setUserUuid(entity.getUserUuid());
        user.setCredential(credentialMapper.toDomain(entity.getCredentialEntity()));
        user.setContact(contactMapper.toDomain(entity.getContactEntity()));

        return user;
    }

    @Override
    public UserEntity toEntity(User model) {
        UserEntity userEntity = new UserEntity();

        userEntity.setId(model.getId());
        userEntity.setUserUuid(model.getUserUuid());
        userEntity.setCredentialEntity(credentialMapper.toEntity(model.getCredential()));
        userEntity.setContactEntity(contactMapper.toEntity(model.getContact()));

        return userEntity;
    }
}
