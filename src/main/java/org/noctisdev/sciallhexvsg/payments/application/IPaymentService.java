package org.noctisdev.sciallhexvsg.payments.application;

import org.noctisdev.sciallhexvsg.payments.application.dto.request.PaymentRequest;
import org.noctisdev.sciallhexvsg.shared.BaseResponse;

public interface IPaymentService {
    BaseResponse generatePayment(PaymentRequest payment);
}
