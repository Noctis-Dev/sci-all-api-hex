package org.noctisdev.sciallhexvsg.auth.application;

import org.noctisdev.sciallhexvsg.auth.infraestructure.dto.request.CredentialRequest;
import org.noctisdev.sciallhexvsg.shared.BaseResponse;

public interface IAuthService {

    BaseResponse signUp(CredentialRequest request);

}
