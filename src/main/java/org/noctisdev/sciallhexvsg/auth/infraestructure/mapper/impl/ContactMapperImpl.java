package org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.impl;

import org.noctisdev.sciallhexvsg.auth.domain.models.Contact;
import org.noctisdev.sciallhexvsg.auth.infraestructure.entities.ContactEntity;
import org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.IContactMapper;
import org.springframework.stereotype.Component;

@Component
public class ContactMapperImpl implements IContactMapper {
    @Override
    public Contact toDomain(ContactEntity entity) {
        Contact contact = new Contact();

        contact.setId(entity.getId());
        contact.setContactUuid(entity.getContactUuid());
        contact.setPhoneNumber(entity.getPhoneNumber());
        contact.setEmail(entity.getEmail());

        return contact;
    }

    @Override
    public ContactEntity toEntity(Contact model) {
        ContactEntity contactEntity = new ContactEntity();

        contactEntity.setId(model.getId());
        contactEntity.setContactUuid(model.getContactUuid());
        contactEntity.setPhoneNumber(model.getPhoneNumber());
        contactEntity.setEmail(model.getEmail());

        return contactEntity;
    }
}
