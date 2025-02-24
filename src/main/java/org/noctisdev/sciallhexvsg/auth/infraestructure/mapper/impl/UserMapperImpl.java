package org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.impl;

import org.noctisdev.sciallhexvsg.auth.domain.models.enums.UserStatus;
import org.noctisdev.sciallhexvsg.auth.infraestructure.entities.UserEntity;
import org.noctisdev.sciallhexvsg.auth.infraestructure.entities.enums.UserStatusEntity;
import org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.IContactMapper;
import org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.ICredentialMapper;
import org.noctisdev.sciallhexvsg.auth.domain.models.User;
import org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements IUserMapper {

    @Autowired
    private IContactMapper contactMapper;

    @Override
    public User toDomain(UserEntity entity) {
        User user = new User();

        user.setId(entity.getId());
        user.setUserUuid(entity.getUserUuid());
        user.setCreatedAt(entity.getCreatedAt());
        user.setActivatedAt(entity.getActivatedAt());
        user.setDeletedAt(entity.getDeletedAt());
        user.setStatus(UserStatus.valueOf(entity.getStatus().name()));
        user.setContact(contactMapper.toDomain(entity.getContactEntity()));

        return user;
    }

    @Override
    public UserEntity toEntity(User model) {
        UserEntity userEntity = new UserEntity();

        userEntity.setId(model.getId());
        userEntity.setUserUuid(model.getUserUuid());
        userEntity.setCreatedAt(model.getCreatedAt());
        userEntity.setActivatedAt(model.getActivatedAt());
        userEntity.setDeletedAt(model.getDeletedAt());
        userEntity.setStatus(UserStatusEntity.valueOf(model.getStatus().name()));
        userEntity.setContactEntity(contactMapper.toEntity(model.getContact()));

        return userEntity;
    }
}
