package org.noctisdev.sciallhexvsg.payments.domain.models;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class PaymentProfile {
    private Long id;
    private UUID paymentProfileUuid;
    private String profileName;
    private String accountEmail;
}
