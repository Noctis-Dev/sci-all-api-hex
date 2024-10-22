package org.noctisdev.sciallhexvsg.payments.application.dto.response;

import java.time.LocalDate;

public record PaymentResponse(
    String paymentUrl,
    LocalDate createdAt
) { }
