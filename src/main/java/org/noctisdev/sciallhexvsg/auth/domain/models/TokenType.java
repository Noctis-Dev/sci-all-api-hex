package org.noctisdev.sciallhexvsg.auth.domain.models;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class TokenType implements Serializable {
    Long id;
    @NotNull
    String type;
}