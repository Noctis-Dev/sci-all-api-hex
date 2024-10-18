package org.noctisdev.sciallhexvsg.payments.application;

import org.noctisdev.sciallhexvsg.payments.application.dto.request.PaymentRequest;
import org.noctisdev.sciallhexvsg.payments.domain.models.Payment;

public interface IPaymentService {
    Payment generatePayment(PaymentRequest payment);
}
