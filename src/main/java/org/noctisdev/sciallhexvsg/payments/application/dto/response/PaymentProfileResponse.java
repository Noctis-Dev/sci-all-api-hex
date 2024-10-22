package org.noctisdev.sciallhexvsg.payments.application.dto.response;

import java.util.UUID;

public record PaymentProfileResponse(
    UUID paymentProfileUuid,
    String profileName,
    String accountEmail
) { }
