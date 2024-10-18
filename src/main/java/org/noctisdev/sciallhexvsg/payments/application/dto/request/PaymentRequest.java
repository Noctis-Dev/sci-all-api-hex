package org.noctisdev.sciallhexvsg.payments.application.dto.request;

import org.noctisdev.sciallhexvsg.payments.domain.models.PaymentType;

public record PaymentRequest(
    String paymentProfileId,
    String description,
    String type
) { }
