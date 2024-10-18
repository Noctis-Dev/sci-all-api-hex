package org.noctisdev.sciallhexvsg.auth.domain.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.noctisdev.sciallhexvsg.auth.infraestructure.entities.ContactEntity;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link ContactEntity}
 */
@Getter
@Setter
public class Contact implements Serializable {
    private Long id;

    @NotNull
    @org.hibernate.validator.constraints.UUID
    private UUID contactUuid;

    @Size(max = 15)
    private String phoneNumber;

    @Size(max = 70)
    private String email;
}