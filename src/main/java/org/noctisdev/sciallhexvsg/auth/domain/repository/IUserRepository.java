package org.noctisdev.sciallhexvsg.auth.domain.repository;

import org.noctisdev.sciallhexvsg.auth.domain.models.User;

public interface IUserRepository {

    User create(User userEntity);

}
