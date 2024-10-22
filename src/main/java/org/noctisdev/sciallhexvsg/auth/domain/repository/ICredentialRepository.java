package org.noctisdev.sciallhexvsg.auth.domain.repository;

import org.noctisdev.sciallhexvsg.auth.domain.models.Credential;

import java.util.UUID;

public interface ICredentialRepository {

    Credential create(Credential credentialEntity);
    Credential find(UUID credentialUuid);

}
