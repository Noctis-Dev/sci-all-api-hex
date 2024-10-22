package org.noctisdev.sciallhexvsg.payments.domain.repository;

import org.noctisdev.sciallhexvsg.payments.domain.models.Payment;

public interface IPaymentRepository {
    Payment save(Payment payment);
}
