package org.noctisdev.sciallhexvsg.auth.domain.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class Token {
    private Long id;

    @NotBlank
    private String token;

    @NotNull
    private LocalDate expirationDate;

    @NotNull
    private TokenType tokenType;
}