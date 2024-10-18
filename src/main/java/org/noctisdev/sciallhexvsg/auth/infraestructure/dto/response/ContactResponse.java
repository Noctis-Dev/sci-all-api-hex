package org.noctisdev.sciallhexvsg.auth.infraestructure.dto.response;

import org.noctisdev.sciallhexvsg.auth.infraestructure.entities.ContactEntity;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link ContactEntity}
 */
public record ContactResponse(
        Long id,
        UUID contactUuid,
        String phoneNumber,
        String email
) implements Serializable { }