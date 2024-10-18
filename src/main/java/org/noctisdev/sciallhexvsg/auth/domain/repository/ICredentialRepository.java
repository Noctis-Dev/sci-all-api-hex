package org.noctisdev.sciallhexvsg.auth.domain.repository;

import org.noctisdev.sciallhexvsg.auth.domain.models.Credential;

public interface ICredentialRepository {

    Credential create(Credential credentialEntity);

}
