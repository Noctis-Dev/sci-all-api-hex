package org.noctisdev.sciallhexvsg.auth.application;

import org.noctisdev.sciallhexvsg.auth.domain.models.Contact;
import org.noctisdev.sciallhexvsg.auth.domain.models.User;

import java.util.UUID;

public interface IUserService {

    User find(UUID userUuid);
    User create(Contact contact);

}
