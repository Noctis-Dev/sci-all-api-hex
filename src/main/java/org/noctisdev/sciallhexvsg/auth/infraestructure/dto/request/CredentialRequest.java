package org.noctisdev.sciallhexvsg.auth.infraestructure.dto.request;

import java.util.UUID;

public record CredentialRequest(
    UUID contactUuid,
    String password
) {}
