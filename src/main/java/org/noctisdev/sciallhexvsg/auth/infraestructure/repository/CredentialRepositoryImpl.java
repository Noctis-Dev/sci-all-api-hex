package org.noctisdev.sciallhexvsg.auth.infraestructure.repository;

import org.noctisdev.sciallhexvsg.auth.domain.models.Credential;
import org.noctisdev.sciallhexvsg.auth.domain.repository.ICredentialRepository;
import org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.ICredentialMapper;
import org.noctisdev.sciallhexvsg.auth.infraestructure.repository.jpa.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CredentialRepositoryImpl implements ICredentialRepository {

    @Autowired
    private CredentialRepository jpaRepository;

    @Autowired
    private ICredentialMapper mapper;

    @Override
    public Credential create(Credential credentialEntity) {
        return mapper.toDomain(jpaRepository.save(mapper.toEntity(credentialEntity)));
    }
}
