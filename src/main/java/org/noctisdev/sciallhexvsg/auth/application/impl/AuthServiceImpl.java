package org.noctisdev.sciallhexvsg.auth.application.impl;

import org.noctisdev.sciallhexvsg.auth.application.*;
import org.noctisdev.sciallhexvsg.auth.domain.events.NotificationWhatsappEvent;
import org.noctisdev.sciallhexvsg.auth.domain.models.Contact;
import org.noctisdev.sciallhexvsg.auth.domain.models.Credential;
import org.noctisdev.sciallhexvsg.auth.domain.models.Token;
import org.noctisdev.sciallhexvsg.auth.domain.models.enums.UserStatus;
import org.noctisdev.sciallhexvsg.auth.infraestructure.dto.request.CredentialRequest;
import org.noctisdev.sciallhexvsg.auth.infraestructure.dto.response.SignUpResponse;
import org.noctisdev.sciallhexvsg.auth.infraestructure.dto.response.UserResponse;
import org.noctisdev.sciallhexvsg.shared.BaseResponse;
import org.noctisdev.sciallhexvsg.auth.domain.models.User;
import org.noctisdev.sciallhexvsg.shared.utils.ThreadsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

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
    private ApplicationEventPublisher publisher;

    @Override
    public BaseResponse signUp(CredentialRequest request) {
        Contact contact = contactService.find(request.contactUuid());
        Token savedToken = tokenService.createToken();

        ThreadsUtil.runTask(() -> {
            NotificationWhatsappEvent event = new NotificationWhatsappEvent(this);
            event.setDestination(contact.getPhoneNumber());
            event.setMessage("SCI-ALL Verification Code: " + savedToken.getToken());
            publisher.publishEvent(event);
        });

        Credential savedCredential = credentialService.create(request, savedToken, contact);
        User savedUser = userService.create(contact);

        SignUpResponse response = new SignUpResponse();
        response.setUserUuid(savedUser.getUserUuid());
        response.setContactUuid(contact.getContactUuid());
        response.setCredentialUuid(savedCredential.getCredentialUuid());

        return BaseResponse.builder()
                .data(response)
                .message("The user account was created successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .status(200).build();
    }

    @Override
    public BaseResponse verifyToken(String token, UUID credentialUuid) {
        Credential credential = credentialService.find(credentialUuid);
        User user = credential.getContact().getUser();

        if (!credential.getToken().getToken().equals(token)) {
            throw new RuntimeException();
        }

        user.setActivatedAt(LocalDate.now());
        user.setStatus(UserStatus.ACTIVE);
        credential.setVerifiedAt(LocalDate.now());

        return BaseResponse.builder()
                .data(toUserResponse(user))
                .message("Credential verified successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .status(200).build();
    }

    private UserResponse toUserResponse(User user) {
        return new UserResponse(
            user.getUserUuid(),
            user.getCreatedAt(),
            user.getActivatedAt(),
            user.getDeletedAt(),
            user.getStatus()
        );
    }

}
