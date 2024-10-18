package org.noctisdev.sciallhexvsg.auth.infraestructure.repository;

import jakarta.persistence.EntityNotFoundException;
import org.noctisdev.sciallhexvsg.auth.domain.models.Contact;
import org.noctisdev.sciallhexvsg.auth.domain.repository.IContactRepository;
import org.noctisdev.sciallhexvsg.auth.infraestructure.mapper.IContactMapper;
import org.noctisdev.sciallhexvsg.auth.infraestructure.repository.jpa.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ContactRepositoryImpl implements IContactRepository {

    @Autowired
    private ContactRepository jpaRepository;

    @Autowired
    private IContactMapper mapper;

    @Override
    public Contact create(Contact contact) {
        return mapper.toDomain(jpaRepository.save(mapper.toEntity(contact)));
    }

    @Override
    public Contact find(UUID uuid) {
        return mapper.toDomain(jpaRepository.findByContactUuid(uuid).orElseThrow(EntityNotFoundException::new));
    }

}
