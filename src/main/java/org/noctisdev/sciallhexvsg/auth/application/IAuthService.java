package org.noctisdev.sciallhexvsg.auth.application;

import org.noctisdev.sciallhexvsg.auth.infraestructure.dto.request.CredentialRequest;
import org.noctisdev.sciallhexvsg.shared.BaseResponse;

import java.util.UUID;

public interface IAuthService {

    BaseResponse signUp(CredentialRequest request);
    BaseResponse verifyToken(String token, UUID credentialUuid);

}
