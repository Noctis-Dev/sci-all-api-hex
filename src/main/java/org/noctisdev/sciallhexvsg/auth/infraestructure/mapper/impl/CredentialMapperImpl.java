package org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.impl;

import org.noctisdev.sciallhexvsg.auth.domain.models.Credential;
import org.noctisdev.sciallhexvsg.auth.infraestructure.entities.CredentialEntity;
import org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.ICredentialMapper;
import org.springframework.stereotype.Component;

@Component
public class CredentialMapperImpl implements ICredentialMapper {

    @Override
    public Credential toDomain(CredentialEntity entity) {
        Credential credential = new Credential();

        credential.setId(entity.getId());
        credential.setCredentialUuid(entity.getCredentialUuid());
        credential.setVerifiedAt(entity.getVerifiedAt());
        credential.setCreatedAt(entity.getCreatedAt());
        credential.setPassword(entity.getPassword());

        return credential;
    }

    @Override
    public CredentialEntity toEntity(Credential model) {
        return null;
    }

}
