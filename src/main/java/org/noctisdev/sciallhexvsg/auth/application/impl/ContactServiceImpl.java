package org.noctisdev.sciallhexvsg.auth.application.impl;

import org.noctisdev.sciallhexvsg.auth.application.IContactService;
import org.noctisdev.sciallhexvsg.auth.infraestructure.dto.response.ContactResponse;
import org.noctisdev.sciallhexvsg.notifications.domain.ISMTP;
import org.noctisdev.sciallhexvsg.auth.domain.models.Contact;
import org.noctisdev.sciallhexvsg.auth.domain.repository.IContactRepository;
import org.noctisdev.sciallhexvsg.auth.infraestructure.dto.request.ContactRequest;
import org.noctisdev.sciallhexvsg.shared.BaseResponse;
import org.noctisdev.sciallhexvsg.shared.utils.ThreadsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ContactServiceImpl implements IContactService {

    @Autowired
    private IContactRepository repository;

    @Autowired
    private ISMTP smtp;

    @Override
    public BaseResponse createContact(ContactRequest contact) {
        Contact savedContact = repository.create(toContact(contact));

        ThreadsUtil.runTask(() -> {
            smtp.sendEmail(savedContact.getEmail(), "SCI - WELCOME", "Welcome to our platform");
        });

        return BaseResponse.builder()
                .data(toContactResponse(savedContact))
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .status(200).build();
    }

    @Override
    public Contact find(UUID uuid) {
        return repository.find(uuid);
    }

    private Contact toContact(ContactRequest request) {
        Contact contact = new Contact();

        contact.setPhoneNumber(request.phoneNumber());
        contact.setEmail(request.email());

        return contact;
    }

    private ContactResponse toContactResponse(Contact contact) {
        return new ContactResponse(
                contact.getId(),
                contact.getContactUuid(),
                contact.getPhoneNumber(),
                contact.getEmail()
        );
    }
}
