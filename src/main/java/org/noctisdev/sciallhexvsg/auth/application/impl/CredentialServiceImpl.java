package org.noctisdev.sciallhexvsg.auth.application.impl;

import org.noctisdev.sciallhexvsg.auth.application.ICredentialService;
import org.noctisdev.sciallhexvsg.auth.domain.models.Credential;
import org.noctisdev.sciallhexvsg.auth.domain.repository.ICredentialRepository;
import org.noctisdev.sciallhexvsg.auth.infraestructure.dto.request.CredentialRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CredentialServiceImpl implements ICredentialService {

    @Autowired
    private ICredentialRepository repository;

    @Override
    public Credential create(CredentialRequest request) {
        return repository.create(toCredential(request));
    }

    private Credential toCredential(CredentialRequest request) {
        Credential credential = new Credential();

        credential.setCredentialUuid(UUID.randomUUID());
        credential.setPassword(request.password());

        return credential;
    }
}
