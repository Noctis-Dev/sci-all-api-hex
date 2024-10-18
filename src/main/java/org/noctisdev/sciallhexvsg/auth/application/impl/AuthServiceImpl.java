package org.noctisdev.sciallhexvsg.auth.application.impl;

import org.noctisdev.sciallhexvsg.auth.application.*;
import org.noctisdev.sciallhexvsg.auth.domain.models.Contact;
import org.noctisdev.sciallhexvsg.auth.domain.models.Credential;
import org.noctisdev.sciallhexvsg.auth.domain.models.Token;
import org.noctisdev.sciallhexvsg.auth.infraestructure.dto.request.CredentialRequest;
import org.noctisdev.sciallhexvsg.auth.infraestructure.dto.response.SignUpResponse;
import org.noctisdev.sciallhexvsg.notifications.application.INotifyService;
import org.noctisdev.sciallhexvsg.shared.BaseResponse;
import org.noctisdev.sciallhexvsg.auth.domain.models.User;
import org.noctisdev.sciallhexvsg.shared.utils.ThreadsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private ICredentialService credentialService;

    @Autowired
    private ITokenService tokenService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IContactService contactService;

    @Autowired
    private INotifyService notifyService;

    @Override
    public BaseResponse signUp(CredentialRequest request) {
        Contact contact = contactService.find(request.contactUuid());

        Credential savedCredential = credentialService.create(request);
        Token savedToken = tokenService.createToken();
        User savedUser = userService.create(savedCredential, contact);

        ThreadsUtil.runTask(() -> {
            notifyService.sendMessage("SCI-ALL Verify code: " + savedToken.getToken(), contact.getPhoneNumber());
        });

        SignUpResponse response = new SignUpResponse();
        response.setUserUuid(savedUser.getUserUuid());
        response.setContactUuid(savedUser.getContact().getContactUuid());
        response.setCredentialUuid(savedUser.getCredential().getCredentialUuid());

        return BaseResponse.builder()
                .data(response)
                .message("The user account was created successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .status(200).build();
    }

}
