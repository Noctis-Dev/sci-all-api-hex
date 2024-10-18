package org.noctisdev.sciallhexvsg.auth.application.impl;

import org.noctisdev.sciallhexvsg.auth.application.ITokenTypeService;
import org.noctisdev.sciallhexvsg.auth.domain.models.TokenType;
import org.noctisdev.sciallhexvsg.auth.domain.repository.ITokenTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenTypeServiceImpl implements ITokenTypeService {

    @Autowired
    private ITokenTypeRepository repository;

    @Override
    public TokenType find(String type) {
        return repository.find(type);
    }
}
