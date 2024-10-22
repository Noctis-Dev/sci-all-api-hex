package org.noctisdev.sciallhexvsg.payments.domain.repository;

import org.noctisdev.sciallhexvsg.payments.domain.models.PaymentProfile;

import java.util.UUID;

public interface IPaymentProfileRepository {
    PaymentProfile save(PaymentProfile paymentProfile);
    PaymentProfile findByUuid(UUID uuid);
}
