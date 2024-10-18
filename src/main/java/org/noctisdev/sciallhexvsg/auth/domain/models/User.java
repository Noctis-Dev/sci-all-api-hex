package org.noctisdev.sciallhexvsg.auth.domain.models;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter @Setter
public class User {
    private Long id;
    @NotNull
    private UUID userUuid;
    @NotNull
    private Credential credential;
    @NotNull
    private Contact contact;
}