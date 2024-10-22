package org.noctisdev.sciallhexvsg.auth.application;

import org.noctisdev.sciallhexvsg.auth.domain.models.Contact;
import org.noctisdev.sciallhexvsg.auth.domain.models.Credential;
import org.noctisdev.sciallhexvsg.auth.domain.models.Token;
import org.noctisdev.sciallhexvsg.auth.infraestructure.dto.request.CredentialRequest;

import java.util.UUID;

public interface ICredentialService {

    Credential create(CredentialRequest request, Token token, Contact contact);
    Credential find(UUID credentialUuid);

}
