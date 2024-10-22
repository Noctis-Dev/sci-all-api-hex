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
    private Long id;

    @NotBlank
    @UUID
    private java.util.UUID paymentUuid;

    private Double amount;

    private PaymentProfile paymentProfile;
}
