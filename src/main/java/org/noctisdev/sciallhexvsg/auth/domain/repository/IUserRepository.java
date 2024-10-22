package org.noctisdev.sciallhexvsg.auth.domain.repository;

import org.noctisdev.sciallhexvsg.auth.domain.models.User;

import java.util.UUID;

public interface IUserRepository {

    User create(User userEntity);
    User find(UUID userUuid);

}
