package org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.impl;

import org.noctisdev.sciallhexvsg.auth.domain.models.Credential;
import org.noctisdev.sciallhexvsg.auth.infraestructure.entities.ContactEntity;
import org.noctisdev.sciallhexvsg.auth.infraestructure.entities.CredentialEntity;
import org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.IContactMapper;
import org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.ICredentialMapper;
import org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.ITokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CredentialMapperImpl implements ICredentialMapper {

    @Autowired
    private ITokenMapper tokenMapper;

    @Autowired
    private IContactMapper contactMapper;

    @Override
    public Credential toDomain(CredentialEntity entity) {
        Credential credential = new Credential();

        credential.setId(entity.getId());
        credential.setCredentialUuid(entity.getCredentialUuid());
        credential.setPassword(entity.getPassword());
        credential.setVerifiedAt(entity.getVerifiedAt());
        credential.setCreatedAt(entity.getCreatedAt());
        credential.setContact(contactMapper.toDomain(entity.getContactEntity()));
        credential.setToken(tokenMapper.toDomain(entity.getTokenEntity()));

        return credential;
    }

    @Override
    public CredentialEntity toEntity(Credential model) {
        CredentialEntity credentialEntity = new CredentialEntity();

        credentialEntity.setId(model.getId());
        credentialEntity.setCredentialUuid(model.getCredentialUuid());
        credentialEntity.setPassword(model.getPassword());
        credentialEntity.setVerifiedAt(model.getVerifiedAt());
        credentialEntity.setCreatedAt(model.getCreatedAt());
        credentialEntity.setContactEntity(contactMapper.toEntity(model.getContact()));
        credentialEntity.setTokenEntity(tokenMapper.toEntity(model.getToken()));

        return credentialEntity;
    }

}
