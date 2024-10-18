package org.noctisdev.sciallhexvsg.auth.infraestructure.dto.request;

import org.noctisdev.sciallhexvsg.auth.infraestructure.entities.ContactEntity;

import java.io.Serializable;

/**
 * DTO for {@link ContactEntity}
 */
public record ContactRequest(
        String phoneNumber,
        String email
) implements Serializable { }