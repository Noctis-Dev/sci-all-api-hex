package org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.impl;

import org.noctisdev.sciallhexvsg.auth.domain.models.Contact;
import org.noctisdev.sciallhexvsg.auth.infraestructure.entities.ContactEntity;
import org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.IContactMapper;
import org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ContactMapperImpl implements IContactMapper {

    @Autowired
    @Qualifier("contactUserMapperImpl")
    private IUserMapper userMapper;

    @Override
    public Contact toDomain(ContactEntity entity) {
        Contact contact = new Contact();

        contact.setId(entity.getId());
        contact.setContactUuid(entity.getContactUuid());
        contact.setPhoneNumber(entity.getPhoneNumber());
        contact.setEmail(entity.getEmail());
        contact.setCreatedAt(entity.getCreatedAt());
        contact.setUser(userMapper.toDomain(entity.getUserEntity()));

        return contact;
    }

    @Override
    public ContactEntity toEntity(Contact model) {
        ContactEntity contactEntity = new ContactEntity();

        contactEntity.setId(model.getId());
        contactEntity.setContactUuid(model.getContactUuid());
        contactEntity.setPhoneNumber(model.getPhoneNumber());
        contactEntity.setEmail(model.getEmail());
        contactEntity.setCreatedAt(model.getCreatedAt());
        contactEntity.setUserEntity(userMapper.toEntity(model.getUser()));

        return contactEntity;
    }
}
