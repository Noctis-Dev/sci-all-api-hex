package org.noctisdev.sciallhexvsg.auth.application;

import org.noctisdev.sciallhexvsg.auth.domain.models.Credential;
import org.noctisdev.sciallhexvsg.auth.infraestructure.dto.request.CredentialRequest;

public interface ICredentialService {

    Credential create(CredentialRequest request);

}
