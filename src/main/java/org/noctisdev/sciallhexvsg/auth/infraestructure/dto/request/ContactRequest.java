package org.noctisdev.sciallhexvsg.auth.infraestructure.dto.request;

import java.io.Serializable;

public record ContactRequest(
        String phoneNumber,
        String email
) implements Serializable { }