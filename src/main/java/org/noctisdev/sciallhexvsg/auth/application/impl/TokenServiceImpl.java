package org.noctisdev.sciallhexvsg.auth.application.impl;

import org.noctisdev.sciallhexvsg.auth.application.ITokenService;
import org.noctisdev.sciallhexvsg.auth.application.ITokenSettingsService;
import org.noctisdev.sciallhexvsg.auth.application.ITokenTypeService;
import org.noctisdev.sciallhexvsg.auth.domain.models.Token;
import org.noctisdev.sciallhexvsg.auth.domain.repository.ITokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;;

@Service
public class TokenServiceImpl implements ITokenService {

    @Autowired
    private ITokenRepository repository;

    @Autowired
    private ITokenTypeService tokenTypeService;

    @Autowired
    private ITokenSettingsService tokenSettingsService;

    @Override
    public Token createToken() {
        Token token = new Token();

        token.setToken(generateSixDigitCode());
        token.setExpirationDate(LocalDate.now().plusDays(tokenSettingsService.find().getVerifyTokenExpirationDays()));
        token.setTokenType(tokenTypeService.find("VERIFICATION"));

        return repository.save(token);
    }

    @Override
    public Token find(String token) {
        return repository.find(token);
    }

    private String generateSixDigitCode() {
        return String.valueOf((int) (Math.random() * 9000) + 1000);
    }
}
