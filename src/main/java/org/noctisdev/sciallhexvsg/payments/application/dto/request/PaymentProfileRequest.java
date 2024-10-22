package org.noctisdev.sciallhexvsg.payments.application.dto.request;

public record PaymentProfileRequest(
    String profileName,
    String accountEmail
) { }
