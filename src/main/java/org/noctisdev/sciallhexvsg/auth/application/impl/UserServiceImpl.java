package org.noctisdev.sciallhexvsg.auth.application.impl;

import org.noctisdev.sciallhexvsg.auth.application.IUserService;
import org.noctisdev.sciallhexvsg.auth.domain.models.Contact;
import org.noctisdev.sciallhexvsg.auth.domain.models.Credential;
import org.noctisdev.sciallhexvsg.auth.domain.models.User;
import org.noctisdev.sciallhexvsg.auth.domain.models.enums.UserStatus;
import org.noctisdev.sciallhexvsg.auth.domain.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository repository;

    @Override
    public User find(UUID userUuid) {
        return repository.find(userUuid);
    }

    @Override
    public User create(Contact contact) {
        User user = new User();

        user.setUserUuid(UUID.randomUUID());
        user.setCreatedAt(LocalDate.now());
        user.setStatus(UserStatus.INACTIVE);
        user.setContact(contact);

        return repository.create(user);
    }
}
