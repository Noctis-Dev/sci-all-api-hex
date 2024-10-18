package org.noctisdev.sciallhexvsg.auth.domain.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter @Setter
public class Credential {
    private Long id;

    @NotNull
    @org.hibernate.validator.constraints.UUID
    private UUID credentialUuid;

    @NotNull
    private LocalDate verifiedAt;

    @NotNull
    private LocalDate createdAt;

    @NotNull
    @Size(max = 255)
    private String password;

    @NotNull
    private Token token;
}