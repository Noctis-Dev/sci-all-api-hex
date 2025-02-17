package org.noctisdev.sciallhexvsg.auth.infraestructure.controller;

import org.noctisdev.sciallhexvsg.auth.application.IAuthService;
import org.noctisdev.sciallhexvsg.shared.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("verify")
public class VerifyCredentialController {

    @Autowired
    private IAuthService service;

    @GetMapping("credential/{credentialUuid}")
    public ResponseEntity<BaseResponse> verifyCredential(@PathVariable UUID credentialUuid,
                                                         @RequestParam String token) {
        return service.verifyToken(token, credentialUuid).apply();
    }

}
