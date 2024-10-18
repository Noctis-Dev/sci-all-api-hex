package org.noctisdev.sciallhexvsg.auth.domain.repository;

import org.noctisdev.sciallhexvsg.auth.domain.models.Contact;

import java.util.UUID;

public interface IContactRepository {
    Contact create(Contact contact);
    Contact find(UUID uuid);
}
