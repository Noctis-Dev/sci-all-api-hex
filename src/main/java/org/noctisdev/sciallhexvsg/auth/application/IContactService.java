package org.noctisdev.sciallhexvsg.auth.application;

import org.noctisdev.sciallhexvsg.auth.domain.models.Contact;
import org.noctisdev.sciallhexvsg.auth.infraestructure.dto.request.ContactRequest;
import org.noctisdev.sciallhexvsg.shared.BaseResponse;

import java.util.UUID;

public interface IContactService {
    BaseResponse createContact(ContactRequest contact);
    Contact find(UUID uuid);
}
