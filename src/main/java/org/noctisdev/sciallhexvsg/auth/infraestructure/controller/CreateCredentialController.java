package org.noctisdev.sciallhexvsg.auth.infraestructure.controller;

import org.noctisdev.sciallhexvsg.auth.application.IAuthService;
import org.noctisdev.sciallhexvsg.auth.infraestructure.dto.request.CredentialRequest;
import org.noctisdev.sciallhexvsg.shared.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("credential")
public class CreateCredentialController {

    @Autowired
    private IAuthService service;

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody CredentialRequest request) {
        return service.signUp(request).apply();
    }

}
