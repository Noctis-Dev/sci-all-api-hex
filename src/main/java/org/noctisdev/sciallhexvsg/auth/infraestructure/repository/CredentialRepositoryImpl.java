package org.noctisdev.sciallhexvsg.auth.infraestructure.repository;

import jakarta.persistence.EntityNotFoundException;
import org.noctisdev.sciallhexvsg.auth.domain.models.Credential;
import org.noctisdev.sciallhexvsg.auth.domain.repository.ICredentialRepository;
import org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.ICredentialMapper;
import org.noctisdev.sciallhexvsg.auth.infraestructure.repository.jpa.CredentialEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CredentialRepositoryImpl implements ICredentialRepository {

    @Autowired
    private ICredentialMapper mapper;

    @Autowired
    private CredentialEntityRepository jpaRepository;

    @Override
    public Credential create(Credential credentialEntity) {
        return mapper.toDomain(jpaRepository.save(mapper.toEntity(credentialEntity)));
    }

    @Override
    public Credential find(UUID credentialUuid) {
        return jpaRepository.findByCredentialUuid(credentialUuid)
                .map(mapper::toDomain).orElseThrow(EntityNotFoundException::new);
    }
}
