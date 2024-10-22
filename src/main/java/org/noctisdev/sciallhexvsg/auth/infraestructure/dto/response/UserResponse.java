package org.noctisdev.sciallhexvsg.auth.infraestructure.dto.response;

import org.noctisdev.sciallhexvsg.auth.domain.models.enums.UserStatus;

import java.time.LocalDate;
import java.util.UUID;

public record UserResponse(
    UUID userUuid,
    LocalDate createdAt,
    LocalDate activatedAt,
    LocalDate deletedAt,
    UserStatus status
) { }
