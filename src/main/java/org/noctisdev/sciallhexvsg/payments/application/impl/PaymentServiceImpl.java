package org.noctisdev.sciallhexvsg.payments.application.impl;

import org.noctisdev.sciallhexvsg.payments.application.IPaymentService;
import org.noctisdev.sciallhexvsg.payments.application.dto.request.PaymentRequest;
import org.noctisdev.sciallhexvsg.payments.domain.external.IPayments;
import org.noctisdev.sciallhexvsg.payments.domain.models.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements IPaymentService {

    @Autowired
    private IPayments payments;

    @Override
    public Payment generatePayment(PaymentRequest payment) {
        return null;
    }
}
