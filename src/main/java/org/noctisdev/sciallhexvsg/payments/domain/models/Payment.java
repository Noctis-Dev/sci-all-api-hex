package org.noctisdev.sciallhexvsg.payments.domain.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UUID;

import java.time.LocalDate;

@Getter @Setter
public class Payment {

    @NotNull
    private Long paymentId;

    @NotBlank
    @UUID
    private String paymentUuid;

    @NotBlank
    private String description;

    @NotNull
    private LocalDate date;

    @NotBlank
    private String paymentUrl;

    private PaymentType paymentType;
}
